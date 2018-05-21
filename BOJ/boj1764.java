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
		Collections.sort(A);
		String[] ary = new String[A.size()];
		ary = A.toArray(ary);
		
		for(int i=0; i<M; i++) {
			String temp = sc.next();
			int index = Arrays.binarySearch(ary, temp);
			if(index>=0) result.add(temp);
		}
		System.out.println(result.size());
		Collections.sort(result);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
