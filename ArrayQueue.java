package jagu6_2018;

public class ArrayQueue implements Queue {

	int[] array;  //배열
	int capacity; //원소의 개수
	int front;
	int rear;
	
	public ArrayQueue(int size) {
		array = new int[size];
		front = -1;
		rear = -1;
	}
	@Override
	public void add(int x) {
		// TODO Auto-generated method stub
		array[capacity++] = x;  //배열에 원소 추가
		rear++;
	}

	@Override
	public int first() {
		// TODO Auto-generated method stub
		return array[front+1];
	}

	@Override
	public int remove() {
		// TODO Auto-generated method stub
		int x = array[++front];
		array[front] = -1;  //첫 값 삭제
		return x;  //삭제한 값 반환
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return capacity;
	}

	public boolean empty() {
		if(capacity==0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		System.out.print("* Array Queue = [ ");
		for(int i=0; i<=rear; i++) {
			if(array[i] == -1) {
				System.out.print("null");
				if(i!=rear) {
					System.out.print(" | ");
				}
			}
			else {
				System.out.print(array[i]);
				if(i!=rear) {
					System.out.print(" | ");
				}
			}
		}
		System.out.println(" ] (front: "+front+", rear: "+rear+")");
		return "";
	}
	
}
