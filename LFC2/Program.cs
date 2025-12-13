using System;
using System.Collections.Generic;
using System.IO;

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


        File.WriteAllText("../../../tokens.txt", "Tokens:\n");
        foreach (var token in tokens)
        {
            File.AppendAllText("../../../tokens.txt", $"<" +
                $"{lexer.Vocabulary.GetSymbolicName(token.Type)}, " +
                $"{token.Text}, " + $"{token.Line}" +
                $">\n");
        }
        //File.WriteAllText("../../../tokens.txt", "");
    }


    static void Main()
    {
        string input = File.ReadAllText("../../../input.txt");

        OurCompilerLexer lexer = SetupLexer(input);
        PrintTokens(lexer);

        OurCompilerParser parser = SetupParser(lexer);
        parser.program();
    }
}