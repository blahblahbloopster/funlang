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

IDENTIFIER: [a-zA-Z_] [a-zA-Z_0-9]*;

KEYWORD : STRUCT | FUN | NEW | IF | WHILE | LET | MUT | IMPORT;

struct : STRUCT IDENTIFIER OPEN_BRACE (IDENTIFIER COLON IDENTIFIER ',')* (IDENTIFIER COLON IDENTIFIER SEMICOLON)? fun* CLOSE_BRACE;

fieldAccess : '.' IDENTIFIER;

functionInvocation: IDENTIFIER OPEN_PAREN (expression ',')* (expression)? CLOSE_PAREN;
methodInvocation : '.' functionInvocation;

addOp: '+' | '-';
mulOp: '*' | '/';

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
    expression addOp expression
;

statement: ifStatement | whileLoop | (variableAssign SEMICOLON) | (expression SEMICOLON);

ifStatement:
    IF OPEN_PAREN expression CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE
;

whileLoop:
    WHILE OPEN_PAREN expression CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE
;

variableAssign:
    (LET | MUT) IDENTIFIER '=' expression
;

fun:
    STATIC? FUN IDENTIFIER OPEN_PAREN (IDENTIFIER COLON IDENTIFIER ',')* (IDENTIFIER COLON IDENTIFIER)? CLOSE_PAREN OPEN_BRACE
    statement*
    CLOSE_BRACE
;

impt:
    IMPORT (IDENTIFIER '.')* IDENTIFIER SEMICOLON
;

file:
    impt+
    struct*
;