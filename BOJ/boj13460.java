import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj13460 {

	public static int N, M;
	public static char[][] matrix;
	public static Queue<Point> queue;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int targetX, targetY;
		matrix = new char[N+1][M+1];
		queue = new LinkedList<Point>();
		
		for(int i=1; i<=N; i++) {    //보드 입력
			String temp = sc.next();
			for(int j=1; j<=M; j++) {
				matrix[i][j] = temp.charAt(j-1);
				if(matrix[i][j] == 'R' || matrix[i][j] == 'B') {
					queue.add(new Point(i,j));
				}
				else if(matrix[i][j] == 'O') {
					targetX = i; targetY = j;
				}
			}
		}
	}
	
	public static void Solution() {
		
	}

}
