import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7576 {

	public static int M, N;
	public static int[][] matrix;
	public static Queue<Point> queue;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		queue = new LinkedList<Point>();
		matrix = new int[N+1][M+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				matrix[i][j] = sc.nextInt();  //토마토 유무 입력받기
				if(matrix[i][j] == 1) {
					queue.add(new Point(i,j));   //x, y좌표 큐에 추가
				}
			}
		}
		BFS();
		check();
	}

	public static void BFS() {
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			for(int dx=-1; dx<=1; dx++) {
				for(int dy=-1; dy<=1; dy++) {
					if(Math.abs(dx)+Math.abs(dy)==1) {
						int x = temp.x+dx;
						int y = temp.y+dy;
						if(x>=1 && x<=N && y>=1 && y<=M && matrix[x][y] == 0) {
							matrix[x][y] = matrix[temp.x][temp.y]+1;
							queue.add(new Point(x,y));
						}
					}
				}
			}
		}
	}
	public static void check() {
		int ans = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(matrix[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				ans = Math.max(ans, matrix[i][j]);
			}
		}
		System.out.println(ans-1);
	}

}
