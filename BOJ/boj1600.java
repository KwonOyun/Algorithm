import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1600 {

	public static int K, W, H;
	public static int[][] matrix;
	public static Queue<Point> queue;
	public static boolean[][][] visited;
	public static int count;
	public static int[] monkeyrow = {1, 0, -1, 0};
	public static int[] monkeycol = {0, -1, 0, 1};
	public static int[] horserow = {1, 2, 2, 1, -1, -2, -2 ,-1};
	public static int[] horsecol = {2, 1, -1, -2, -2, -1, 1, 2};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();  //말의 이동을 할 수 있는 횟수
		W = sc.nextInt();  //가로, y좌표
		H = sc.nextInt();  //세로, x좌표

		matrix = new int[H+1][W+1];
		visited = new boolean[H+1][W+1][K+1];
		queue = new LinkedList<Point>();
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=W; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		count=-1;
		queue.add(new Point(1,1,K));
		visited[1][1][K] = true;
		while(!queue.isEmpty()) {
			count++;
			int size = queue.size();
			while(size-->0) {
				Point newpoint = queue.poll();
				int row = newpoint.x;
				int col = newpoint.y;
				if(row == H && col == W) {
					System.out.println(count);
					return;
				}
				for(int i=0; i<4; i++) {
					int nextrow = row + monkeyrow[i];
					int nextcol = col + monkeycol[i];
					
					if(nextrow<1 || nextrow>H || nextcol<1 || nextcol>W) continue;
					if(matrix[nextrow][nextcol] == 1) continue;  //장애물
					if(visited[nextrow][nextcol][newpoint.k]) continue;  //이미 방문
					
					queue.add(new Point(nextrow, nextcol, newpoint.k));
					visited[nextrow][nextcol][newpoint.k] = true;
				}
				
				if(newpoint.k == 0) continue;
				
				for(int i=0; i<8; i++) {
					int nextrow = row + horserow[i];
					int nextcol = col + horsecol[i];
					
					if(nextrow<1 || nextrow>H || nextcol<1 || nextcol>W) continue;
					if(matrix[nextrow][nextcol] == 1) continue;
					if(visited[nextrow][nextcol][newpoint.k-1]) continue;
					
					queue.add(new Point(nextrow, nextcol, newpoint.k-1));
					visited[nextrow][nextcol][newpoint.k-1] = true;
				}
			}
		}
		System.out.println(-1);
	}
}

class Point {
	int x, y, k;
	public Point(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}

}


