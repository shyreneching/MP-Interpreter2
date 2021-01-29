/**
 * You can test with
 *
 *  $ antlr4 Java8.g4
 *  $ javac *.java
 *  $ grun Java8 compilationUnit *.java
 */

grammar PseudoCode;

literal
	:	IntegerLiteral
	|	FloatingPointLiteral
	|	BooleanLiteral
	|	StringLiteral
	;

numericType
	:	integralType
	|	floatingPointType
	;

integralType
	:	'int'
	;

floatingPointType
	:	'float'
	;

dims
    :   '[' ']'
	;

expressionName
	:	Identifier
	;

methodName
	:	Identifier
	;

compilationUnit
    :   classBodyDeclaration* mainDeclaration classBodyDeclaration* EOF
	;

mainDeclaration
    :   'main' '(' ')' block
    ;

classBodyDeclaration
	:	classMemberDeclaration
	;

classMemberDeclaration
	:	methodDeclaration
	;

variableDeclaratorList
	:	variableDeclarator (',' variableDeclarator)*
	;

variableDeclarator
	:	variableDeclaratorId ('=' variableInitializer)?
	|   unannType ('=' variableInitializer)? {notifyErrorListeners("declaring keyword as variable name");}
	;

variableDeclaratorId
    :   Identifier
	;

variableInitializer
	:	expression
	|	arrayInitializer
	;

unannType
	:	unannPrimitiveType
	;

unannPrimitiveType
	:	numericType
	|	'bool'
	|   'String'
	;

methodDeclaration
    :   'func' result ('['']')? methodDeclarator block
    |   'func' methodDeclarator block {notifyErrorListeners("lacking return type");}
    |   'func' result ('['']')? methodDeclarator {notifyErrorListeners("lacking function body");}
	;

result
	:	unannType
	|	'void'
	;

methodDeclarator
	:	Identifier '(' formalParameterList? ')'
	|	Identifier '(' formalParameterList? {notifyErrorListeners("uneven parenthesis, lacking ')'");}
	|	Identifier formalParameterList? ')' {notifyErrorListeners("uneven parenthesis, lacking '('");}
	;

formalParameterList
    :   formalParameters
	;

formalParameters
	:	formalParameter (',' formalParameter)*
    |   (formalParameter (',' formalParameter)*)? formalParameter formalParameters {notifyErrorListeners("no separator found in parameters");}
    |   ','* ',' formalParameters {notifyErrorListeners("lacking parameter");}
    |   formalParameters ',' ','* {notifyErrorListeners("lacking parameter");}
    |   formalParameters ',' ',' ','* formalParameters {notifyErrorListeners("lacking parameter");}
	;

formalParameter
    :   unannType ('['']')? variableDeclaratorId
    |   variableDeclaratorId {notifyErrorListeners("no specified data type");}
    |   unannType ('['']')? {notifyErrorListeners("no parameter name");}
	;

arrayInitializer
    :   'create' unannType '[' additiveExpression ']'
	;

block
	:	'{' blockStatements? '}'
	;

blockStatements
	:	blockStatement+
	|   blockStatement* returnStatement
	;

blockStatement
	:	localVariableDeclarationStatement
	|	statement
	;

localVariableDeclarationStatement
	:	localVariableDeclaration ';'
	;

localVariableDeclaration
    :   ('constant') unannType variableDeclaratorList
    |   unannType '[' additiveExpression ']' variableDeclaratorList
    |   Identifier unannType dims? variableDeclaratorList {notifyErrorListeners("identifier found before data type in the declaration");}
	;

statement
	:	block
	|   statementWithoutTrailingSubstatement
	|	ifThenStatement
	|	whileStatement
    |	doStatement
	|	forStatement
	;

statementWithoutTrailingSubstatement
	:	emptyStatement
	|	expressionStatement
	|	breakStatement
	|	continueStatement
	|	returnStatement
	;

emptyStatement
	:	';'
	;

expressionStatement
	:	statementExpression ';'
	;

statementExpression
	:	assignment
	|   printInvocation
	|   scanInvocation
	|	methodInvocation
	;

