import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1260 {

	public static int N, M, V; 
	public static int x, y; 
	public static int[][] graph = new int[1001][1001]; 
	public static boolean visited[] = new boolean[10001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		for(int i=1; i<=M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			graph[x][y] = graph[y][x] = 1;
		}
		
		DFS(V);
		
		for(int i=1; i<=N; i++) {
			visited[i] = false;
		}
		
		System.out.println();
		BFS(V);
		
		sc.close();
	}

	public static void DFS(int V) {
		System.out.print(V + " "); 
		visited[V] = true; 
		for(int i=1 ; i<=N ; i++) { 
			if(graph[V][i] == 1 && visited[i] == false) { 
				DFS(i); 
			} 
		} 
	}
	
	public static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int out;
		
		queue.add(V);
		visited[V] = true;
		System.out.print(V+" ");
		
		while(!queue.isEmpty()) {
			out = queue.poll();
			for(int i=1; i<=N; i++) {
				if(graph[out][i] == 1 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i+" ");
				}
			}
		}
		
	}
}
