import java.util.Random;

public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedlist = new LinkedList();
		LinkedList linkedlist2 = new LinkedList();
		int size=10;
		Random mRandom = new Random();
		int randomInt[] = new int[size];
		int randomInt2[] = new int[size];
		int i;
		for(i=0; i<size; i++) {  //난수입력
			randomInt[i] = mRandom.nextInt(100)+1;
			for(int j=0; j<i; j++) {
				if(randomInt[i] == randomInt[j]) {
					i--;
					break;
				}
			}
		}
		for(i=0; i<size; i++) {  //난수입력
			randomInt2[i] = mRandom.nextInt(100)+1;
			for(int j=0; j<i; j++) {
				if(randomInt2[i] == randomInt2[j]) {
					i--;
					break;
				}
			}
		}
		for(int a=0; a<size; a++) {  //난수 삽입
			linkedlist.insert(randomInt[a]);
		}
		for(int a=0; a<size; a++) {  //난수 삽입
			linkedlist2.insert(randomInt2[a]);
		}
		System.out.println("******** Insert LinkdList *******");
		linkedlist.print();  //출력
		System.out.println("******** Reverse LinkedList ********");
		linkedlist.reverse();
		linkedlist.print();
		System.out.println("******** Insert LinkdList *******");
		linkedlist2.print();  //출력
		System.out.println("******** Merge LinkedList ********");
		linkedlist.merge(linkedlist2);
		linkedlist.print();
	}

}
