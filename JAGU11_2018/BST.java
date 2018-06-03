package jagu11_2018;

import java.util.*;

public class BST {
	private Comparable key;
	private BST left, right;
	private int size;

	public class Node implements Comparable{

		@Override
		public int compareTo(Object other) {
			// TODO Auto-generated method stub
			return (int)key-(int)other;
		}
	}

	public BST() {
		key = null;
		left = null;
		right = null;
	}

	public BST(int key) {
		this.key = key;
		left = null;
		right = null;

	}
	public int treesize() {

		return size;
	}
	public boolean recu_insert(int key) {

		if(this.key == null) {
			this.key = key;
			size++;
			return true;
		}
		if(this.key.compareTo(key)<0) {
			right.recu_insert(key);
			size++;
		}
		else if(this.key.compareTo(key)>0) {
			left.recu_insert(key);
			size++;
		}
		else if(this.key.compareTo(key)==0){
			return false;
		}
		
		return true;
	}
	public boolean iter_insert(int key) {
		BST cNode = new BST();
		while(true) {
			if(this.key.compareTo(key)<0) {
				
			}
			else if(this.key.compareTo(key)>0) {
				
			}
			else if(this.key.compareTo(key)==0) break;
		}
		return true;
	}

	public void inorder() {
		if(left != null)
			left.inorder();
		System.out.print(key + " ");
		if(right != null)
			right.inorder();

	}
}