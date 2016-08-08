package com.jiayun.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JiayunDB {
    Map<String, Table> map;
    public JiayunDB() {
    	map = new HashMap<String, Table>();
    }
    
    public Table getTable(String tableName) {
    	return map.get(tableName);
    }
    
    public void createTable(String tableName) {
    	map.put(tableName, new Table());
    	System.out.println("Table created");
    }
   /* 
    public static void main(String[] args) {
		JiayunDB db = new JiayunDB();
		db.createTable("Test");
		List<Tuple> tuples = new ArrayList<Tuple>();
		Tuple tuple = new Tuple<String, String>("name", "ruiyun");
		Tuple tuple1 = new Tuple<String, String>("school", "uiuc");
		Tuple tuple2= new Tuple<String, Object>("age", 18);
        tuples.add(tuple);
        tuples.add(tuple1);
        tuples.add(tuple2);
		Value value = new Value(tuples);
		Table test = db.getTable("Test");
	    test.insertIntoTable(value);
	    System.out.println(test.readFromTableByPrimaryKey("ruiyun"));
	   
    }*/
}
