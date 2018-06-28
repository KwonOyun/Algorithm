import java.util.Scanner;

public class boj2606 {

	public static int N, M;
	public static boolean[][] matrix;
	public static boolean[] visit;
	public static int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] = matrix[b][a] = true;
		}
		DFS(1);
		System.out.println(count);
		
	}
	
	public static Object DFS(int v) {
		visit[v] = true;
		for(int i=1; i<=N; i++) {
			if(matrix[v][i] == true && visit[i] == false) {
				count++;
				DFS(i);
			}
		}
		return null;
	}

}
