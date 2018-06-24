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
		
		N = sc.nextInt();   //입력
		M = sc.nextInt();
		V = sc.nextInt();
		
		for(int i=1; i<=M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			graph[x][y] = graph[y][x] = 1;    //간선 연결
		}
		
		DFS(V);
		
		for(int i=1; i<=N; i++) {   //visited배열 reset
			visited[i] = false;
		}
		
		System.out.println();
		BFS(V);
		
		sc.close();
	}

	public static void DFS(int V) {   //DFS메소드
		System.out.print(V + " ");   //출력
		visited[V] = true;    //방문 표시
		for(int i=1 ; i<=N ; i++) {  //정점의 개수만큼 반복
			if(graph[V][i] == 1 && visited[i] == false) {  //연결되어있고 방문하지 않았으면 
				DFS(i);  //재귀
			} 
		} 
	}
	
	public static void BFS(int V) {   //BFS메소드
		Queue<Integer> queue = new LinkedList<Integer>();  //큐 생성
		int out;  
		
		queue.add(V);   //정점 큐에 삽입
		visited[V] = true;  //방문 표시
		System.out.print(V+" ");  //출력
		
		while(!queue.isEmpty()) {  //큐가 비어있을 때 까지 반복
			out = queue.poll();  //첫번째 값 큐에서 빼기
			for(int i=1; i<=N; i++) {  //정점의 개수만큼 반복
				if(graph[out][i] == 1 && visited[i] == false) {  //연결되어 있고 방문하지 않았으면
					queue.add(i);   //큐에 삽입
					visited[i] = true;  //방문 표시
					System.out.print(i+" "); //새로 방문한 점 출력
				}
			}
		}
		
	}
}
