package jagu9_2018;

import java.util.LinkedList;
import java.util.List;

public class OrderedTree {
	private Object root;
	private List subtrees;
	private int size;
	
	public OrderedTree() {
		
	}
	public OrderedTree(Object root) {
		this.root = root;
		subtrees = new LinkedList();
		size=1;
	}
	
	public OrderedTree(Object root, List trees) {
		this.root = root;
		subtrees = trees;
		size = trees.size()+1;
	}
	public int size() {
		return size;
	}
	
	public void levelOrder() {
		System.out.print("Level Order : ");
		SLinkedQueue queue = new SLinkedQueue();
		queue.add(this);
		while(!queue.empty()) {
			OrderedTree out = (OrderedTree)queue.first();  //큐에서 첫번재 노드 선택
			queue.remove(); //첫번째 노드 삭제
			System.out.print(out.root+" ");  //첫번째 노드 방문
			for(int i=0; i<out.size()-1; i++) {   //해당 노드의 모든 자식들을 큐에 삽입
				queue.add(out.subtrees.get(i));
			}
		}
	}

}
