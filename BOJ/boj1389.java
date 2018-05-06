import java.util.Scanner;

public class boj1389 {

	public static int N;
	public static int M;
	public static int[][] matrix;
	static final int INF = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		matrix = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) matrix[i][j] = matrix[j][i] = 0;
				else matrix[i][j] = matrix[j][i] = INF;
			}
		}

		for(int i=1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] = matrix[b][a] = 1;
		}

		FloydWarshall();
//		for(int i=1; i<=N; i++) {  //입력받은거 출력
//			for(int j=1; j<=N; j++) {
//				if(matrix[i][j] == INF) System.out.print("INF ");
//				else {
//					System.out.print(matrix[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
	}
	
	public static void FloydWarshall() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(matrix[i][j] > matrix[i][k]+matrix[k][j]) {
						matrix[i][j] = matrix[i][k]+matrix[k][j];					}
				}
			}
		}
		int min=INF;
		int person=0;
		for(int i=1; i<=N; i++) {
			int sum=0;
			for(int j=1; j<=N; j++) {
				if(matrix[i][j] != INF) {
					sum +=matrix[i][j];
				}
			}
			if(sum<min) {
				min = sum;
				person=i;
			}
		}
		System.out.println(person);
	}
}
