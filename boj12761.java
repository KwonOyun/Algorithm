import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj12761 {

	public static int A, B, N, M;
	public static boolean[] visited;
	public static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[100001];  //각점에 대한 방문 표시 배열
		
		BFS();
		
	}
	public static void BFS() {
		queue.add(N);
		int ans=0;  //시간을 나타내기 위한 변수
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(0<size--) {
				int present = queue.poll();
				visited[present] = true;
				int[] nextcase = {+1, -1, +A, -A, +B, -B, present*A, present*B};
				int next=0;
				for(int i=0; i<8; i++) {
					if(present == M) {
						System.out.println(ans);
						break;
					}
					if(i<6) next = present+nextcase[i];
					else next = nextcase[i];
					
					if(next<0 || next>100000) continue;
					if(visited[next]) continue;
					
					visited[next] = true;
					queue.add(next);
				}
			}
			ans++;  //시간증가
		}
	}
}
