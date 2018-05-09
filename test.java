import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
	
	public static int N;
	public static int M;
	public static int V;
	public static int[][] matrix;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		matrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] = matrix[b][a] = 1;
		}
		
		DFS(V);
		Reset();
		BFS(V);
	}
	public static void DFS(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		for(int i=1; i<=N; i++) {
			if(matrix[v][i] == 1 && visited[i] == false) {
				visited[i] = true;
				DFS(i);
			}
		}
	}
	
	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		while(!queue.isEmpty()) {
			int out = queue.poll();
			System.out.print(out+" ");
			for(int i=1; i<=N; i++) {
				if(matrix[out][i] == 1 && visited[i] == false) {
					visited[i] =true;
					queue.add(i);
				}
			}
		}
	}
	
	public static void Reset() {
		for(int i=1; i<=N; i++) visited[i] = false;
		System.out.println();
	}

}
