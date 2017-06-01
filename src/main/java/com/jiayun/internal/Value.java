package com.jiayun.internal;

import java.util.ArrayList;
import java.util.List;

public class Value {
	private List<Tuple> values;
	
	
	public Value() { values = new ArrayList<Tuple>(); }
	
	public void addValue(String colName, String colVal) {
	    values.add(new Tuple(colName, colVal));
	}
	
	public List<Tuple> getValues() {
		return values;
	}
	
	public String toFormatString() {
		String result = "==========================="+"\n";
		for(int i = 0; i < values.size(); i++) {
			result = result + values.get(i).getK() + "    ";
		}
		result+="\n";
		for(int i = 0; i < values.size(); i++) {
			result = result + values.get(i).getV() + "    ";
		}
		return result;
	}
	

}
