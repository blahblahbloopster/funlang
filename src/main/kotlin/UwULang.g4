grammar UwULang;
INTEGER : ('0'..'9') + ('.' ('0'..'9') +)? ;
FLOAT : '-'? ('0'..'9')+ ('.'('0'..'9')+) ('e' '-'? ('0'..'9')+ ('.' ('0'..'9')+)?) ;
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
LET: 'wet';
MUT: 'mewt';
IMPORT: 'impowt';
RETURN: 'wetuwn';

IDENTIFIER: [a-zA-Z_] [a-zA-Z_0-9]*;

KEYWORD : STRUCT | FUN | NEW | IF | WHILE | LET | MUT | IMPORT | RETURN;

nameTypePair: name=IDENTIFIER COLON type=IDENTIFIER;

struct : STRUCT IDENTIFIER OPEN_BRACE (nameTypePair ',')* (nameTypePair SEMICOLON)? fun* CLOSE_BRACE;

fieldAccess : '.' IDENTIFIER;

functionInvocation: IDENTIFIER OPEN_PAREN (expression ',')* (expression)? CLOSE_PAREN;
methodInvocation : '.' functionInvocation;

PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDE: '/';

addOp: PLUS | MINUS;
mulOp: TIMES | DIVIDE;

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
    new
;

statement: ifStatement | whileLoop | (variableAssign SEMICOLON) | (expression SEMICOLON) | (RETURN expression SEMICOLON);

ifStatement:
    IF OPEN_PAREN expression CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE
;

whileLoop:
    WHILE OPEN_PAREN expression CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE
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
    NEW IDENTIFIER
;

file:
    impt+
    struct*
;
