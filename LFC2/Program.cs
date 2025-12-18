using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using System.Numerics;
using System.Text;
using System.Text.RegularExpressions;

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

    class FunctionVisitor : OurCompilerBaseVisitor<string>
    {
        public override string VisitFunction([NotNull] OurCompilerParser.FunctionContext context)
        {
            string functionName = context.GetChild(1).GetText();
            string paramList = ", {";
            int fin=context.RPAR().Symbol.TokenIndex-context.GetChild(0).SourceInterval.a+1;
            int i = context.LPAR().Symbol.TokenIndex-context.GetChild(0).SourceInterval.a+1;
            for (; i<fin-4;i=i+3)
                paramList=paramList + context.GetChild(i).GetText() +" "+ context.GetChild(i+1).GetText()+", ";

            if(i!=fin-1)
                paramList=paramList + context.GetChild(i).GetText() +" "+ context.GetChild(i+1).GetText();
            paramList=paramList+"}";
            return "<" + functionName + (functionName.Equals("main")?", main":", non-main") + paramList +">\n";
        }
        public override string VisitProgram([NotNull] OurCompilerParser.ProgramContext context)
        {
            string result = "";
            for (int i = 0; i < context.ChildCount; i++)
            {
                if(context.GetChild(i) is OurCompilerParser.FunctionContext)
                {
                    result += VisitFunction((OurCompilerParser.FunctionContext)context.GetChild(i));
                }
            }
            return result;
        }
    }

    class ErrorVisitor : OurCompilerBaseVisitor<string>
    {
        private readonly StringBuilder _sb = new StringBuilder();

        public override string VisitProgram([NotNull] OurCompilerParser.ProgramContext context)
        {
            //for (int i = 0; i < context.function().Length; i++)
            //{
            //    VisitFunction(context.function(i));
            //}
            for (int i = 0; i < context.var_declar_expr().Length; i++)
            {
                VisitVar_declar_expr(context.var_declar_expr(i));
            }
            return _sb.ToString();
        }

        public override string VisitVar_declar_expr([NotNull] OurCompilerParser.Var_declar_exprContext context)
        {
            Regex typeDef = new Regex("^((const )?int|float|double|string)$|^void$");
            string type = context.GetChild(0).GetText();
            if (!typeDef.IsMatch(type))
            {
                int line = context.Start?.Line ?? 0;
                string message = $"Error: unknown type '{type}' at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }
            return "";
        }

        public override string VisitFunction([NotNull] OurCompilerParser.FunctionContext context)
        {
            Regex typeDef = new Regex("^((const )?int|float|double|string)$|^void$");
            string type = context.GetChild(0).GetText();
            if (!typeDef.IsMatch(type))
            {
                int line = context.Start?.Line ?? 0;
                string message = $"Error: unknown type '{type}' at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }
            return "";
        }
    }
    class FileErrorListener : BaseErrorListener
    {
        private readonly string _path;
        public FileErrorListener(string path) { _path = path; }

        public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            File.AppendAllText(_path, $"line {line}:{charPositionInLine} {msg}\n");
        }
    }
    class FileLexerErrorListener : IAntlrErrorListener<int>
    {
        private readonly string _path;
        public FileLexerErrorListener(string path) { _path = path; }

        public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            File.AppendAllText(_path, $"line {line}:{charPositionInLine} {msg}\n");
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

    private static void PrintFunctions(OurCompilerParser parser)
    {
        var programContext = parser.program();
        FunctionVisitor functionVisitor = new FunctionVisitor();
        string functions = functionVisitor.Visit(programContext);
        parser.Reset();
        File.WriteAllText("../../../funcs.txt", "Functions:\n"+functions+"\n");

    }

    private static void PrintGlobalVar(OurCompilerParser parser)
    {
        var programContext = parser.program();

        GlobalVarVisitor visitor = new GlobalVarVisitor();
        string result =  visitor.Visit(programContext);
        parser.Reset();

        File.WriteAllText("../../../globalVar.txt", result);

    }

    private static void PrintErrors(OurCompilerParser parser)
    {
        var programContext = parser.program();

        ErrorVisitor visitor = new ErrorVisitor();
        string result = visitor.Visit(programContext);
        parser.Reset();

        File.WriteAllText("../../../errors.txt", result);
    }
    static void Main()
{
    string input = File.ReadAllText("../../../input.txt");

    File.WriteAllText("../../../errors.txt", "");

        OurCompilerLexer lexer = SetupLexer(input);
        lexer.RemoveErrorListeners();
        lexer.AddErrorListener(new FileLexerErrorListener("../../../errors.txt"));
        PrintTokens(lexer);


    OurCompilerParser parser = SetupParser(lexer);

        parser.RemoveErrorListeners();
        parser.AddErrorListener(new FileErrorListener("../../../errors.txt"));
        PrintErrors(parser);
        PrintGlobalVar(parser);
    PrintFunctions(parser);
    }
}