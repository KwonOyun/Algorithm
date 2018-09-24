import java.util.Scanner;

public class boj15650 {

	public static int N,M;
	public static boolean[] visit;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N+1];
		
		DFS(1,0);
	}
	public static void DFS(int index, int depth) {
		if(depth == M) {
			for(int i=1; i<=N; i++) {
				if(visit[i]) System.out.print(i+" ");
			}
			System.out.println();
		}
		else {
			for(int i=index; i<=N; i++) {
				visit[i] = true;
				DFS(i+1, depth+1);
				visit[i] = false;
			}
		}
	}

}
