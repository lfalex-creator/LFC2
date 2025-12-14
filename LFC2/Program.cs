using Antlr4.Runtime;

class Program
{
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

    static void Main()
{
    string input = File.ReadAllText("../../../input.txt");

    OurCompilerLexer lexer = SetupLexer(input);
    PrintTokens(lexer);
    PrintFunctions(lexer);

    OurCompilerParser parser = SetupParser(lexer);
    parser.program();
}
}