import java.util.Scanner;

public class boj1722 {

	public static int N;
	public static int K;
	public static boolean[] visited;
	public static int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[N+1];
		
		if(K==1) {
			for(int i=1; i<=N; i++) {
				DFS(i);
			}
		}
		else if(K==2) {
			
		}
	}
	
	public static void DFS(int v) {
		visited[v] = true;
		for(int i=1; i<=N; i++) {
			if(v==i) continue;
			if(visited[i] = false) {
				DFS(i);
			}
		}
	}

}
