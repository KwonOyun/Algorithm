import java.util.Scanner;

public class boj2178 {

	public static int N;
	public static int M;
	public static int[][] matrix;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				System.out.print(matrix[i][j]+" ");
			}
		}
	}

}
