package jagu6_2018;

public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayQueue arrayqueue = new ArrayQueue(10);
		arrayqueue.add(1);arrayqueue.add(2);arrayqueue.add(3);arrayqueue.add(4);arrayqueue.add(5);  //원소추가
		arrayqueue.toString();  //출력
		arrayqueue.remove();arrayqueue.remove();  //원소삭제
		arrayqueue.toString();  //출력
		System.out.println();
		SLinkedQueue slinkedqueue = new SLinkedQueue();
		slinkedqueue.add(6);slinkedqueue.add(7);slinkedqueue.add(8);slinkedqueue.add(9);  //원소추가
		slinkedqueue.toString();  //출력
		slinkedqueue.remove();slinkedqueue.remove();slinkedqueue.remove();slinkedqueue.remove(); //원소삭제
		slinkedqueue.toString();  //출력
		slinkedqueue.add(10);slinkedqueue.add(11);slinkedqueue.add(12); //원소추가
		slinkedqueue.toString();  //출력
		System.out.println();
		System.out.println(slinkedqueue.toArrayQueue());   //출력
	}

}