printInvocation
    :   'print' '(' ((StringLiteral | Identifier ('[' additiveExpression ']')?) ('+' (StringLiteral | Identifier ('[' additiveExpression ']')?))*)? ')'
    |   'print' '(' ((StringLiteral | Identifier ('[' additiveExpression ']')?) ('+' (StringLiteral | Identifier ('[' additiveExpression ']')?))*)? '+'')' {notifyErrorListeners("additional ‘+’ sign at end of print");}
    |   'print' '(' ((StringLiteral | ~(StringLiteral | Identifier | ')') | Identifier ('[' additiveExpression ']')?) (StringLiteral | ~(StringLiteral | Identifier | ')') | Identifier ('[' additiveExpression ']')?) (StringLiteral | ~(StringLiteral | Identifier | ')') | Identifier ('[' additiveExpression ']')?)*) ')' {notifyErrorListeners("lacking 'double quotes' in print statement");}
    |   'print' '(' ~(StringLiteral | Identifier | ')') ')' {notifyErrorListeners("lacking 'double quotes' in print statement");}
    ;

scanInvocation
    :   'scan' '(' (StringLiteral | Identifier) ('+' (StringLiteral | Identifier))* ',' Identifier ('[' additiveExpression ']')? ')'
    ;

ifThenStatement
    : 'if' '(' onlyConditionalExpression ')' 'then' block ('else' 'if' '(' onlyConditionalExpression ')' 'then' block)* ('else' 'then' block)?
	;

whileStatement
    :	'while' Identifier ('[' additiveExpression ']')? 'up to' additiveExpression block
    |   'while' Identifier ('[' additiveExpression ']')? 'down to' additiveExpression block
    |   'while' Identifier ('[' additiveExpression ']')? (StringLiteral | Identifier ('[' additiveExpression ']'))+ additiveExpression block {notifyErrorListeners("wrong syntax for 'while loop' should contain 'up to' or 'down to' keyword");}
	;

doStatement
    :   'do' block 'while' Identifier ('[' additiveExpression ']')? 'up to' additiveExpression
    |   'do' block 'while' Identifier ('[' additiveExpression ']')? 'down to' additiveExpression
    |   'do' block 'while' Identifier ('[' additiveExpression ']')? (StringLiteral | Identifier ('[' additiveExpression ']')?)+ additiveExpression {notifyErrorListeners("wrong syntax for 'do while loop' should contain 'up to' or 'down to' keyword");}
	;

forStatement
	:   pseudoForStatement
    ;

pseudoForStatement
    :   forheader block
    ;

forheader
    : 'for' forInit 'up to' additiveExpression
    | 'for' forInit 'down to' additiveExpression
    | 'for' forInit (StringLiteral | Identifier ('[' additiveExpression ']')?)+ additiveExpression {notifyErrorListeners("wrong syntax for 'for loop' should contain 'up to' or 'down to' keyword");}
    ;

forInit
    :   forinitializer
	;

forinitializer
    :	unannType? variableDeclaratorId customAssignError
    |   variableDeclaratorId '[' additiveExpression ']' customAssignError
    |	Identifier ('[' additiveExpression ']')?
    ;

customAssignError
    :	'=' variableInitializer
    |   {notifyErrorListeners("did not find assignment operator");}
    ;

breakStatement
    :   'break' ';'
	;

continueStatement
	:	'continue' ';'
	;

returnStatement
	:	'return' expression? ';'
	;

primary
	:	primaryNoNewArray_lfno_primary
	;

primaryNoNewArray_lfno_primary
	:	literal
	|	'(' expression ')'
	|	arrayAccess_lfno_primary
	|	methodInvocation_lfno_primary
	;

arrayAccess
	:	expressionName '[' additiveExpression ']'
	;

arrayAccess_lfno_primary
	:	expressionName '[' additiveExpression ']'
	;

methodInvocation
    :   methodName '(' argumentList? ')'
	|	methodName '(' argumentList? ')''(' argumentList? ')'{notifyErrorListeners("redundant parentheses");}
	|   methodName '(' argumentList? {notifyErrorListeners("uneven parenthesis, lacking ')'");}
	|   methodName argumentList? ')' {notifyErrorListeners("uneven parenthesis, lacking '('");}
	;

methodInvocation_lfno_primary
	:	methodName '(' argumentList? ')'
	|   methodName '(' argumentList? ')''(' argumentList? ')'{notifyErrorListeners("redundant parentheses");}
    |   methodName '(' argumentList? {notifyErrorListeners("no closing parenthesis");}
	;

argumentList
	:	expression (',' expression)*
	|   (expression (',' expression)*)? expression argumentList {notifyErrorListeners("no separator found in parameters");}
	|   ','* ',' argumentList {notifyErrorListeners("lacking parameter");}
	|   argumentList ',' ','* {notifyErrorListeners("lacking parameter");}
	|   argumentList ',' ',' ','* argumentList {notifyErrorListeners("lacking parameter");}
	;

