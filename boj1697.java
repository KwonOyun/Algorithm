import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 {

	public static int N;
	public static int K;
	public static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[100001];
		BFS();
	}
	
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		int count=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(0<size--){
				int present = queue.poll();
				if(present == K) {
					System.out.println(count);
					break;
				}
				visited[present] = true;
				int next=0;
				int[] nextcase = {+1, -1, present*2};
				for(int i=0; i<3; i++) {
					
					if(i<2) next = present+nextcase[i];
					else next = nextcase[i];
					if(next>0 || next<100000) continue;
					if(visited[next]) continue;
					
					visited[next] = true;
					queue.add(next);
				}
				
			}
			count++;
		}
	}
}
