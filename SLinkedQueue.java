package jagu6_2018;

public class SLinkedQueue implements Queue{

	int size;
	Node head;
	Node rear;
	
	class Node{
		int x;
		Node next;
		
		public Node(int x, Node next) {
			this.x = x;
			this.next = next;
		}
	}
	
	public SLinkedQueue() {
		// TODO Auto-generated constructor stub
		head = new Node(-1, null);
	}
	
	@Override
	public void add(int x) {
		// TODO Auto-generated method stub
		if(head.next == null) {
			rear = new Node(x, null);  //새로운 원소 추가
			head.next = rear;
		}
		else {
			rear.next = new Node(x, null);  //새로운 원소 추가
			rear = rear.next;
		}
		size++; //사이즈 증가
	}

	@Override
	public int first() {
		// TODO Auto-generated method stub
		return head.next.x;
	}

	@Override
	public int remove() {
		// TODO Auto-generated method stub
		if(size == 0) {
			System.out.println("queue is empty");
			return 0;
		}
		int temp = rear.x;
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
		// TODO Auto-generated method stub
		return size;
	}
	
	public boolean empty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		System.out.print("* Singly Linked Queue = head");
		Node p = head.next;
		while(p!=null) {
			System.out.print(" -> "+p.x);
			p = p.next;
		}
		System.out.println();
		return "";
	}
	public ArrayQueue toArrayQueue() {
		ArrayQueue arrayqueue = new ArrayQueue(10);
		Node p = head.next;
		while(p != null) {
			arrayqueue.add(p.x);
			p = p.next;
		}
		System.out.println("[Change from SLinked_Q to Array_Q]");
		return arrayqueue;
	}
}

