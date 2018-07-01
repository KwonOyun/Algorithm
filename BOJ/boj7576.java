import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7576 {

	public static int M, N;
	public static int[][] matrix;
	public static Queue<Integer> queue;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		queue = new LinkedList<Integer>();
		matrix = new int[N+1][M+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(matrix[i][j] == 1) {
					queue.add(i); queue.add(j);   //x, y좌표 큐에 추가
				}
			}
		}
		while(!queue.isEmpty()) {
			int size = queue.size()/2;
			while(size-->0) {
				int a = queue.poll();
				int b = queue.poll();
				if(a+1<=M) {
					if(matrix[a+1][b]==0) {
						matrix[a+1][b]=1;
						queue.add(a+1); queue.add(b);
					}
				}
				if(a-1>=0) {
					
				}
				if(b+1<=N) {
					
				}
				if(b-1>=0) {
					
				}
				
				
			}
		}

		//		for(int i=1; i<=N; i++) {  //입력배열 출력
		//			for(int j=1; j<=M; j++) {
		//				System.out.print(matrix[i][j]);
		//			}
		//			System.out.println();
		//		}



	}

}
