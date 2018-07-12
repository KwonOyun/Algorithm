import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7576 {

	public static int M, N;
	public static int[][] matrix;
	public static Queue<Point> queue;
	public static int count;
	public static int tomato;

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
				if(matrix[i][j]==0) continue;
				
				else if(matrix[i][j] == 1) {
					queue.add(new Point(i,j));   //x, y좌표 큐에 추가
					tomato++;
				}
				
				else if(matrix[i][j] == -1) tomato++;
			}
		}
		BFS();
		if(tomato !=N*M) System.out.println(-1);
	}

	public static void BFS() {
		while(!queue.isEmpty()) {
			if(tomato == N*M) {
				System.out.println(count);
				break;
			}
			int size = queue.size();
			while(size-->0) {
				Point temp = queue.poll();
				int a = temp.x;
				int b = temp.y;
				if(a+1<=N) {
					if(matrix[a+1][b]==0) {
						matrix[a+1][b]=1;
						tomato++;
						queue.add(new Point(a+1,b));
					}
				}
				if(a-1>=1) {
					if(matrix[a-1][b]==0) {
						matrix[a-1][b]=1;
						tomato++;
						queue.add(new Point(a-1,b));
					}

				}
				if(b+1<=N) {
					if(matrix[a][b+1]==0) {
						matrix[a][b+1]=1;
						tomato++;
						queue.add(new Point(a,b+1));
					}
				}
				if(b-1>=1) {
					if(matrix[a][b-1]==0) {
						matrix[a][b-1]=1;
						tomato++;
						queue.add(new Point(a,b-1));
					}
				}
			}
			count++;
		}
	}

}
