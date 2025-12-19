using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using System.Numerics;
using System.Text;
using System.Text.RegularExpressions;
using static System.Runtime.InteropServices.JavaScript.JSType;

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
            for (int i = 0; i < context.var_declar_expr().Length; i++)
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
        bool isRecursive = false;
        ArrayList<string> structures = new ArrayList<string>();
        ArrayList<string> ifs = new ArrayList<string>();
        ArrayList<Tuple<string, string,string>> localVariables = new ArrayList<Tuple<string, string,string>>();
        string currentFunctionName = "";
        public override string VisitFunction([NotNull] OurCompilerParser.FunctionContext context)
        {
            string returnedvalue = "<\n";

            currentFunctionName = context.GetChild(1).GetText();
            isRecursive = false;
            structures.Clear();
            ifs.Clear();
            localVariables.Clear();

            string paramList = "{";
            int fin = context.RPAR().Symbol.TokenIndex - context.GetChild(0).SourceInterval.a + 1;
            int i = context.LPAR().Symbol.TokenIndex - context.GetChild(0).SourceInterval.a + 1;
            for (; i < fin - 4; i = i + 3)
                paramList = paramList + context.GetChild(i).GetText() + " " + context.GetChild(i + 1).GetText() + ", ";
            if (i != fin - 1)
                paramList = paramList + context.GetChild(i).GetText() + " " + context.GetChild(i + 1).GetText();
            paramList = paramList + "}";

            int bodyLength = context.expression_generator().children.Count;
            for (int j = 0; j < bodyLength; j++)
                Visit(context.expression_generator().GetChild(j).GetChild(0));



            returnedvalue = returnedvalue + "Nume: " + currentFunctionName + "\n";
            returnedvalue = returnedvalue + "Tip: " + (currentFunctionName.Equals("main") ? "main, " : "non-main, ") + (isRecursive ? "recursiva" : "iterativa") + "\n";
            returnedvalue = returnedvalue + "Tip returnat: " + context.GetChild(0).GetText() + "\n";
            returnedvalue = returnedvalue + "Parametri: " + paramList + "\n";


            returnedvalue += "Strucuturi repetitive: ";
            for (i = 0; i < structures.Count - 1; i++)
                returnedvalue = returnedvalue + structures[i] + ", ";
            if (structures.Count > 0)
                returnedvalue = returnedvalue + structures[structures.Count - 1] + "\n";
            else
                returnedvalue = returnedvalue + "none\n";


            returnedvalue += "Structuri decizionale: ";
            for (i = 0; i < ifs.Count - 1; i++)
                returnedvalue = returnedvalue + ifs[i] + ", ";
            if (ifs.Count > 0)
                returnedvalue = returnedvalue + ifs[ifs.Count - 1] + "\n";
            else
                returnedvalue = returnedvalue + "none\n";


            returnedvalue += "Variabile locale: ";
            foreach (var variable in localVariables)
                returnedvalue = returnedvalue + variable + ", ";
            if (localVariables.Count > 0)
                returnedvalue = returnedvalue.Remove(returnedvalue.Length - 2) + "\n";
            else
                returnedvalue = returnedvalue + "none\n";
            return returnedvalue + ">\n\n";
        }
        public override string VisitFunction_call_expr([NotNull] OurCompilerParser.Function_call_exprContext context)
        {
            isRecursive = currentFunctionName.Equals(context.VARIABLE_NAME(0).GetText()) ? true : false;
            return "";
        }

        public override string VisitFor_expr([NotNull] OurCompilerParser.For_exprContext context)
        {
            structures.Add($"<for,{context.FOR().Symbol.Line}>");
            return base.VisitFor_expr(context);
        }
        public override string VisitWhile_expr([NotNull] OurCompilerParser.While_exprContext context)
        {
            structures.Add($"<while,{context.WHILE().Symbol.Line}>");
            return base.VisitWhile_expr(context);
        }
        public override string VisitIf_expr([NotNull] OurCompilerParser.If_exprContext context)
        {
            if (context.ELSE() != null)
                ifs.Add($"<if-else,{context.IF().Symbol.Line}>");
            else
                ifs.Add($"<if,{context.IF().Symbol.Line}>");

            return base.VisitIf_expr(context);
        }

        public override string VisitVar_declar_expr([NotNull] OurCompilerParser.Var_declar_exprContext context)
        {
            string aux;
            localVariables.Add(new Tuple<string,string, string>(context.data_type().GetText(),context.VARIABLE_NAME().GetText(), ""));
            return base.VisitVar_declar_expr(context);
        }
        public override string VisitVar_decl_assg_expr([NotNull] OurCompilerParser.Var_decl_assg_exprContext context)
        {
            string aux;
            localVariables.Add(new Tuple<string,string, string>(context.data_type().GetText(), context.GetChild(1).GetText(), context.GetChild(3).GetText()));
            return base.VisitVar_decl_assg_expr(context);
        }
        public override string VisitProgram([NotNull] OurCompilerParser.ProgramContext context)
        {
            string result = "";
            for (int i = 0; i < context.ChildCount; i++)
            {
                if (context.GetChild(i) is OurCompilerParser.FunctionContext)
                {
                    result += VisitFunction((OurCompilerParser.FunctionContext)context.GetChild(i));
                }
            }
            return result;
        }
    }

    class ErrorVisitor : OurCompilerBaseVisitor<string>
    {
        private Regex typeDef = new Regex("^((const )?int|float|double|string)$|^void$");

        private readonly StringBuilder _sb = new StringBuilder();
        private Dictionary<string, string> _globalVariables = new Dictionary<string, string>();
        private Dictionary<string, Dictionary<string, string>> _functions = new Dictionary<string, Dictionary<string, string>>();
        private HashSet<string> _functionNames = new HashSet<string>();
        private Dictionary<string, ArrayList<int>> _functionParameterNumber = new Dictionary<string, ArrayList<int>>();
        private Dictionary<string, ArrayList<ArrayList<string>>> _functionParameterTypes = new Dictionary<string, ArrayList<ArrayList<string>>>();
        public override string VisitProgram([NotNull] OurCompilerParser.ProgramContext context)
        {

            for (int i = 0; i < context.var_declar_expr().Length; i++)
            {
                VisitVar_declar_expr(context.var_declar_expr(i));
            }
            for (int i = 0; i < context.var_decl_assg_expr().Length; i++)
            {
                VisitVar_decl_assg_expr(context.var_decl_assg_expr(i));
            }
            for (int i = 0; i < context.function().Length; i++)
            {
                string funcName = context.function(i).VARIABLE_NAME(0).GetText();
                if (!_functionNames.Contains(funcName))
                {
                    _functionNames.Add(funcName);
                    _functionParameterNumber.Add(funcName, new ArrayList<int>());
                    _functionParameterNumber[funcName].Add(context.function(i).VARIABLE_NAME().Length - 1);
                    _functionParameterTypes.Add(funcName, new ArrayList<ArrayList<string>>());
                }
                string funcNameWithPar = functionNameConstructor(funcName, context.function(i));
                if (!_functions.ContainsKey(funcNameWithPar))
                {
                    _functions.Add(funcNameWithPar, new Dictionary<string, string>());
                    ArrayList<string> paramTypesList = new ArrayList<string>();
                    if (context.function(i).VOID() != null)
                    {
                        for (int j = 1; j < context.function(i).VARIABLE_NAME().Length; j++)
                        {
                            string varName = context.function(i).VARIABLE_NAME(j).GetText();
                            if (_functions[funcNameWithPar].ContainsKey(varName))
                            {
                                int line = context.function(i).Start.Line;
                                string message = $"Error: duplicated parameter '{varName}' at line {line}";
                                _sb.AppendLine(message);
                                continue;
                            }
                            string paramType = context.function(i).data_type(j - 1).GetText();
                            _functions[funcNameWithPar].Add(varName, paramType);
                            paramTypesList.Add(paramType);
                        }
                        _functionParameterTypes[funcName].Add(paramTypesList);
                        continue;
                    }
                    for (int j = 1; j < context.function(i).VARIABLE_NAME().Length; j++)
                    {
                        string varName = context.function(i).VARIABLE_NAME(j).GetText();
                        if (_functions[funcNameWithPar].ContainsKey(varName))
                        {
                            int line = context.function(i).Start.Line;
                            string message = $"Error: duplicated parameter '{varName}' at line {line}";
                            _sb.AppendLine(message);
                            continue;
                        }
                        string paramType = context.function(i).data_type(j).GetText();
                        _functions[funcNameWithPar].Add(varName, paramType);
                        paramTypesList.Add(paramType);

                    }
                    _functionParameterTypes[funcName].Add(paramTypesList);
                }
                else
                {
                    int line = context.function(i).Start.Line;
                    string message;
                    if (funcName.StartsWith("main"))
                    {
                        message = $"Error: duplicated 'main' function defined at line {line}";
                        _sb.AppendLine(message);
                        continue;
                    }
                    message = $"Error: duplicated function '{funcName}' at line {line}";
                    _sb.AppendLine(message);
                    continue;
                }
            }
            for (int i = 0; i < context.function().Length; i++)
            {
                VisitFunction(context.function(i));
            }
            return _sb.ToString();
        }

        public override string VisitVar_declar_expr([NotNull] OurCompilerParser.Var_declar_exprContext context)
        {
            string type = context.data_type().GetText();
            if (!typeDef.IsMatch(type))
            {
                int line = context.Start.Line;
                string message = $"Error: unknown type '{type}' at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }
            string varName = context.VARIABLE_NAME().GetText();

            if (IsVariableDeclared(varName, type, context))
            {
                return $"Error: duplicated variable '{varName}' at line {context.Start.Line}";
            }
            return "";
        }

        private bool IsVariableDeclared(string varName, string type, OurCompilerParser.Var_declar_exprContext context)
        {
            if (context.Parent is OurCompilerParser.ProgramContext)
            {
                if (_globalVariables.ContainsKey(varName))
                {
                    int line = context.Start.Line;
                    string message = $"Error: duplicated variable '{varName}' at line {line}";
                    _sb.AppendLine(message);
                    return true;
                }

                _globalVariables.Add(varName, type);
            }
            else if (context.Parent.Parent.Parent is OurCompilerParser.FunctionContext func)
            {
                string funcName = func.VARIABLE_NAME(0).GetText();
                funcName = functionNameConstructor(funcName, func);
                if (_functions[funcName].ContainsKey(varName))
                {
                    int line = context.Start.Line;
                    string message = $"Error: duplicated variable '{varName}' at line {line}";
                    _sb.AppendLine(message);
                    return true;
                }
                _functions[funcName].Add(varName, type);
            }
            return false;
        }
        private bool IsVariableInitializedCorrectly(string varName, string type, OurCompilerParser.Var_decl_assg_exprContext context)
        {
            if (context.Parent is OurCompilerParser.ProgramContext)
            {
                if (_globalVariables.ContainsKey(varName))
                {
                    int line = context.Start.Line;
                    string message = $"Error: duplicated variable '{varName}' at line {line}";
                    _sb.AppendLine(message);
                    return false;
                }
                if (context.VARIABLE_NAME().Length > 1)
                {
                    string assignedVarName = context.VARIABLE_NAME(1).GetText();
                    if (!_globalVariables.ContainsKey(assignedVarName))
                    {
                        int line = context.Start.Line;
                        string message = $"Error: undeclared variable '{assignedVarName}' at line {line}";
                        _sb.AppendLine(message);
                        return false;
                    }
                    string assignedVarType = _globalVariables[assignedVarName];
                    if (type != assignedVarType)
                    {
                        int line = context.Start.Line;
                        string message = $"Error: type mismatch for variable '{varName}' at line {line}";
                        _sb.AppendLine(message);
                        return false;
                    }
                }
                if (context.math_expr() != null)
                {
                    for (int i = 0; i < context.math_expr().pure_data().Length; i++)
                    {
                        dynamic exprValue = EvaluatePureData(context.math_expr().pure_data(i));
                        if (!IsTypeCompatible(type, exprValue))
                        {
                            int line = context.Start.Line;
                            string message = $"Error: type mismatch for variable '{varName}' at line {line}";
                            _sb.AppendLine(message);
                            return false;
                        }
                    }
                    for (int i = 0; i < context.math_expr().VARIABLE_NAME().Length; i++)
                    {
                        string usedVarName = context.math_expr().VARIABLE_NAME(i).GetText();
                        if (!_globalVariables.ContainsKey(usedVarName))
                        {
                            int line = context.Start.Line;
                            string message = $"Error: undeclared variable '{usedVarName}' at line {line}";
                            _sb.AppendLine(message);
                            return false;
                        }
                        if (type != _globalVariables[usedVarName])
                        {
                            int line = context.Start.Line;
                            string message = $"Error: type mismatch for variable '{varName}' at line {line}";
                            _sb.AppendLine(message);
                            return false;
                        }
                    }
                }
                _globalVariables.Add(varName, type);
            }
            else if (context.Parent.Parent.Parent is OurCompilerParser.FunctionContext func)
            {
                string funcName = func.VARIABLE_NAME(0).GetText();
                funcName = functionNameConstructor(funcName, func);
                if (_functions[funcName].ContainsKey(varName))
                {
                    int line = context.Start.Line;
                    string message = $"Error: duplicated variable '{varName}' at line {line}";
                    _sb.AppendLine(message);
                    return false;
                }
                if (context.VARIABLE_NAME().Length > 1)
                {

                    string assignedVarName = context.VARIABLE_NAME(1).GetText();
                    string assignedVarType;
                    if (!_functions[funcName].ContainsKey(assignedVarName) && !_globalVariables.ContainsKey(assignedVarName))
                    {
                        int line = context.Start.Line;
                        string message = $"Error: undeclared variable '{assignedVarName}' at line {line}";
                        _sb.AppendLine(message);
                        return false;
                    }
                    else if (!_functions[funcName].ContainsKey(assignedVarName))
                    {
                        assignedVarType = _globalVariables[assignedVarName];
                    }
                    else
                    {
                        assignedVarType = _functions[funcName][assignedVarName];
                    }
                    if (type != assignedVarType)
                    {
                        int line = context.Start.Line;
                        string message = $"Error: type mismatch for variable '{varName}' at line {line}";
                        _sb.AppendLine(message);
                        return false;
                    }
                }
                if (context.math_expr() != null)
                {
                    for (int i = 0; i < context.math_expr().pure_data().Length; i++)
                    {
                        dynamic exprValue = EvaluatePureData(context.math_expr().pure_data(i));
                        if (!IsTypeCompatible(type, exprValue))
                        {
                            int line = context.Start.Line;
                            string message = $"Error: type mismatch for variable '{varName}' at line {line}";
                            _sb.AppendLine(message);
                            return false;
                        }
                    }
                    for (int i = 0; i < context.math_expr().VARIABLE_NAME().Length; i++)
                    {
                        string usedVarName = context.math_expr().VARIABLE_NAME(i).GetText();
                        if (!_functions[funcName].ContainsKey(usedVarName))
                        {
                            int line = context.Start.Line;
                            string message = $"Error: undeclared variable '{usedVarName}' at line {line}";
                            _sb.AppendLine(message);
                            return false;
                        }
                        if (type != _functions[funcName][usedVarName])
                        {
                            int line = context.Start.Line;
                            string message = $"Error: type mismatch for variable '{varName}' at line {line}";
                            _sb.AppendLine(message);
                            return false;
                        }
                    }
                }
                _functions[funcName].Add(varName, type);
            }
            return true;
        }
        public override string VisitVar_decl_assg_expr([NotNull] OurCompilerParser.Var_decl_assg_exprContext context)
        {
            string type = context.data_type().GetText();
            if (!typeDef.IsMatch(type))
            {
                int line = context.Start.Line;
                string message = $"Error: unknown type '{type}' at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }
            string varName = context.VARIABLE_NAME(0).GetText();

            if (IsVariableInitializedCorrectly(varName, type, context))
            {
                return $"Error for variable '{varName}' at line {context.Start.Line}";
            }

            dynamic value = null;
            if (context.pure_data() != null)
            {
                value = EvaluatePureData(context.pure_data());

                if (!IsTypeCompatible(type, value))
                {
                    int line = context.Start.Line;
                    string message = $"Error: type mismatch for variable '{varName}' at line {line}";
                    _sb.AppendLine(message);
                    return message + "\n";
                }

            }

            return "";
        }

        private bool IsTypeCompatible(string type, dynamic value)
        {
            if (value == null)
                return true;
            switch (type)
            {
                case "int":
                case "const int":
                    return value is int;
                case "float":
                case "const float":
                    return value is float;
                case "double":
                case "const double":
                    return value is double;
                case "string":
                case "const string":
                    return value is string;
                default:
                    return false;
            }
        }
        private dynamic EvaluatePureData(OurCompilerParser.Pure_dataContext pureData)
        {
            if (pureData.INT_NUMBER() is not null)
            {
                return int.Parse(pureData.INT_NUMBER().GetText());
            }
            if (pureData.FLOAT_NUMBER() is not null)
            {
                return float.Parse(pureData.FLOAT_NUMBER().GetText());
            }
            if (pureData.STRING_LITERAL() is not null)
            {
                return pureData.STRING_LITERAL().GetText();
            }
            if (pureData.DOUBLE_NUMBER() is not null)
            {
                return double.Parse(pureData.DOUBLE_NUMBER().GetText());
            }
            return null;
        }
        public override string VisitFunction([NotNull] OurCompilerParser.FunctionContext context)
        {
            string type = context.GetChild(0).GetText();
            if (!typeDef.IsMatch(type))
            {
                int line = context.Start.Line;
                string message = $"Error: unknown type '{type}' at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }


            Visit(context.expression_generator());

            return "";
        }
        private string functionNameConstructor(string baseName, OurCompilerParser.FunctionContext context)
        {
            baseName = baseName + "(";
            if(context.VOID() != null)
            {
                for (int i = 1; i < context.VARIABLE_NAME().Length; i++)
                {
                    string paramType = context.data_type(i-1).GetText();
                    if (!typeDef.IsMatch(paramType))
                    {
                        int line = context.Start.Line;
                        string message = $"Error: unknown type '{paramType}' at line {line}";
                        _sb.AppendLine(message);
                        return message + "\n";
                    }
                    if (i == 1)
                        baseName = baseName + paramType;
                    else
                        baseName = baseName + ", " + paramType;
                }
                baseName = baseName + ")";
                return baseName;
            }
            for (int i = 1; i < context.VARIABLE_NAME().Length; i++)
            {
                string paramType = context.data_type(i).GetText();
                if (!typeDef.IsMatch(paramType))
                {
                    int line = context.Start.Line;
                    string message = $"Error: unknown type '{paramType}' at line {line}";
                    _sb.AppendLine(message);
                    return message + "\n";
                }
                if (i == 1)
                    baseName = baseName + paramType;
                else
                    baseName = baseName + ", " + paramType;
            }
            baseName = baseName + ")";
            return baseName;
        }
        public override string VisitExpression_generator([NotNull] OurCompilerParser.Expression_generatorContext context)
        {
            bool hasReturn = false;
            string type = context.Parent is OurCompilerParser.FunctionContext func ? func.GetChild(0).GetText() : "";
            for (int i = 0; i < context.expression().Length; i++)
            {
                if (context.expression(i).return_expr() != null)
                {
                    hasReturn = true;
                    break;
                }
            }

            if (!hasReturn && type != "void")
            {
                int line = context.Start.Line;
                string message = $"Error: missing return statement in non-void function at line {line}";
                _sb.AppendLine(message);
            }
            else if (hasReturn && type == "void")
            {
                int line = context.Start.Line;
                string message = $"Error: return statement with a value in void function at line {line}";
                _sb.AppendLine(message);
            }

            for (int i = 0; i < context.ChildCount; i++)
            {
                Visit(context.GetChild(i));
            }
            return "";
        }

        public override string VisitExpression([NotNull] OurCompilerParser.ExpressionContext context)
        {


            for (int i = 0; i < context.ChildCount; i++)
            {
                Visit(context.GetChild(i));
            }
            return "";
        }

        public override string VisitReturn_expr([NotNull] OurCompilerParser.Return_exprContext context)
        {
            string returnType = context.Parent.Parent.Parent is OurCompilerParser.FunctionContext func ? func.GetChild(0).GetText() : "";
            string funcName = context.Parent.Parent.Parent is OurCompilerParser.FunctionContext func2 ? func2.VARIABLE_NAME(0).GetText() : "";
            funcName = functionNameConstructor(funcName, (OurCompilerParser.FunctionContext)context.Parent.Parent.Parent);


            if (context.pure_data() != null)
            {
                dynamic returnValue = EvaluatePureData(context.pure_data());
                if (!IsTypeCompatible(returnType, returnValue))
                {
                    int line = context.Start.Line;
                    string message = $"Error: type mismatch in return statement at line {line}";
                    _sb.AppendLine(message);
                    return message + "\n";
                }
            }
            if (context.VARIABLE_NAME() != null)
            {
                string returnVarName = context.VARIABLE_NAME().GetText();
                if (!_functions[funcName].ContainsKey(returnVarName) && !_globalVariables.ContainsKey(returnVarName))
                {
                    int line = context.Start.Line;
                    string message = $"Error: undeclared variable '{returnVarName}' at line {line}";
                    _sb.AppendLine(message);
                    return message + "\n";
                }
                else if (_functions[funcName].ContainsKey(returnVarName))
                {
                    if (returnType != _functions[funcName][returnVarName])
                    {
                        int line = context.Start.Line;
                        string message = $"Error: type mismatch in return statement at line {line}";
                        _sb.AppendLine(message);
                        return message + "\n";
                    }
                }
                else if (_globalVariables.ContainsKey(returnVarName))
                {
                    if (returnType != _globalVariables[returnVarName])
                    {
                        int line = context.Start.Line;
                        string message = $"Error: type mismatch in return statement at line {line}";
                        _sb.AppendLine(message);
                        return message + "\n";
                    }

                }
            }
            if (context.math_expr() != null)
            {
                for (int i = 0; i < context.math_expr().pure_data().Length; i++)
                {
                    dynamic exprValue = EvaluatePureData(context.math_expr().pure_data(i));
                    if (!IsTypeCompatible(returnType, exprValue))
                    {
                        int line = context.Start.Line;
                        string message = $"Error: type mismatch in return statement at line {line}";
                        _sb.AppendLine(message);
                        return message + "\n";
                    }
                }
                for (int i = 0; i < context.math_expr().VARIABLE_NAME().Length; i++)
                {
                    string usedVarName = context.math_expr().VARIABLE_NAME(i).GetText();
                    if (!_functions[funcName].ContainsKey(usedVarName) && !_globalVariables.ContainsKey(usedVarName))
                    {
                        int line = context.Start.Line;
                        string message = $"Error: undeclared variable '{usedVarName}' at line {line}";
                        _sb.AppendLine(message);
                        return message + "\n";
                    }
                    else if (_functions[funcName].ContainsKey(usedVarName))
                    {
                        if (returnType != _functions[funcName][usedVarName])
                        {
                            int line = context.Start.Line;
                            string message = $"Error: type mismatch in return statement at line {line}";
                            _sb.AppendLine(message);
                            return message + "\n";
                        }
                    }
                    else if (_globalVariables.ContainsKey(usedVarName))
                    {
                        if (returnType != _globalVariables[usedVarName])
                        {
                            int line = context.Start.Line;
                            string message = $"Error: type mismatch in return statement at line {line}";
                            _sb.AppendLine(message);
                            return message + "\n";
                        }
                    }
                }
            }
            if (returnType == "void")
            {
                int line = context.Start.Line;
                string message = $"Error: return statement with a value in void function at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }
            return "";
        }
        public override string VisitFunction_call_expr([NotNull] OurCompilerParser.Function_call_exprContext context)
        {
            string funcName = context.VARIABLE_NAME(0).GetText();
            if (funcName == "main")
            {
                int line = context.Start.Line;
                string message = $"Error: invalid call to 'main' function at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }
            if (!_functionNames.Contains(funcName))
            {
                int line = context.Start.Line;
                string message = $"Error: undeclared function '{funcName}' at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }

            ArrayList<int> expectedParams = _functionParameterNumber[funcName];
            int totalParamsNr = context.VARIABLE_NAME().Length - 1 + context.pure_data().Length;
            if (!expectedParams.Contains(totalParamsNr))
            {
                int line = context.Start.Line;
                string message = $"Error: function '{funcName}' called with incorrect number of arguments at line {line}";
                _sb.AppendLine(message);
                return message + "\n";
            }
            var argTypes = new ArrayList<string>();
            for (int i = 1; i < context.ChildCount; i++)
            {
                var child = context.GetChild(i);
                if(child is OurCompilerParser.Pure_dataContext)
                {
                    dynamic value = EvaluatePureData((OurCompilerParser.Pure_dataContext)child);
                    if (value is int)
                        argTypes.Add("int");
                    else if (value is float)
                        argTypes.Add("float");
                    else if (value is double)
                        argTypes.Add("double");
                    else if (value is string)
                        argTypes.Add("string");
                }
                else if(child is ITerminalNode terminal)
                {
                    if(terminal.Symbol.Type == OurCompilerParser.VARIABLE_NAME)
                    {
                        string varName = terminal.GetText();
                        string varType = null;
                        bool found = false;
                        ParserRuleContext parent = context;
                        while(context.Parent !=null && !(parent is OurCompilerParser.FunctionContext))
                        {
                            parent = parent.Parent as ParserRuleContext;
                        }
                        if(parent is OurCompilerParser.FunctionContext funcContext)
                        {
                            string funcFullName = functionNameConstructor(funcContext.VARIABLE_NAME(0).GetText(), funcContext);
                            if (_functions[funcFullName].ContainsKey(varName))
                            {
                                varType = _functions[funcFullName][varName];
                                found = true;
                            }
                        }
                        if(!found && _globalVariables.ContainsKey(varName))
                        {
                            varType = _globalVariables[varName];
                            found = true;
                        }
                        if(found)
                            argTypes.Add(varType);
                        else
                        {
                            int line = context.Start.Line;
                            string message = $"Error: undeclared variable '{varName}' at line {line}";
                            _sb.AppendLine(message);
                            return message + "\n";
                        }
                    }
                }
            }
            var overloads = _functionParameterTypes[funcName];
            bool incompatible = true;
            foreach(var overload in overloads)
            {
                if(overload.Count == totalParamsNr)
                {
                    bool match = true;
                    for(int i = 0; i < overload.Count; i++)
                    {
                        if(overload[i] != argTypes[i])
                        {
                            match = false;
                            incompatible = true;
                            break;
                        }
                    }
                    if (match) return "";
                }
            }
            if (incompatible)
            {
                int line = context.Start.Line;
                string message = $"Error: function '{funcName}' called with incorrect argument types at line {line}";
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
            File.AppendAllText(_path, $"line {line}:{charPositionInLine} {msg}");
        }
    }
    class FileLexerErrorListener : IAntlrErrorListener<int>
    {
        private readonly string _path;
        public FileLexerErrorListener(string path) { _path = path; }

        public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            File.AppendAllText(_path, $"line {line}:{charPositionInLine} {msg}");
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
        File.WriteAllText("../../../funcs.txt", "Functions:\n" + functions + "\n");

    }

    private static void PrintGlobalVar(OurCompilerParser parser)
    {
        var programContext = parser.program();

        GlobalVarVisitor visitor = new GlobalVarVisitor();
        string result = visitor.Visit(programContext);
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