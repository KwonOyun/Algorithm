import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj13460 {

	public static int N, M;
	public static char[][] matrix;
	public static Queue<Point> Rqueue;
	public static Queue<Point> Bqueue;
	public static int count, targetX, targetY;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		matrix = new char[N+1][M+1];
		Rqueue = new LinkedList<Point>();
		Bqueue = new LinkedList<Point>();
		
		for(int i=1; i<=N; i++) {    //보드 입력
			String temp = sc.next();
			for(int j=1; j<=M; j++) {
				matrix[i][j] = temp.charAt(j-1);
				if(matrix[i][j] == 'R') Rqueue.add(new Point(i,j));
				else if(matrix[i][j] == 'B') Bqueue.add(new Point(i,j));
				else if(matrix[i][j] == 'O') targetX = i; targetY = j;
			}
		}
		
		Solution();
	}
	
	public static void Solution() {
		while(!Rqueue.isEmpty()) {
			int size = Rqueue.size();
			while(size-->0) {
				Point rp = Rqueue.poll();
				Point bp = Bqueue.poll();
				int Rx = rp.x; int Ry = rp.y;  //Red의 좌표
				int Bx = bp.x; int By = bp.y;  //Blue의 좌표
				
				if(Rx==targetX && Ry<targetY) {
					count++;
					System.out.println(count);
					return;
				}
				else {
					for(int i=2; i<Ry; i++) {
						if(matrix[i][Ry] == '.') {
							Rqueue.add(new Point(i, Ry));
						}
					}
				}
				
			}
			count++;
		}
	}

}
