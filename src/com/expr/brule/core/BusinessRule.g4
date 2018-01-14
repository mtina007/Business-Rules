/*
 * Business rule grammar
 */

grammar BusinessRule;

parse
 : expr EOF
 ;


expr
 : expr binop expr  
 | lhs=VARIABLE compop rhs=VARIABLE 
 | lhs=VARIABLE compop rhs=STRING 
 | TRUE         
 | FALSE        
 | VARIABLE     
 | LEFTPAREN expr RIGHTPAREN 
 
 ;

binop
 : AND | OR 
 ;

compop:
          EQUAL | LT | GT | LTE | GTE | NE
      ;
          

TRUE:
        'true' | 'TRUE'
    ;

FALSE:
         'false' | 'FALSE';
STRING:
          '"'   ~[\t\n\r\"]* '"' 
     ;
     
     //startofexpr:	LEFTPAREN;
     //endofexpr:		RIGHTPAREN;

LEFTPAREN:	'(';   
RIGHTPAREN:	')';  
EQUAL     : '=' | 'EQ';
LT        : '<' | 'LT';
GT        : '>' | 'GT';
LTE       : '<=';
GTE       : '>=';
NE        : '!=' | 'NE';
AND       : 'AND' | '&' | 'and';
OR        : 'OR' | 'or' | '|';
VARIABLE  : [a-zA-Z0-9_.-]+;
SPACE     : [ \t\r\n] -> skip;