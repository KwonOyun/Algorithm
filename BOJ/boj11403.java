import java.util.Scanner;

public class boj11403 {

	public static int N;
	public static int[][] matrix;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		Floywarshall();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void Floywarshall() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(matrix[i][j] == 1) continue;
					if(matrix[i][j] == 0 && matrix[i][k]+matrix[k][j] == 2) {
						matrix[i][j] = 1;
					}
				}
			}
		}
	}

}
