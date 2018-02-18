
public class DLinkedList {

	public Node head = new Node(null);  //Head 노드는 dummy노드 
	private int size = 0;
	
	public void insert(int x) {
		System.out.print("Insert    "+x+" | ");
		if(head.next == head) {   //원소가 하나도 없을 경우
			head.next = new Node(x, head, head);
			size++;
		}
		else {  //그렇지 않을 경우
			Node p = head;
			while(p.next != head) {
				p = p.next;
			}
			p.next = new Node(x, p, head);
			size++;   //노드의 사이즈 1증가
		}
	}
	
	public void delete(int x) {
		System.out.print("Delete    "+x+" | ");
		if(head.next==null) {
			System.out.println("연결리스트의 원소가 없습니다.");;
		}
		else {
			int i = 0;
			Node p = head;
			while((int)p.next.object != x) {
				p = p.next;
				i++;
			}
			if(i==size) {
				System.out.println("연결리스트의 원소가 없습니다.");
			}
			else {
				p.next = p.next.next;
				p.next.prev = p;
				size--;  //노드의 사이즈 1감소
			}
		}
	}
	
	public void print() {
		Node p = head;
		if(p.next != head) {
			System.out.print(p.next.object);
			p = p.next;
			for(int i=1; i<size; i++) {
				System.out.print("<->"+p.next.object);
				p = p.next;
			}
		}
		System.out.println("<->"+p.next.object);
	}
}
