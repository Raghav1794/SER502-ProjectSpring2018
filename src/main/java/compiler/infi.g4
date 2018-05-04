//grammer for infinity inspired from C language.

grammar infinity
        ;

//program is a list of statements.
program: statement+ 
         ;

//A statement can either be a assignment or a loop or a condition or a variable or a display or a read statement.
statement: (assignment | loop | condition | variable | display | read)
           ;

//An assignment is represented as identifier = expression;
assignment: IDENTIFIER ASSIGN (expression | CHARACTER) ';'
             ;

//An equality is used to represent conditions in if then else and while conditions.
equality: (expression | IDENTIFIER) (GT | LT | LE | EQ | NE | GE) expression
          ;

//While loop.
loop: 'while' '(' equality ')' '{' statement+ '}'
      ;

//Integer variable declaration
variable: 'int' '(' IDENTIFIER ')' (ASSIGN expression)? ';'
          ;

//If then else.
condition: ifcondition (elsecondition)?
           ;

//If condition.
ifcondition: 'if' '(' equality ')' '{' statement+ '}'
            ;

//Else condition.
elsecondition: 'else' '{' statement+ '}'
             ;

//Grammer for Print.
display: 'print' (IDENTIFIER | '(' string ')') ';'
          ;

//Grammer for scan(to read user input).
read: 'scan' IDENTIFIER ';'
       ;

//Grammer for expression.
expression: expression (MUL | DIV | MOD)
           expression
           | expression (ADD | SUB)
           expression
           |NOT expression
           |expression AND expression
           |expression OR expression
           |INTEGER
           |IDENTIFIER
           |BOOL
           | '(' (expression|IDENTIFIER) ')'
           ;


//Grammer for string
string: IDENTIFIER
        ;


// Terminals
INTEGER: [0-9]+
        ;


IDENTIFIER: ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+
            ;


CHARACTER: ('a'..'z'|'A'..'Z'|'0'..'9')
           ;


BOOL: 'True' | 'False'
          ;

ASSIGN: '='
        ;
GT: '>'
    ;
LT: '<'
    ;
EQ: '=='
    ;
NE: '!='
    ;
GE: '>='
    ;
LE: '<='
    ;
MUL: '*'
     ;
ADD: '+'
     ;
SUB: '-'
     ;
DIV: '/'
     ;
NOT: '!'
     ;
AND: '&&'
     ;
OR: '||'
    ;
MOD: '%'
     ;

// To ignore white spaces.
WS: [ \n\t\r]+ -> skip;
