
public class SlinkedQueue implements Queue {

	Node start;
	int size;
	
	class Node{
		Object x;
		Node next;
		public Node(Object x, Node next) {
			this.x = x;
			this.next = next;
		}
	}
	
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		System.out.print("ADD    "+object+"  |  ");
		if(start==null) {
			start = new Node(object, null);
		}
		else {
			Node p = start;
			while(p.next!=null) {
				p = p.next;
			}
			p.next = new Node(object, null);
		}
		size++;
		print();
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return start.x;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		if(start==null) {
			System.out.println("Queue is Empty");
		}
		else {
			System.out.print("REMOVE "+start.x+"  |  ");
			start = start.next;
			size--;
			print();
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Node p = start;
		if(start!=null) {
			System.out.print(p.x);
			p = p.next;
			while(p!=null) {
				System.out.print("<--"+p.x);
				p = p.next;
			}
			System.out.println("<--"+p);
		}
		else {
			System.out.println(p);
		}
	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		
	}

}
