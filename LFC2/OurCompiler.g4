grammar OurCompiler;

program: expression EOF;
expression: (var_declar_expr | var_assign_expr) EOL expression?;
var_declar_expr: (INT | STRING | FLOAT | DOUBLE) VARIABLE_NAME;
var_assign_expr:
	VARIABLE_NAME ASGN (
		INT_NUMBER
		| FLOAT_NUMBER
		| DOUBLE_NUMBER
		| STRING_LITERAL
	);

/*Helpers
 
 */
fragment ANY_LETTER: [A-Za-z];
fragment NON_ZERO_DIGIT: [1-9];
fragment ANY_DIGIT: '0' | NON_ZERO_DIGIT;
/*Comments
 
 */
LINECOMMENT: '//' .*? '\n' -> skip;
BIGCOMMENT: '/*' .*? '*/' -> skip;

/*Reserved words
 
 */
fragment NON_VOID_TYPE: INT | STRING | FLOAT | DOUBLE;
fragment ANY_TYPE: VOID | NON_VOID_TYPE;
INT: 'int';
FLOAT: 'float';
DOUBLE: 'double';
STRING: 'string';
CONST: 'const';
VOID: 'void';
IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
RETURN: 'return';

/*Operators
 
 */
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDED: '/';
MODULO: '%';

AND: '&&';
OR: '||';
NOT: '!';

ASGN: '=';
ASGN_PLUS: '+=';
ASGN_MINUS: '-=';
ASGN_TIMES: '*=';
ASGN_DIVIDED: '/=';
ASGN_MODULO: '%=';

LESS: '<';
GREAT: '>';
EQ: '==';
NEQ: '!=';
LESSOREQ: '<=';
GREATOREQ: '>=';

INCREMENT: '++';
DECREMENT: '--';

/*Parentheses
 
 */
LPAR: '(';
RPAR: ')';
LGROUP: '{';
RGROUP: '}';

/*Others
 
 */
EOL: ';';
COMMA: ',';
WS: [ \t\r\n]+ -> skip;
VARIABLE_NAME: ANY_LETTER (ANY_DIGIT | ANY_LETTER | '_')*;
INT_NUMBER: NON_ZERO_DIGIT ANY_DIGIT*;
DOUBLE_NUMBER: INT_NUMBER '.' ANY_DIGIT*;
FLOAT_NUMBER: DOUBLE_NUMBER 'f';
STRING_LITERAL: '"' .*? '"';