expression
    :   assignmentExpression errorParenthesis
    |   '(' ')' assignmentExpression  {notifyErrorListeners("redundant parenthesis");}
    |   ')' assignmentExpression  {notifyErrorListeners("uneven parenthesis, lacking '('");}
    |   '('  assignmentExpression   {notifyErrorListeners("uneven parenthesis, lacking ')'");}
    |   unaryExpression unaryExpression  {notifyErrorListeners("no operators found");}
	;

errorParenthesis
    :
    |    '(' ')' {notifyErrorListeners("redundant parenthesis");}
    |    ')'  {notifyErrorListeners("uneven parenthesis, lacking '('");}
    |    '('  {notifyErrorListeners("uneven parenthesis, lacking ')'");}
	;

assignmentExpression
	:	conditionalExpression
	;

assignment
	:	leftHandSide assignmentOperator expression
	;

leftHandSide
	:	expressionName
	|	arrayAccess
	;

assignmentOperator
	:	'='
	;

conditionalExpression
	:	conditionalOrExpression
	;

onlyConditionalExpression
    : Identifier | BooleanLiteral | onlyConditionalOrExpression
    ;

conditionalOrExpression
	:	conditionalAndExpression
	|	conditionalOrExpression '||' conditionalAndExpression
	;

onlyConditionalOrExpression
	:	onlyConditionalAndExpression
	|	onlyConditionalOrExpression '||' onlyConditionalAndExpression
	;

conditionalAndExpression
	:	inclusiveOrExpression
	|	conditionalAndExpression '&&' inclusiveOrExpression
	;

onlyConditionalAndExpression
	:	onlyEqualityExpression
	|	onlyConditionalAndExpression '&&' onlyEqualityExpression
	;

inclusiveOrExpression
	:	exclusiveOrExpression
	;

exclusiveOrExpression
	:	andExpression
	;

andExpression
	:	equalityExpression
	;

equalityExpression
	:	relationalExpression
	|   equalityExpression '=' relationalExpression {notifyErrorListeners("assignment operator found, expecting comparison operator");}
	|	equalityExpression '==' relationalExpression
	|	equalityExpression '!=' relationalExpression
	;

onlyEqualityExpression
	:	onlyRelationalExpression
	|   equalityExpression '=' relationalExpression {notifyErrorListeners("assignment operator found, expecting comparison operator");}
	|	equalityExpression '==' relationalExpression
	|	equalityExpression '!=' relationalExpression
	;

relationalExpression
	:	shiftExpression
	|	relationalExpression '<' shiftExpression
	|	relationalExpression '>' shiftExpression
	|	relationalExpression '<=' shiftExpression
	|	relationalExpression '>=' shiftExpression
	;

onlyRelationalExpression
	:	relationalExpression '<' shiftExpression
    |	relationalExpression '>' shiftExpression
    |	relationalExpression '<=' shiftExpression
    |	relationalExpression '>=' shiftExpression
	;

shiftExpression
	:	additiveExpression
	;

additiveExpression
	:	multiplicativeExpression
	|   additiveExpression additiveExpressionfactored
	;

additiveExpressionfactored
    : arithmetic arithmetic (arithmetic)* multiplicativeExpression  {notifyErrorListeners("redundant arithmetic operator symbol found");}
    | '+' '+' (arithmetic)+ multiplicativeExpression {notifyErrorListeners("redundant arithmetic operator symbol found");}
    | '-' '-' (arithmetic)+ multiplicativeExpression {notifyErrorListeners("redundant arithmetic operator symbol found");}
    | '+' '+' multiplicativeExpression {notifyErrorListeners("redundant '+' operator symbol found");}
    | '-' '-' multiplicativeExpression {notifyErrorListeners("redundant '-' operator symbol found");}
    | '**' multiplicativeExpression {notifyErrorListeners("redundant '*' operator symbol found");}
    | '//' multiplicativeExpression {notifyErrorListeners("redundant '/' operator symbol found");}
    | '%%' multiplicativeExpression {notifyErrorListeners("redundant '%' operator symbol found");}
    | addminus {notifyErrorListeners("lacking argument after operator/excess operator");}
    | addminus multiplicativeExpression
    ;

addminus
    : '+'
    | '-'
    ;

multiplicativeExpression
	:	unaryExpression
	|	multiplicativeExpression multiplicativeExpressionfactored
	;

multiplicativeExpressionfactored
    :    arithmetic arithmetic (arithmetic)* unaryExpression  {notifyErrorListeners("redundant arithmetic operator symbol found");}
    |   mult {notifyErrorListeners("lacking argument after operator/excess operator");}
    |   mult unaryExpression
    ;

