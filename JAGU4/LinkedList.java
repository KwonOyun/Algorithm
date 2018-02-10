

public class LinkedList {
	Node start; /* LinkedList 노드로 사용되는 변수 */

	class Node {
		private int x; /* 노드에 저장되는 정수 */
		private Node next; /* next 노드 */

		public Node(int x) {
			this.x = x;
		}
		private Node(int x, Node next) {
			this.x = x;
			this.next = next;
		}
	}
	
	public void insert(int x) {
		/* 내부 코드 구현 */
		if(start == null) {
			start = new Node(x, null);
		}
		else {
			Node p = start;
			while(p.next != null) {
				p = p.next;
			}
			p.next = new Node(x, null);
		}
	}
	public void print() {
		/* 내부 코드 구현 */
		Node p = start;
		System.out.print(p.x);
		while(p.next != null) {
			System.out.print("-->"+p.next.x);
			p = p.next;
		}
		System.out.println("-->"+p.next);
	}
	public void delete(int x) {
		/* 내부 코드 구현 */
		if(start.x == x) {
			start = start.next;
		}
		else {
			Node p = start;
			while(p.next.x != x) {
				p = p.next;
			}
			p.next = p.next.next;
		}
	}
	public void merge(LinkedList list) {
		/* 내부 코드 구현 */
		Node p = start;
		while(p.next!=null) {
			p = p.next;
		}
		p.next = list.start;
	}
	public void reverse() {
		/* 내부 코드 구현 */
		int size=0;
		Node p = start;
		int[] reverseInt = new int[10];
		while(p != null) {
			reverseInt[size] = p.x;
			p = p.next;
			size++;
		}
		
		for(int i=size-1; i>=0; i--) {
			if(i==size-1) {
				start = new Node(reverseInt[i], null);
			}
			else {
				Node reverse_p = start;
				while(reverse_p.next!=null) {
					reverse_p = reverse_p.next;
				}
				reverse_p.next = new Node(reverseInt[i], null);
			}
		}	
	}
}
