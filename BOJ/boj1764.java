import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class boj1764 {

	public static int N;
	public static int M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		LinkedList<String> A = new LinkedList<String>();
		LinkedList<String> result = new LinkedList<String>();
		
		for(int i=0; i<N; i++) {
			String temp = sc.next();
			A.add(temp);
		}
		Collections.sort(A);  //collection을 통해 Object타입 정렬
		String[] ary = new String[A.size()];  //Arrays메소드를 사용하기 위해 새로운 배열 생성
		ary = A.toArray(ary);  //A객체리스트를 toArray메소드를 통해 배열로 변환
		
		for(int i=0; i<M; i++) {
			String temp = sc.next();
			int index = Arrays.binarySearch(ary, temp);  //Arrays.binarySearch메소드를 통해 ary배열에서 temp를 찾기 위해 이진탐색
			if(index>=0) result.add(temp);
		}
		System.out.println(result.size());
		Collections.sort(result);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