arithmetic
    :   '+'
    |   '-'
    |   '*'
    |   '/'
    |   '%'
    ;

mult
    : '*'
    | '/'
    | '%'
    ;

unaryExpression
    :   unaryExpressionNotPlusMinus
	;

unaryExpressionNotPlusMinus
	:	postfixExpression
	|	'!' unaryExpression
	;

postfixExpression
	:		primary
		|	expressionName
	;

// LEXER

PRINT : 'print';
SCAN : 'scan';
FUNC : 'func';
MAIN : 'main';
STRING : 'String';
CONSTANT : 'constant';
CREATE : 'create';
THEN : 'then';

BOOL : 'bool';
BREAK : 'break';
CONTINUE : 'continue';
DO : 'do';
ELSE : 'else';
FLOAT : 'float';
FOR : 'for';
IF : 'if';
INT : 'int';
RETURN : 'return';
VOID : 'void';
WHILE : 'while';

UPTO : 'up to';
DOWNTO : 'down to';

// §3.10.1 Integer Literals

IntegerLiteral
	:	DecimalIntegerLiteral
//	|	HexIntegerLiteral
//	|	OctalIntegerLiteral
//	|	BinaryIntegerLiteral
	;

fragment
DecimalIntegerLiteral
//	:	DecimalNumeral IntegerTypeSuffix?
	:   DecimalNumeral
	;

//fragment
//HexIntegerLiteral
//	:	HexNumeral IntegerTypeSuffix?
//	;

//fragment
//OctalIntegerLiteral
//	:	OctalNumeral IntegerTypeSuffix?
//	;

//fragment
//BinaryIntegerLiteral
//	:	BinaryNumeral IntegerTypeSuffix?
//	;

//fragment
//IntegerTypeSuffix
//	:	[lL]
//	;

fragment
DecimalNumeral
	:	'0'
//	|	NonZeroDigit (Digits? | Underscores Digits)
	|   NonZeroDigit Digits?
	;

fragment
Digits
//	:	Digit (DigitsAndUnderscores? Digit)?
	:   Digit+
	;

fragment
Digit
	:	'0'
	|	NonZeroDigit
	;

fragment
NonZeroDigit
	:	[1-9]
	;

//fragment
//DigitsAndUnderscores
//	:	DigitOrUnderscore+
//	;

//fragment
//DigitOrUnderscore
//	:	Digit
//	|	'_'
//	;

//fragment
//Underscores
//	:	'_'+
//	;

//fragment
//HexNumeral
//	:	'0' [xX] HexDigits
//	;

//fragment
//HexDigits
//	:	HexDigit (HexDigitsAndUnderscores? HexDigit)?
//	;

//fragment
//HexDigit
//	:	[0-9a-fA-F]
//	;

//fragment
//HexDigitsAndUnderscores
//	:	HexDigitOrUnderscore+
//	;

//fragment
//HexDigitOrUnderscore
//	:	HexDigit
//	|	'_'
//	;

//fragment
//OctalNumeral
//	:	'0' Underscores? OctalDigits
//	;

//fragment
//OctalDigits
//	:	OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?
//	;

//fragment
//OctalDigit
//	:	[0-7]
//	;

//fragment
//OctalDigitsAndUnderscores
//	:	OctalDigitOrUnderscore+
//	;

//fragment
//OctalDigitOrUnderscore
//	:	OctalDigit
//	|	'_'
//	;

//fragment
//BinaryNumeral
//	:	'0' [bB] BinaryDigits
//	;

//fragment
//BinaryDigits
//	:	BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?
//	;

//fragment
//BinaryDigit
//	:	[01]
//	;

//fragment
//BinaryDigitsAndUnderscores
//	:	BinaryDigitOrUnderscore+
//	;

//fragment
//BinaryDigitOrUnderscore
//	:	BinaryDigit
//	|	'_'
//	;

// §3.10.2 Floating-Point Literals

FloatingPointLiteral
	:	DecimalFloatingPointLiteral
//	|	HexadecimalFloatingPointLiteral
	;

fragment
DecimalFloatingPointLiteral
    :   Digits '.' Digits? FloatTypeSuffix
    |	'.' Digits FloatTypeSuffix
//	:	Digits '.' Digits? ExponentPart? FloatTypeSuffix?
//	|	'.' Digits ExponentPart? FloatTypeSuffix?
//	|	Digits ExponentPart FloatTypeSuffix?
//	|	Digits FloatTypeSuffix
	;

//fragment
//ExponentPart
//	:	ExponentIndicator SignedInteger
//	;

