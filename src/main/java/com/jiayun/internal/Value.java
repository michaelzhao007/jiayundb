package com.jiayun.internal;

import java.util.List;

public class Value {
	private List<Tuple> values;
	public Value(List<Tuple> list) {
		this.values = list;
	}
	
	public Value() {}
	
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
