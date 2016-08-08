package com.jiayun.internal;

import java.util.Map;

import com.jiayun.internal.BTree.Entry;

public class Table<Key extends Comparable<Key>> {
	private String primaryKey;
	private Value fields;
	private BTree<Key, Value> btree;
    public int columns;
	
	public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Table() {
		btree = new BTree<Key, Value>();
	}
	
	public void insertIntoTable(Value value) {
		btree.insert(new Entry((Comparable) value.getValues().get(0).getV(), value));
	}
	
	public String readFromTableByPrimaryKey(Object obj) {
		return btree.get((Key) obj).toFormatString();
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Value getFields() {
		return fields;
	}

	public void setFields(Value fields) {
		this.fields = fields;
	}
}
