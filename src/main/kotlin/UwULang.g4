grammar UwULang;
INTEGER : '-'? ('0'..'9')+;
FLOAT : '-'? ('0'..'9')+ ('.'('0'..'9')+) ('e' '-'? ('0'..'9')+ ('.' ('0'..'9')+)?)?;
WS : [ \t\r\n]+ -> skip ;

OPEN_PAREN: '(';
CLOSE_PAREN: ')';

OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';

STRING_LITERAL: '"' (~["]|'\\"')* '"';

STRUCT: 'stwuct';
FUN: 'fuwn';
STATIC: 'static';
NEW: 'new';
IF: 'if';
WHILE: 'whiwe';
FOR: 'fow';
LET: 'wet';
MUT: 'mewt';
IMPORT: 'impowt';
RETURN: 'wetuwn';
PACKAGE: 'package';
AS: 'as';

IDENTIFIER: [a-zA-Z_] [a-zA-Z_0-9]*;

KEYWORD : STRUCT | FUN | NEW | IF | WHILE | LET | MUT | IMPORT | RETURN | PACKAGE | AS | FOR;

nameTypePair: name=IDENTIFIER COLON type=IDENTIFIER;

struct : STRUCT IDENTIFIER OPEN_BRACE (nameTypePair ',')* (nameTypePair SEMICOLON)? fun* CLOSE_BRACE;

fieldAccess : '.' IDENTIFIER;

functionInvocation: IDENTIFIER OPEN_PAREN (expression ',')* (expression)? CLOSE_PAREN;
methodInvocation : '.' functionInvocation;

PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDE: '/';

LESSTHANEQUALS: '<=';
GREATERTHANEQUALS: '>=';
LESSTHAN: '<';
GREATERTHAN: '>';
EQUALS: '==';

addOp: PLUS | MINUS;
mulOp: TIMES | DIVIDE;
compOp: LESSTHAN | GREATERTHAN | LESSTHANEQUALS | GREATERTHANEQUALS | EQUALS;

expression :
    IDENTIFIER |
    expression fieldAccess |
    expression methodInvocation |
    functionInvocation |
    OPEN_PAREN expression CLOSE_PAREN |
    INTEGER |
    FLOAT |
    STRING_LITERAL |
    expression mulOp expression |
    expression addOp expression |
    expression compOp expression |
    new |
    expression AS IDENTIFIER
;

statement: ifStatement | whileLoop | forLoop | (variableAssign SEMICOLON) | (expression SEMICOLON) | (RETURN expression? SEMICOLON) | (fieldAssign SEMICOLON);

fieldAssign:
    expression '.' IDENTIFIER '=' expression
;

ifStatement:
    IF OPEN_PAREN expression CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE
;

whileLoop:
    WHILE OPEN_PAREN expression CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE
;

braceBlock:
    OPEN_BRACE statement* CLOSE_BRACE
;

forLoop:
    FOR OPEN_PAREN init=statement condition=expression SEMICOLON each=statement CLOSE_PAREN braceBlock
;

variableAssign:
    (LET | MUT)? IDENTIFIER '=' expression
;

multiStatement:
    statement*
;

fun:
    STATIC? FUN name=IDENTIFIER OPEN_PAREN (nameTypePair ',')* (nameTypePair)? CLOSE_PAREN (COLON returnType=IDENTIFIER)? OPEN_BRACE
    multiStatement
    CLOSE_BRACE
;

impt:
    IMPORT (IDENTIFIER '.')* IDENTIFIER SEMICOLON
;

new:
    NEW IDENTIFIER OPEN_PAREN (expression ',')* expression? CLOSE_PAREN
;

qualifiedName:
    (IDENTIFIER '.')* IDENTIFIER
;

packageStatement:
    PACKAGE qualifiedName SEMICOLON
;

file:
    packageStatement
    impt+
    struct*
;
