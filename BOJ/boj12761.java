import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj12761 {

	public static int A, B, N, M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		
		BFS();
		
	}
	public static void BFS() {
		int dongkyu = N;
		Queue<Integer> all = new LinkedList<Integer>();
		if(dongkyu+1>=0) all.add(dongkyu+1);
		if(dongkyu-1>=0) all.add(dongkyu-1);
		if(dongkyu+A>=0) all.add(dongkyu+A);
		if(dongkyu-A>=0) all.add(dongkyu-A);
		if(dongkyu+B>=0) all.add(dongkyu+B);
		if(dongkyu-B>=0) all.add(dongkyu-B);
		if(dongkyu*A>=0) all.add(dongkyu*A);
		if(dongkyu*B>=0) all.add(dongkyu*B);
		
	}
	

}
