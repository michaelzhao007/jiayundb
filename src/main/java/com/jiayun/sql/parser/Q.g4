grammar Q;

@members {
    Interpreter interp;
    public QParser(TokenStream input, Interpreter interp) {
        this(input);
        this.interp = interp;
    }
}

program
    :   stat+
    ;

stat:   create
    | insert
    ;

// START: create
create
    :   WS* 'create' WS+ 'table' WS+ ID
        {interp.createTable($ID.getText());}
    ;
// END: create

// START: insert
insert
    : WS* 'insert' WS+ 'into' WS+ ID WS+ 'set' WS+ (STRING ',' STRING WS+)* ';'
      {interp.insertInto($STRING.text, $STRING.text);}
    ;
// END: insert

//START: expr
//Match a simple value or do a query
//expr returns [Object value]
//   : INT {$value = $INT.int; }
 //  | STRING {$value= $STRING.text;}
 //  ;
//END: expr

// START: fields
//setFields[Table t] returns [Value val]
//@init { $val = new Value(); } // set return value
//    :   set[colRow]' :'set[colVal](',' set[colRow]' :'set[colVal])*
//    ;
//set[Value val] // pass in Row we're filling in
//    :   ID '=' expr {val.addValue($expr.value._1, $);}
//    ;
// END: fields


ID  :   ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

INT :   '0'..'9'+ ;

STRING
    :   '\'' ~'\''* '\''
        {setText(getText().substring(1, getText().length()-1));}
    ;
    
WS  :   (  ' '
        | '\t'
        | '\r'
        | '\n'
        ) -> channel(HIDDEN)
    ;
