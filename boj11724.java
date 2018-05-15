import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj11724 {

	public static int N;
	public static int M;
	public static int[][] matrix;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] = matrix[b][a] = 1;
		}
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(visited[i]==false) {
				BFS(i);
				count++;
			}
		}
		System.out.println(count);
		
	}
	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		while(!queue.isEmpty()) {
			int out = queue.poll();
			visited[out] = true;
			for(int i=1; i<=N; i++) {
				if(matrix[out][i] == 1 &&  visited[i] == false) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
	}

}
