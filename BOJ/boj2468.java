import java.awt.Point;
import java.util.Scanner;

public class boj2468 {
	
	public static int N;
	public static int[][] matrix;
	public static boolean[][] visited;
	public static int max;
	public static int safezone;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				matrix[i][j] = sc.nextInt();
				if(matrix[i][j]>=max) max = matrix[i][j];
			}
		}
		int count=0;
		for(int a=1; a<max; a++) {
			installpartition(a);
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(visited[i][j] == false) {  //물이 차있지 않을 경우
						DFS(new Point(i,j));
						count++;
					}
				}
			}
			if(count>=safezone) safezone = count;
			count=0;
			reset();
		}
		System.out.println(safezone);
		
	}
	
	public static void DFS(Point dot) {
		int x = dot.x; int y = dot.y;
		visited[x][y] = true;
		if(x+1<=N && visited[x+1][y]==false) {
			DFS(new Point(x+1, y));
		}
		if(y+1<=N && visited[x][y+1]==false) {
			DFS(new Point(x, y+1));
		}
		if(x-1>=1 && visited[x-1][y]==false) {
			DFS(new Point(x-1,y));
		}
		if(y-1>=1 && visited[x][y-1]==false) {
			DFS(new Point(x,y-1));
		}
	}
	
	public static void reset() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	public static void installpartition(int height) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(matrix[i][j]<=height) visited[i][j] = true;
			}
		}
	}
	
	

}
