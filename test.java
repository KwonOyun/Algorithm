import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
	
	public static int A, B, N, M;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		N =sc.nextInt();  //동규위치
		M = sc.nextInt();   //주미 위치
		visited = new boolean[100001];
		
		BFS(N);
	}
	
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		int ans =0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(0<size--) {
				int present = queue.poll();
				if(present == M) {
					System.out.println(ans);
					break;
				}
				visited[present] = true;
				int next =0;
				int[] nextcase = {+1, -1, +A, -A, +B, -B, A, B};
				
				for(int i=0; i<8; i++) {
					if(i<6) next = present + nextcase[i];
					else next = present * nextcase[i];
					
					if(next<0 || next > 100000) continue;
					if(visited[next] == true) continue;
					
					visited[next] = true;
					queue.add(next);
				}
			}
			ans++;
		}
	}

}
