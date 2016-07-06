package com.jiayun.internal;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dongyangzhao
 * This class is an Java implementation for base add/remove operations for BTree used as internal data structure for db.
 * @param <Key>
 * @param <Value>
 */

public class BTree<Key extends Comparable<Key>, Value> {
   private static final int DEFAULT_T = 2;
   private BTNode root;
   private int t; //min degree
   private static int minKeyNum; //non-root node min
   private static int maxKeyNum; //non-root node max

   private static final class BTNode {
       public int n = 0;
       public List<Entry> keys = new ArrayList<Entry>(maxKeyNum);
       public List<BTNode> children = new ArrayList<BTNode>(maxKeyNum+1);
       public boolean isLeaf = true;

       public void insertKey(int index, Entry entry) {
    	   keys.add(index, entry);
    	   n++;
    	   if(keys.size() > maxKeyNum) keys.remove(maxKeyNum);
       }
       
       public void insertChild(int index, BTNode child) {
    	   children.add(index, child);
    	   if(children.size() > maxKeyNum+1) children.remove(maxKeyNum+1);
       }
   }

    public static class Entry {
        private Comparable key;
        private Object val;
        public Entry(Comparable key, Object val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public BTree() {
    	this(DEFAULT_T);
    }
    
    private BTree(int degree) {
    	if(degree < 4) t = DEFAULT_T;
    	this.t= degree;
    	this.minKeyNum = degree-1;
    	this.maxKeyNum = 2*degree-1;
    	BTNode node = new BTNode();
    	this.root = node;
    }
    
    private void splitChild(BTNode x, int index) {
    	BTNode z = new BTNode();
    	BTNode y = x.children.get(index);
    	z.isLeaf = y.isLeaf;
    	for(int j = 0; j < minKeyNum; j++) {
    		z.insertKey(j,  y.keys.get(j+t));
    	}
    	if(!y.isLeaf) {
    		for(int j = 0; j < t; j++) {
    			z.insertChild(j, y.children.get(j+t));
    		}
    	}
    	z.n = minKeyNum;
    	y.n = minKeyNum;
    	x.insertChild(index+1, z);
    	x.insertKey(index, y.keys.get(minKeyNum));
    }
    
    public void insert(Entry entry) {
    	BTNode r = root;
    	if(root.n == maxKeyNum) {
    		BTNode newRoot = new BTNode();
    		root = newRoot;
    		newRoot.isLeaf = false;
    		newRoot.insertChild(0, r);
    		splitChild(newRoot, 0);
    		insertNoFull(newRoot, entry);
    	}
    	else {
    		insertNoFull(r, entry);
    	}
    }
    
    private void insertNoFull(BTNode x, Entry entry) {
    	int i = x.n-1;
    	if(x.isLeaf) {
    		while(i>=0 && entry.key.compareTo(x.keys.get(i).key) < 0) i--;
    		x.insertKey(i+1, entry);
    	}
    	else {
    		while(i>=0 && entry.key.compareTo(x.keys.get(i).key) < 0) i--;
    		i = i + 1;
    		if(x.children.get(i).n == maxKeyNum) {
    			splitChild(x, i);
    			if(entry.key.compareTo(x.keys.get(i).key) > 0) i = i+1;
    		}
    		insertNoFull(x.children.get(i), entry);
    	}
    }
    
    public Value get(Key key) {
    	return search(root, key);
    }
    
    public Value search(BTNode x, Key key) {
    	int n = x.n;
    	int i = 0;
    	while (i < n && key.compareTo((Key) x.keys.get(i).key) > 0) i++;
    	if(i < n && key.compareTo((Key) x.keys.get(i).key) == 0) {
    		return (Value) x.keys.get(i).val;
    	}
    	else if(x.children != null && x.children.size() > 0) {
    		return search(x.children.get(i), key);
    	}
    	return null;
    }
}