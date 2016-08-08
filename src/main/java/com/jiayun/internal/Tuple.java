package com.jiayun.internal;

public class Tuple<String, Val> {
	private String k;

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public Val getV() {
		return v;
	}

	public void setV(Val v) {
		this.v = v;
	}

	private Val v;

	public Tuple(String k, Val v) {
		this.k = k;
		this.v = v;
	}

}
