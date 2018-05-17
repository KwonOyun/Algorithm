import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2178 {

	public static int N;
	public static int M;
	public static int[] matrix;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[10001];
		visited = new boolean[10001];
		int index=1;
		for(int i=1; i<=N; i++) {
			String temp = sc.next();
			for(int j=0; j<M; j++) {
				matrix[index++] = Integer.parseInt(temp.charAt(j)+"");
			}
		}
		BFS();
		
	}
	
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		int ans = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(0<size--) {
				int present = queue.poll();
				if(present == N*M) {
					System.out.println(ans);
					break;
				}
				visited[present] = true;
				int next=0;
				int[] nextcase = {+1, -1, +M, -M};
				
				for(int i=0; i<nextcase.length; i++) {
					next = present + nextcase[i];
					if(i==0) {
						if(next%M == 1) continue;
					}
					if(i==1) {
						if(next%M == 0) continue;
					}
					
					if(next<=0 || next > N*M) continue;
					if(matrix[next] == 0) continue;
					if(visited[next] == true) continue;
					
					
					visited[next] = true;
					queue.add(next);
				}
			}
			ans++;
		}
	}

}
