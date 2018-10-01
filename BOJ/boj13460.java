import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj13460 {

	public static int N,M;
	public static char[][] matrix;
	public static Queue<Point> Red = new LinkedList();
	public static Queue<Point> Blue = new LinkedList();
	public static int holeX, holeY;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		matrix = new char[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String temp = sc.next();
			for(int j=1; j<=M; j++) {
				if(temp.charAt(j-1)=='R') {
					Red.add(new Point(i,j));  //빨간 구슬 좌표
				}
				if(temp.charAt(j-1)=='B') {
					Blue.add(new Point(i,j));   //파란 구슬 좌표
				}
				if(temp.charAt(j-1)=='O') {
					holeX = i; holeY = j;  //구멍 좌표 입력
				}
				matrix[i][j] = temp.charAt(j-1);
			}
		}
	}

	public static void left() {
		int redX = Red.poll().x; int blueX = Blue.poll().x;
		int redY = Red.poll().y; int blueY = Blue.poll().y;
		if(redX<blueX) {
			for(int i=redX-1; i>=2; i--) {
				if(i==holeX && redY==holeY) {   //구멍에 빨간구슬이 들어갈때
					System.out.println();
					System.exit(0);
				}
				else if(matrix[i][redY] == '#') {
					Red.add(new Point(i+1,redY));
					if(redY==blueY) Blue.add(new Point(i+2, blueY));
				}
			}
		}
		else if(redX>blueX) {
			
		}
	}

	public static void up() {

	}

	public static void right() {

	}

	public static void down() {

	}

}
