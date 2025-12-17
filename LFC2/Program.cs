using Antlr4.Runtime;
using Antlr4.Runtime.Misc;

class Program
{

    class GlobalVarVisitor : OurCompilerBaseVisitor<string>
    {
        public override string VisitPure_data([NotNull] OurCompilerParser.Pure_dataContext context)
        {
            if (context == null)
                return "";
            return context.GetChild(0).GetText();
        }
        public override string VisitProgram([NotNull] OurCompilerParser.ProgramContext context)
        {
            string result = "";
            for(int i = 0; i < context.var_declar_expr().Length; i++)
            {
                result += VisitVar_declar_expr(context.var_declar_expr(i));

            }
            for (int i = 0; i < context.var_decl_assg_expr().Length; i++)
            {
                result += VisitVar_decl_assg_expr(context.var_decl_assg_expr(i));

            }
            

            return result;
        }
        public override string VisitVar_declar_expr([NotNull] OurCompilerParser.Var_declar_exprContext context)
        {
            string type = Visit(context.data_type());
            string val = context.VARIABLE_NAME().GetText();

            return "<" + type + ", " + val + ">\n";
        }

        public override string VisitData_type([NotNull] OurCompilerParser.Data_typeContext context)
        {
            return context.GetText();
        }

        public override string VisitVar_decl_assg_expr([NotNull] OurCompilerParser.Var_decl_assg_exprContext context)
        {
            string type = Visit(context.data_type());
            string variable1 = context.VARIABLE_NAME(0).GetText();
            string pureValue = VisitPure_data(context.pure_data());
            string variable2 = "";
            if (context.VARIABLE_NAME().Length > 1)
            {
                variable2 = context.VARIABLE_NAME(1).GetText();
            }
            string expr = "";
            if (pureValue == "" && variable2 == "")
            {
                expr = VisitMath_expr(context.math_expr());
            }
            string value = pureValue != "" ? pureValue : (variable2 != "" ? variable2 : expr);
            return "<" + type + ", " + variable1 + ", " + value + ">\n";
        }

        public override string VisitMath_expr([NotNull] OurCompilerParser.Math_exprContext context)
        {
            string res = context.GetText();
            return res;
        }

        public override string VisitAny_math_operator([NotNull] OurCompilerParser.Any_math_operatorContext context)
        {
            return context.GetChild(0).GetText();
        }

    }
    private static OurCompilerLexer SetupLexer(string text)
    {
        AntlrInputStream inputStream = new AntlrInputStream(text);
        OurCompilerLexer expressionLexer = new OurCompilerLexer(inputStream);
        return expressionLexer;
    }

    private static OurCompilerParser SetupParser(OurCompilerLexer lexer)
    {
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        OurCompilerParser expressionParser = new OurCompilerParser(commonTokenStream);
        return expressionParser;
    }

    private static void PrintTokens(OurCompilerLexer lexer)
    {
        IEnumerable<IToken> tokens = lexer.GetAllTokens();
        lexer.Reset();


        File.WriteAllText("../../../tokens.txt", "Tokens:\n\n");
        foreach (var token in tokens)
        {
            File.AppendAllText("../../../tokens.txt", $"<" +
                $"{lexer.Vocabulary.GetSymbolicName(token.Type)}, " +
                $"{token.Text}, " + $"{token.Line}" +
                $">\n");
        }
        //File.WriteAllText("../../../tokens.txt", "");
    }

    private static void PrintFunctions(OurCompilerLexer lexer)
    {
        IEnumerable<IToken> tokens = lexer.GetAllTokens();
        lexer.Reset();

        File.WriteAllText("../../../funcs.txt", "Functions:\n\n");

        for (int i = 1; i<tokens.Count()-1; i++)
            if (lexer.Vocabulary.GetSymbolicName(tokens.ElementAt(i).Type)=="VARIABLE_NAME" && lexer.Vocabulary.GetSymbolicName(tokens.ElementAt(i+1).Type)=="LPAR")
            {
               int dataTypeMaybe = tokens.ElementAt(i-1).Type;
               if ((dataTypeMaybe>=3 && dataTypeMaybe<=6) || dataTypeMaybe==8)
                {
                    File.AppendAllText("../../../funcs.txt", $"<" + $"{tokens.ElementAt(i).Text}, " + (tokens.ElementAt(i).Text=="main" ? "main" : "non-main"));

                    File.AppendAllText("../../../funcs.txt", ", {");
                    if(lexer.Vocabulary.GetSymbolicName(tokens.ElementAt(i+2).Type)!="RPAR")
                    for (int j = i+2;true; j=j+3)
                    {
                        
                        if (j+2<tokens.Count()-1)
                        {
                            File.AppendAllText("../../../funcs.txt", $"{tokens.ElementAt(j).Text} {tokens.ElementAt(j+1).Text}, ");
                            if (lexer.Vocabulary.GetSymbolicName(tokens.ElementAt(j+5).Type)=="RPAR")
                            {
                                File.AppendAllText("../../../funcs.txt", $"{tokens.ElementAt(j+3).Text} {tokens.ElementAt(j+4).Text}");
                                break;
                            }
                        }
                        else
                            break;
                    }
                    File.AppendAllText("../../../funcs.txt", "}");

                    File.AppendAllText("../../../funcs.txt", ">\n");
                }

            }
    }

    private static void PrintGlobalVar(OurCompilerParser parser)
    {
        var programContext = parser.program();

        GlobalVarVisitor visitor = new GlobalVarVisitor();
        string result =  visitor.Visit(programContext);
        parser.Reset();

        File.WriteAllText("../../../globalVar.txt", result);

    }
    static void Main()
{
    string input = File.ReadAllText("../../../input.txt");

    OurCompilerLexer lexer = SetupLexer(input);
    PrintTokens(lexer);
    PrintFunctions(lexer);


    OurCompilerParser parser = SetupParser(lexer);
    //Console.Write(parser.program().ToStringTree());
    PrintGlobalVar(parser);
}
}