//fragment
//ExponentIndicator
//	:	[eE]
//	;

//fragment
//SignedInteger
//	:	Sign? Digits
//	;

//fragment
//Sign
//	:	[+-]
//	;

fragment
FloatTypeSuffix
	:	[f]
//	:	[fFdD]
	;

//fragment
//HexadecimalFloatingPointLiteral
//	:	HexSignificand BinaryExponent FloatTypeSuffix?
//	;

//fragment
//HexSignificand
//	:	HexNumeral '.'?
//	|	'0' [xX] HexDigits? '.' HexDigits
//	;

//fragment
//BinaryExponent
//	:	BinaryExponentIndicator SignedInteger
//	;

//fragment
//BinaryExponentIndicator
//	:	[pP]
//	;

// §3.10.3 Boolean Literals

BooleanLiteral
    :	'T'
    |	'F'
//	:	'true'
//	|	'false'
	;

// §3.10.4 Character Literals

//CharacterLiteral
//	:	'\'' SingleCharacter '\''
//	|	'\'' EscapeSequence '\''
//	;

//fragment
//SingleCharacter
//	:	~['\\]
//	;

// §3.10.5 String Literals

StringLiteral
	:	'"' StringCharacters? '"'
	;
fragment
StringCharacters
	:	StringCharacter+
	;
fragment
StringCharacter
	:	~["\\]
	|	EscapeSequence
	;

// §3.10.6 Escape Sequences for Character and String Literals
fragment
EscapeSequence
	:	'\\' [btnfr"'\\]
//	|	OctalEscape
//    |   UnicodeEscape // This is not in the spec but prevents having to preprocess the input
	;

//fragment
//OctalEscape
//	:	'\\' OctalDigit
//	|	'\\' OctalDigit OctalDigit
//	|	'\\' ZeroToThree OctalDigit OctalDigit
//	;

//fragment
//ZeroToThree
//	:	[0-3]
//	;

// This is not in the spec but prevents having to preprocess the input
//fragment
//UnicodeEscape
//    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
//    ;

// §3.10.7 The Null Literal

//NullLiteral
//	:	'null'
//	;

// §3.11 Separators

LPAREN : '(' ;
RPAREN : ')' ;
LBRACE : '{' ;
RBRACE : '}' ;
LBRACK : '[' ;
RBRACK : ']' ;
SEMI : ';' ;
COMMA : ',' ;
//DOT : '.' ;

// §3.12 Operators

ASSIGN : '=' ;
GT : '>' ;
LT : '<' ;
BANG : '!' ;
//TILDE : '~' ;
//QUESTION : '?' ;
//COLON : ':' ;
EQUAL : '==' ;
LE : '<=' ;
GE : '>=' ;
NOTEQUAL : '!=' ;
AND : '&&' ;
OR : '||' ;
//INC : '++' ;
//DEC : '--' ;
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
//BITAND : '&' ;
//BITOR : '|' ;
//CARET : '^' ;
MOD : '%' ;
//ARROW : '->' ;
//COLONCOLON : '::' ;

//ADD_ASSIGN : '+=' ;
//SUB_ASSIGN : '-=' ;
//MUL_ASSIGN : '*=' ;
//DIV_ASSIGN : '/=' ;
//AND_ASSIGN : '&=' ;
//OR_ASSIGN : '|=' ;
//XOR_ASSIGN : '^=' ;
//MOD_ASSIGN : '%=' ;
//LSHIFT_ASSIGN : '<<=' ;
//RSHIFT_ASSIGN : '>>=' ;
//URSHIFT_ASSIGN : '>>>=' ;



// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
	:	JavaLetter JavaLetterOrDigit*
	;

fragment
JavaLetter
	:	[a-zA-Z$_] // these are the "java letters" below 0x7F
	|	// covers all characters above 0x7F which are not a surrogate
		~[\u0000-\u007F\uD800-\uDBFF]
		{Character.isJavaIdentifierStart(_input.LA(-1))}?
	|	// covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
		[\uD800-\uDBFF] [\uDC00-\uDFFF]
		{Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

fragment
JavaLetterOrDigit
	:	[a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
	|	// covers all characters above 0x7F which are not a surrogate
		~[\u0000-\u007F\uD800-\uDBFF]
		{Character.isJavaIdentifierPart(_input.LA(-1))}?
	|	// covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
		[\uD800-\uDBFF] [\uDC00-\uDFFF]
		{Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

//
// Additional symbols not defined in the lexical specification
//

//AT : '@' ;
//ELLIPSIS : '...' ;

//
// Whitespace and comments
//

WS
  	:	[ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;