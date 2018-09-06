import java.util.Scanner;

public class boj2146 {

	public static int N;
	public static int[][] matrix;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				matrix[i][j] = sc.nextInt();
				
			}
		}
		
		
	}

}
