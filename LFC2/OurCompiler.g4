grammar OurCompiler;

pure_data:
	INT_NUMBER
	| FLOAT_NUMBER
	| DOUBLE_NUMBER
	| STRING_LITERAL;

data_type: CONST? (INT | STRING | FLOAT | DOUBLE);

any_math_operator: PLUS | MINUS | TIMES | DIVIDED | MODULO;

math_expr:
	(VARIABLE_NAME | pure_data) any_math_operator (
		VARIABLE_NAME
		| pure_data
	) (any_math_operator (VARIABLE_NAME | pure_data))*;

comp_val: VARIABLE_NAME | pure_data;

comparer: LESS | GREAT | EQ | NEQ | LESSOREQ | GREATOREQ;

logic_link: AND | OR;

logic_expr: (comp_val comparer comp_val (logic_link logic_expr)?)
	| (
		NOT LPAR comp_val comparer comp_val (
			logic_link logic_expr
		)? RPAR
	);

crement_expr: VARIABLE_NAME (INCREMENT | DECREMENT);

program: (
		function
		| (var_declar_expr EOL)
		| (var_decl_assg_expr EOL)
	)+ EOF;

function:
	(data_type | VOID) VARIABLE_NAME LPAR (
		data_type VARIABLE_NAME (COMMA data_type VARIABLE_NAME)*
	)? RPAR LGROUP expression_generator RGROUP;

expression_generator: expression*;

expression: (
		var_declar_expr
		| var_assign_expr
		| var_decl_assg_expr
		| crement_expr
		| return_expr
		| function_call_expr
	) EOL
	| (if_expr | for_expr | while_expr);

var_declar_expr: data_type VARIABLE_NAME;

var_assign_expr:
	VARIABLE_NAME ASGN (pure_data | VARIABLE_NAME | math_expr);

var_decl_assg_expr:
	data_type VARIABLE_NAME ASGN (
		pure_data
		| VARIABLE_NAME
		| math_expr
	);

if_expr:
	IF LPAR logic_expr RPAR (
		expression
		| LGROUP expression_generator RGROUP
	) (ELSE (expression | LGROUP expression_generator RGROUP))?;

for_expr:
	FOR LPAR (var_assign_expr | var_decl_assg_expr) EOL logic_expr EOL (
		crement_expr
		| var_assign_expr
	) RPAR (expression | LGROUP expression_generator RGROUP);

while_expr:
	WHILE LPAR logic_expr RPAR (
		expression
		| LGROUP expression_generator RGROUP
	);

return_expr: RETURN (pure_data | VARIABLE_NAME | math_expr);

function_call_expr:
	VARIABLE_NAME LPAR (
		(VARIABLE_NAME | pure_data) (
			COMMA (VARIABLE_NAME | pure_data)
		)*
	)? RPAR;

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
INT_NUMBER: (NON_ZERO_DIGIT ANY_DIGIT*) | '0';
DOUBLE_NUMBER: INT_NUMBER '.' ANY_DIGIT*;
FLOAT_NUMBER: DOUBLE_NUMBER 'f';
STRING_LITERAL: '"' ('\\' . | ~["\\\r\n])* '"';