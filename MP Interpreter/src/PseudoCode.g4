grammar PseudoCode;

// starting point
compilationUnit
    :   methodDeclaration* mainDeclaration methodDeclaration* EOF
    ;

variableModifier
    :   CONSTANT
    ;

mainDeclaration
    :   'main' '(' ')' block
    ;

methodDeclaration
    :   'func' (result|'void') methodDeclarator block
    |   'func' methodDeclarator block {notifyErrorListeners("lacking return type");}
    |   'func' (result|'void') methodDeclarator {notifyErrorListeners("lacking function body");}
    |   'func' (result|'void') block {notifyErrorListeners("can't find function name");}
    ;

methodDeclarator
	:	Identifier '(' formalParameters? ')'
	|	'(' formalParameters? ')' {notifyErrorListeners("can't find function name");}
	|	Identifier '(' formalParameters? {notifyErrorListeners("uneven parenthesis, lacking ')'");}
	|	Identifier formalParameters? ')' {notifyErrorListeners("uneven parenthesis, lacking '('");}
	;

variableDeclaratorList
    :   variableDeclarator (',' variableDeclarator)*
    ;

variableDeclarator
    :	Identifier ('=' variableInitializer)?
    |   unannType ('=' variableInitializer)? {notifyErrorListeners("declaring keyword as variable name");}
    ;

variableInitializer
    :   arrayInitializer
    |   expression
    ;

arrayInitializer
    :   'create' unannType '[' expression ']'
    ;

result
    :   unannType ('[' ']')?
    ;

unannType
    :   'bool'
    |   'int'
    |   'float'
    |   'String'
//    |   'array'
    ;

formalParameters
	:	formalParameter (',' formalParameter)*
    |   (formalParameter (',' formalParameter)*)? formalParameter formalParameters {notifyErrorListeners("no separator found in parameters");}
    |   ','* ',' formalParameters {notifyErrorListeners("lacking parameter");}
    |   formalParameters ',' ','* {notifyErrorListeners("lacking parameter");}
    |   formalParameters ',' ',' ','* formalParameters {notifyErrorListeners("lacking parameter");}
	;

formalParameter
    :   result Identifier
    |   Identifier {notifyErrorListeners("no specified data type");}
    |   result {notifyErrorListeners("no parameter name");}
    ;

literal
    :   IntegerLiteral
    |   FloatingPointLiteral
//    |   CharacterLiteral
    |   StringLiteral
    |   BooleanLiteral
//    |   'null'
    ;

// STATEMENTS / BLOCKS

block
    :    '{' blockStatement* '}'
//    |    '{' blockStatement* {notifyErrorListeners("no closing bracket '}' found");}
//    |    blockStatement* '}' {notifyErrorListeners("no open bracket '{' found");}
    ;

blockStatement
    :   localVariableDeclarationStatement
    |   statement
//    |   expression
    ;

localVariableDeclarationStatement
    :    localVariableDeclaration ';'
    |    localVariableDeclaration {notifyErrorListeners("lacking ';' at the end of line");}
    ;

localVariableDeclaration
    :   variableModifier? result variableDeclaratorList
    |   Identifier result variableDeclaratorList {notifyErrorListeners("identifier found before data type in the declaration");}
    ;

statement
    :   block
    |   ifThenStatement
    |   whileStatement
    |   doStatement ';'
    |   forStatement
    |   printInvocation ';'
    |   printInvocation {notifyErrorListeners("lacking ';' at the end of line");}
//    |   'if' parExpression statement ('else' statement)?
//    |   'for' '(' forControl ')' statement
//    |   'while' parExpression statement
//    |   'do' statement 'while' parExpression ';'
//    |   'try' block (catchClause+ finallyBlock? | finallyBlock)
//    |   'try' resourceSpecification block catchClause* finallyBlock?
//    |   'switch' parExpression '{' switchBlockStatementGroup* switchLabel* '}'
//    |   'synchronized' parExpression block
    |   'return' expression? ';'
    |   'return' result ';' {notifyErrorListeners("cannot return data type");}
//    |   'throw' expression ';'
    |   'break' ';'
    |   'continue' ';'
    |   ';'
    |   statementExpression ';'
    |   statementExpression {notifyErrorListeners("lacking ';' at the end of line");}
//    |   Identifier ':' statement
//    |   PRINT '(' expression ')' ';'
    |   scanInvocation ';'
    |   scanInvocation {notifyErrorListeners("lacking ';' at the end of line");}
    |   Identifier ('+'|'-'|'*'|'/'|'%') ('+'|'-'|'*'|'/'|'%')+ {notifyErrorListeners("redundant arithmetic operator symbol found");}
    ;

forStatement
	:   forheader block
    ;

forheader
    : 'for' forinitializer 'up to' expression
    | 'for' forinitializer 'down to' expression
    | 'for' forinitializer (StringLiteral | Identifier ('[' expression ']')?)+ expression {notifyErrorListeners("wrong syntax for 'for loop' should contain 'up to' or 'down to' keyword");}
    ;

forinitializer
    :	'int'? Identifier customAssignError
    |   Identifier '[' expression ']' customAssignError
    |	Identifier ('[' expression ']')?
    ;

customAssignError
    :	'=' expression
    |   {notifyErrorListeners("did not find assignment operator");}
    ;

doStatement
    :   'do' block 'while' Identifier ('[' expression ']')? 'up to' expression
    |   'do' block 'while' Identifier ('[' expression ']')? 'down to' expression
    |   'do' block 'while' Identifier ('[' expression ']')? (StringLiteral | Identifier ('[' expression ']')?)+ expression {notifyErrorListeners("wrong syntax for 'do while loop' should contain 'up to' or 'down to' keyword");}
	;

