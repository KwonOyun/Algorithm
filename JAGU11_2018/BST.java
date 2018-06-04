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
		this.key = null;
		this.left = null;
		this.right = null;
		this.size = 0;
	}

	public BST(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
		this.size = 1;

	}
	public int treesize() {
		if(this.key==null) return 0;

		return this.DFS();
	}

	public int DFS() {
		int curr=0;
		
		if(this!=null) curr++;
		
		if(this.left!=null) {
			curr+=this.left.DFS();
		}

		if(this.right!=null) {
			curr+=this.right.DFS();
		}
		return curr;
	}

	public boolean recu_insert(int key) {

		this.size++;

		if(this.key == null) {
			this.key = key;
			return true;
		}
		else {
			if(this.key.compareTo(key)<0) {
				if(this.right==null) {
					this.right = new BST(key);
				}
				else {
					right.recu_insert(key);
				}
			}
			else if(this.key.compareTo(key)>0) {
				if(this.left==null) {
					this.left = new BST(key);
				}
				else{
					left.recu_insert(key);
				}
			}
			else if(this.key.compareTo(key)==0){
				return false;
			}
		}
		return true;
	}

	public boolean iter_insert(int key) {

		BST cNode = this;

		if(cNode.key==null) {
			cNode.key = key;
			this.size++;
			return true;
		}
		while(true) {
			if(cNode.key.compareTo(key)<0) {
				if(cNode.right == null) {
					this.size++;
					cNode.right = new BST(key);
				}
				else{
					cNode = cNode.right;
				}
			}
			else if(cNode.key.compareTo(key)>0) {
				if(cNode.left == null) {
					this.size++;
					cNode.left = new BST(key);
				}
				else{
					cNode = cNode.left;
				}
			}
			else if(cNode.key.compareTo(key)==0) {
				return false;
			}
		}
	}

	public void inorder() {
		if(left != null) {
			left.inorder();
		}
		System.out.println("Visited : "+this.key+ ", TreeSize : "+this.treesize());
		if(right != null) {
			right.inorder();
		}
	}
}