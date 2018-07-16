import java.awt.Point;
import java.util.Scanner;

public class boj2468 {
	
	public static int N;
	public static int[][] matrix;
	public static boolean[][] visited;
	public static int max;
	public static int safezone, count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		safezone=0;
		count=0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				matrix[i][j] = sc.nextInt();
				if(matrix[i][j]>=max) max = matrix[i][j];
			}
		}
		for(int a=0; a<max; a++) {  //최대 높이까지 실행
			installpartition(a); //물에 잠긴 영역 표시
			for(int i=1; i<=N; i++) { 
				for(int j=1; j<=N; j++) {
					if(visited[i][j] == false) {  //물이 차있지 않을 경우
						DFS(new Point(i,j));
						count++;
					}
				}
			}
			if(count>safezone) safezone = count;
			count=0;
			reset();
		}
		System.out.println(safezone);
		
	}
	
	public static void DFS(Point dot) {
		int x = dot.x; int y = dot.y;
		visited[x][y] = true;
		if(x+1<=N && visited[x+1][y]==false) {  //아래
			DFS(new Point(x+1, y));
		}
		if(y+1<=N && visited[x][y+1]==false) {  //우
			DFS(new Point(x, y+1));
		}
		if(x-1>=1 && visited[x-1][y]==false) {  //위
			DFS(new Point(x-1,y));
		}
		if(y-1>=1 && visited[x][y-1]==false) {  //좌
			DFS(new Point(x,y-1));
		}
	}
	
	public static void reset() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(visited[i][j]==true) visited[i][j] = false;
			}
		}
	}
	
	public static void installpartition(int height) {  //잠긴 곳을 표시하기 위한 메소드
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(matrix[i][j]<=height) visited[i][j] = true;  //높이보다 작을 경우 물에 잠김, true로 표시
			}
		}
	}
	
	

}
