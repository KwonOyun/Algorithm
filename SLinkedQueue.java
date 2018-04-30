package jagu7_2018;

public class SLinkedQueue implements Queue{
	
	private class Node {
		Object object;
		Node next;
		Node(Object object) { this.object=object; }
		Node(Object object, Node next) {
			this.object = object;
			this.next = next;
		}
	}
	
	private Node head;
	private Node rear;
	private int size;
	
	public SLinkedQueue() {
		// TODO Auto-generated constructor stub
		head = new Node(null, null);
	}
	
	@Override
	public void add(Object object) {
	
		if(head.next == null) {
			rear = new Node(object, null);  //새로운 원소 추가
			head.next = rear;
		}
		else {
			rear.next = new Node(object, null);  //새로운 원소 추가
			rear = rear.next;
		}
		size++; //사이즈 증가
	}

	@Override
	public Object first() {
	
		return head.next.object;
	}
	
	@Override
	public Object remove() {
		if(size == 0) {
			System.out.println("queue is empty");
			return 0;
		}
		Object temp = rear.object;
		Node p = head;
		while(p.next != rear) {
			 p = p.next;
		}
		rear = p;
		rear.next = null;
		size--;
		return temp;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	public boolean empty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public void print() {
		System.out.println(this.toString()+"\n");
	}
	
	public String toString() {
		System.out.print("* Singly Linked Queue = head");
		Node p = head.next;
		while(p!=null) {
			System.out.print(" -> "+p.object);
			p = p.next;
		}
		System.out.println();
		return "";
	}
}
