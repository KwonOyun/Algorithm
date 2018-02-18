import java.util.Random;

public class TestDLinkedList {

	public static DLinkedList list = new DLinkedList();
	public static int size = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertDoublyLL();
		deleteDoublyLL();

	}
	public static void insertDoublyLL() {
		for(int i=0; i<10; i++) {
			list.insert(new Random().nextInt(size)+1);  //난수 생성
			list.print();
		}
	}
	public static void deleteDoublyLL() {
		for(int i=0; i<3; i++) {
			list.delete((int)list.head.next.object);
			list.print();
		}
	}
}
