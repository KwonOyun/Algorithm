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
		if(this.key==null) return 0;
		size=0;
		DFS();
		return size+1;
	}
	
	public String DFS() {
		if(this.left!=null) {
			size++;
			this.left.DFS();
		}
		
		if(this.right!=null) {
			size++;
			this.right.DFS();
		}
		return "";
	}
	
	public boolean recu_insert(int key) {

		if(this.key == null) {
			this.key = key;
			return true;
		}

		if(this.key.compareTo(key)<0) {
			if(this.right==null) {
				this.right = new BST(key);
			}
			right.recu_insert(key);
		}
		else if(this.key.compareTo(key)>0) {
			if(this.left==null) {
				this.left = new BST(key);
			}
			left.recu_insert(key);
		}
		else if(this.key.compareTo(key)==0){
			return false;
		}
		return true;
	}
	public boolean iter_insert(int key) {

		if(this.key==null) {
			this.key = key;
			return true;
		}
		BST cNode = this;

		while(true) {

			if(cNode.key.compareTo(key)<0) {
				if(cNode.right == null) {
					cNode.right = new BST(key);
				}
				cNode = cNode.right;
				size++;
			}
			else if(cNode.key.compareTo(key)>0) {
				if(cNode.left == null) {
					cNode.left = new BST(key);
				}
				cNode = cNode.left;
			}
			else if(cNode.key.compareTo(key)==0) break;
		}
		return true;
	}
	
	public void inorder() {
		if(left != null) {
			left.inorder();
		}
		System.out.println("Visited : "+key+ ", TreeSize : "+treesize());
		if(right != null) {
			right.inorder();
		}
	}
}