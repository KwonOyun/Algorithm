import java.util.Scanner;

public class boj7576 {

	public static int M, N;
	public static int[][] matrix;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		matrix = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				matrix[i][j] = sc.nextInt();
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