whileStatement
    :	'while' Identifier ('[' expression ']')? 'up to' expression block
    |   'while' Identifier ('[' expression ']')? 'down to' expression block
    |   'while' Identifier ('[' expression ']')? (StringLiteral | Identifier ('[' expression ']'))+ expression block {notifyErrorListeners("wrong syntax for 'while loop' should contain 'up to' or 'down to' keyword");}
	;

ifThenStatement
    :   'if' '(' conditionalExpression ')' 'then' block ('else' 'if' '(' conditionalExpression ')' 'then' block)* ('else' 'then' block)?
	;

printInvocation
    :   'print' '(' expression ')'
    |   'print' '(' expression '+'')' {notifyErrorListeners("additional ‘+’ sign at end of print");}
    |   'print' '(' ((StringLiteral | ~(StringLiteral | Identifier | ')') | Identifier ('[' expression ']')?) (StringLiteral | ~(StringLiteral | Identifier | ')') | Identifier ('[' expression ']')?)+) ')' {notifyErrorListeners("lacking 'double quotes' in print statement");}
    |   'print' '(' ~(StringLiteral | Identifier | ')') ')' {notifyErrorListeners("value of keyword cannot be printed");}
    ;

scanInvocation
    :   SCAN '(' expression ',' Identifier')'
    |   SCAN '(' expression ',' Identifier '[' expression ']' ')'
    ;

// EXPRESSIONS

expressionList
    :	expression (',' expression)*
    |   (expression (',' expression)*)? expression expressionList {notifyErrorListeners("no separator found in parameters");}
    |   ','* ',' expressionList {notifyErrorListeners("lacking parameter");}
    |   expressionList ',' ','* {notifyErrorListeners("lacking parameter");}
    |   expressionList ',' ',' ','* expressionList {notifyErrorListeners("lacking parameter");}
    ;

statementExpression
    :   assignment
    |   methodInvocation
    ;

methodInvocation
    :   Identifier '(' expressionList? ')'
    |	Identifier '(' expressionList? ')''(' expressionList? ')'{notifyErrorListeners("redundant parentheses");}
    |   Identifier '(' expressionList? {notifyErrorListeners("uneven parenthesis, lacking ')'");}
    |   Identifier expressionList? ')' {notifyErrorListeners("uneven parenthesis, lacking '('");}
    ;

conditionalExpression
    :   expression
    |   assignment {notifyErrorListeners("assignment operator found, expecting comparison operator");}
    ;

assignment
    :   Identifier '=' expression
    |   Identifier '[' expression ']' '=' expression
    ;

expression
    :   primary
//    |   expression '(' arguments ')' ';'
//    |   expression '.' Identifier
    //|   expression '.' 'this'
    //|   expression '.' 'new' nonWildcardTypeArguments? innerCreator
    //|   expression '.' 'super' superSuffix
    //|   expression '.' explicitGenericInvocation
    |   Identifier '[' expression ']'
    |   Identifier '(' expressionList? ')'
//    |   'new' creator
//    |   '(' result ')' expression
//    |   expression ('++' | '--')
//    |   ('+'|'-'|'++'|'--') expression
    |   ('!') expression
    |   expression ('*'|'/'|'%') expression
    |   expression ('+'|'-') expression
//    |   expression ('<' '<' | '>' '>' '>' | '>' '>') expression
    |   expression ('<=' | '>=' | '>' | '<') expression
//    |   expression 'instanceof' result
    |   expression ('==' | '!=') expression
//    |   expression '&' expression
//    |   expression '^' expression
//    |   expression '|' expression
    |   expression '&&' expression
    |   expression '||' expression
//    |   expression '?' expression ':' expression
//    |   <assoc=right> expression
//        (   '='
//        |   '+='
//        |   '-='
//        |   '*='
//        |   '/='
//        |   '&='
//        |   '|='
//        |   '^='
//        |   '>>='
//        |   '>>>='
//        |   '<<='
//        |   '%='
//        )
//        expression
    |   primary '(' ')' {notifyErrorListeners("redundant parenthesis");}
    |   primary ')'  {notifyErrorListeners("uneven parenthesis, lacking '('");}
    |   primary '('  {notifyErrorListeners("uneven parenthesis, lacking ')'");}
    |   '(' ')' primary  {notifyErrorListeners("redundant parenthesis");}
    |   ')' primary  {notifyErrorListeners("uneven parenthesis, lacking '('");}
    |   '('  primary   {notifyErrorListeners("uneven parenthesis, lacking ')'");}
    |   unaryExpression unaryExpression+  {notifyErrorListeners("no operators found");}
    |   expression ('+'|'-'|'*'|'/'|'%') ('+'|'-'|'*'|'/'|'%')+ expression {notifyErrorListeners("redundant arithmetic operator symbol found");}
    |   expression ('+'|'-'|'*'|'/'|'%') {notifyErrorListeners("lacking argument after operator/excess operator");}
    ;

unaryExpression
    :   primary
    |   Identifier '[' expression ']'
    |   Identifier '(' expressionList? ')'
    ;

primary
    :   '(' expression ')'
//    |   'this'
//    |   'super'
    |   literal
    |   Identifier
    //|   result '.' 'class'
    //|   'void' '.' 'class'
//    |   nonWildcardTypeArguments (explicitGenericInvocationSuffix | 'this' arguments)
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
	:	DQUOTE StringCharacters? DQUOTE
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
TILDE : '~' ;
QUESTION : '?' ;
COLON : ':' ;
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
BITAND : '&' ;
BITOR : '|' ;
CARET : '^' ;
MOD : '%' ;
DQUOTE : '"';
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