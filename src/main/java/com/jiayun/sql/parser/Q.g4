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
    ;

// START: create
create
    :   'create' WS+ 'table' WS+ ID WS*
        {interp.createTable($ID.getText());}
    ;
// END: create

// START: insert
//insert
//    : 'insert' WS+ 'into' WS+ ID WS+ 'set' WS+ setFields[interp.tables.get($ID.text)] ';'
//      {interp.insertInto($ID.text, $setFields.row);}
//    ;
// END: insert

//START: expr
//Match a simple value or do a query
//expr returns [Object value]
 //  : ID {$value = interp.load($ID.text);}
 //  | INT {$value = $INT.int; }
 //  | STRING {$value= $STRING.text;}
 //  ;
//END: expr
// START: fields
//setFields[Table t] returns [Row row]
//@init { $row = new Row(t.columns); } // set return value
//    :   set[$row] (',' set[$row])*
//    ;
//set[Row row] // pass in Row we're filling in
//    :   ID '=' expr {row.set($ID.text, $expr.value);}
 //   ;
// END: fields


ID  :   ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

INT :   '0'..'9'+ ;

STRING
    :   '\'' ~'\''* '\''
        {setText(getText().substring(1, getText().length()-1));}
    ;
    
WS  :     ' '
        | '\t'
        | '\r'
        | '\n'
    ;
