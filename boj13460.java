import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj13460 {

	public static int N, M;
	public static char[][] matrix;
	public static Queue<Point> queue;
	public static int count, targetX, targetY;
	public static Point first, second;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

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
		Solution();
		if(count>10) System.out.println(-1);
	}

	public static void Solution() {
		while(!queue.isEmpty()) {
			int size = queue.size()/2;
			while(size-->0) {  //왼쪽 위쪽 오른쪽 아래쪽
				first = queue.poll();
				second = queue.poll();
				leftmove();
				upmove();
				rightmove();
				downmove();
			}
			count++;
		}
	}

	public static void leftmove() {
		if(first.x == second.x) {
			if(targetX == first.x) {
				if(targetY>first.y && targetY>second.y) {  //왼쪽에 몰려있을때
					int tempY=0;
					for(int i=first.y-1; i>=1; i--) {
						if(matrix[first.x][i] == '#') {
							tempY=i+1;
							matrix[first.x][tempY] = matrix[first.x][Math.min(first.y, second.y)];
							matrix[first.x][tempY+1] = matrix[first.x][Math.max(first.y, second.y)];
							queue.add(new Point(first.x, tempY));
							queue.add(new Point(first.x, tempY+1));
							return;
						}
					}
				}
				else if(targetY>Math.min(first.y, second.y) && targetY<Math.max(first.y, second.y)) {  //중간값일때
					if(matrix[first.x][Math.max(first.y, second.y)]=='R') {
						System.out.println(count+1);
						System.exit(0);
					}
				}
			}
			else {
				int tempY=0;
				for(int i=first.y-1; i>=1; i--) {
					if(matrix[first.x][i] == '#') {
						tempY=i+1;
						matrix[first.x][tempY] = matrix[first.x][Math.min(first.y, second.y)];
						matrix[first.x][tempY+1] = matrix[first.x][Math.max(first.y, second.y)];
						queue.add(new Point(first.x, tempY));
						queue.add(new Point(first.x, tempY+1));
						return;
					}
				}
			}
		}
		else {
			for(int i=first.y-1; i>=1; i--) {  //첫번째 구슬
				if(matrix[first.x][i] == 'O') {
					if(matrix[first.x][first.y] == 'R') {  //R이 구멍이 들어갔을 때 -> 성공
						System.out.println(count+1);
						System.exit(0);
					}
				}
				else if(matrix[first.x][i] == '#') {
					matrix[first.x][i+1] = matrix[first.x][first.y];
					queue.add(new Point(first.x, i+1));
					break;
				}
			}

			for(int i=second.y-1; i>=1; i--) {  //두번재 구슬
				if(matrix[second.x][i] == 'O') {
					if(matrix[second.x][second.y] == 'R') {  //R이 구멍이 들어갔을 때 -> 성공
						System.out.println(count+1);
						System.exit(0);
					}
				}
				else if(matrix[second.x][i] == '#') {
					matrix[second.x][i+1] = matrix[second.x][second.y];
					queue.add(new Point(first.x, i+1));
					break;
				}
			}
		}
	}

	public static void upmove() {
		if(first.y == second.y) {
			if(targetY == first.y) {
				if(targetX>first.x && targetX>second.x) {  //왼쪽에 몰려있을때
					int tempX=0;
					for(int i=first.x-1; i>=1; i--) {
						if(matrix[first.x-1][i] == '#') {
							tempX=i+1;
							matrix[tempX][first.y] = matrix[Math.min(first.x, second.x)][first.y];
							matrix[tempX+1][first.y] = matrix[Math.max(first.x, second.x)][first.y];
							queue.add(new Point(tempX, first.y));
							queue.add(new Point(tempX+1, first.y));
							return;
						}
					}
				}
				else if(targetX>Math.min(first.x, second.x) && targetX<Math.max(first.x, second.x)) {  //중간값일때
					if(matrix[Math.max(first.x, first.y)][first.y]=='R') {
						System.out.println(count+1);
						System.exit(0);
					}
				}
			}
			else {
				int tempX=0;
				for(int i=first.x-1; i>=1; i--) {
					if(matrix[i][first.y] == '#') {
						tempX=i+1;
						System.out.println(tempX+" "+(tempX+1));
						matrix[tempX][first.y] = matrix[Math.min(first.x, second.x)][first.y];
						matrix[tempX+1][first.y] = matrix[Math.max(first.x, second.x)][first.y];
						queue.add(new Point(tempX, first.y));
						queue.add(new Point(tempX+1, first.y));
						return;
					}
				}
			}
		}
		else {
			for(int i=first.x-1; i>=1; i--) {
				if(matrix[i][first.y] == 'O') {
					if(matrix[first.x][first.y] == 'R') {  //R이 구멍이 들어갔을 때 -> 성공
						System.out.println(count+1);
						System.exit(0);
					}
				}
				else if(matrix[first.x][i] == '#') {
					matrix[first.x][i+1] = matrix[first.x][first.y];
					queue.add(new Point(first.x, i+1));
					break;
				}
			}

			for(int i=second.y-1; i>=1; i--) {
				if(matrix[second.x][i] == 'O') {
					if(matrix[second.x][second.y] == 'R') {  //R이 구멍이 들어갔을 때 -> 성공
						System.out.println(count+1);
						System.exit(0);
					}
				}
				else if(matrix[second.x][i] == '#') {
					matrix[second.x][i+1] = matrix[second.x][second.y];
					queue.add(new Point(second.x, i+1));
					break;
				}
			}
		}
	}

	public static void rightmove() {
		if(first.x == second.x) {
			if(targetX == first.x) {
				if(targetY<first.y && targetY<second.y) {  //오른쪽에 몰려있을때
					int tempY=0;
					for(int i=first.y+1; i<=M; i++) {
						if(matrix[first.x][i] == '#') {
							tempY=i-1;
							matrix[first.x][tempY] = matrix[first.x][Math.max(first.y, second.y)];
							matrix[first.x][tempY-1] = matrix[first.x][Math.min(first.y, second.y)];
							queue.add(new Point(first.x, tempY));
							queue.add(new Point(first.x, tempY-1));
							return;
						}
					}
				}
				else if(targetY>Math.min(first.y, second.y) && targetY<Math.max(first.y, second.y)) {  //중간값일때
					if(matrix[first.x][Math.min(first.y, second.y)]=='R') {
						System.out.println(count+1);
						System.exit(0);
					}
				}
			}
			else {
				int tempY=0;
				for(int i=first.y+1; i<=M; i++) {
					if(matrix[first.x][i] == '#') {
						tempY=i-1;
						matrix[first.x][tempY] = matrix[first.x][Math.max(first.y, second.y)];
						matrix[first.x][tempY-1] = matrix[first.x][Math.min(first.y, second.y)];
						queue.add(new Point(first.x, tempY));
						queue.add(new Point(first.x, tempY-1));
						return;
					}
				}
			}
		}
		else {
			for(int i=first.y+1; i<=M; i++) {
				if(matrix[first.x][i] == 'O') {
					if(matrix[first.x][first.y] == 'R') {  //R이 구멍이 들어갔을 때 -> 성공
						System.out.println(count+1);
						System.exit(0);
					}
				}
				else if(matrix[first.x][i] == '#') {
					matrix[first.x][i-1] = matrix[first.x][first.y];
					queue.add(new Point(first.x, i-1));
					break;
				}
			}

			for(int i=second.y+1; i<=M; i++) {
				if(matrix[second.x][i] == 'O') {
					if(matrix[second.x][second.y] == 'R') {  //R이 구멍이 들어갔을 때 -> 성공
						System.out.println(count+1);
						System.exit(0);
					}
				}
				else if(matrix[second.x][i] == '#') {
					matrix[second.x][i-1] = matrix[second.x][second.y];
					queue.add(new Point(first.x, i-1));
					break;
				}
			}
		}
	}

	public static void downmove() {
		if(first.y == second.y) {
			if(targetY == first.y) {
				if(targetX<first.x && targetX<second.x) {  //아래에 몰려있을때
					int tempX=0;
					for(int i=first.x+1; i<=N; i++) {
						if(matrix[i][first.y] == '#') {
							tempX=i-1;
							matrix[tempX][first.y] = matrix[first.x][Math.max(first.y, second.y)];
							matrix[tempX-1][first.y] = matrix[first.x][Math.min(first.y, second.y)];
							queue.add(new Point(tempX, first.y));
							queue.add(new Point(tempX-1, first.y));
							return;
						}
					}
				}
				else if(targetX>Math.min(first.x, second.x) && targetX<Math.max(first.x, second.x)) {  //중간값일때
					if(matrix[Math.min(first.x, second.x)][first.y]=='R') {
						System.out.println(count+1);
						System.exit(0);
					}
				}
			}
			else {
				int tempX=0;
				for(int i=first.x+1; i<=N; i++) {
					if(matrix[i][first.y] == '#') {
						tempX=i-1;
						matrix[tempX][first.y] = matrix[Math.max(first.x, second.x)][first.y];
						matrix[tempX-1][first.y] = matrix[Math.min(first.x, second.x)][first.y];
						queue.add(new Point(tempX, first.y));
						queue.add(new Point(tempX-1, first.y));
						return;
					}
				}
			}
		}
		else {
			for(int i=first.x+1; i<=N; i++) {
				if(matrix[i][first.y] == 'O') {
					if(matrix[first.x][first.y] == 'R') {  //R이 구멍이 들어갔을 때 -> 성공
						System.out.println(count+1);
						System.exit(0);
					}
				}
				else if(matrix[i][first.y] == '#') {
					matrix[i-1][first.y] = matrix[first.x][first.y];
					queue.add(new Point(i-1, first.y));
					break;
				}
			}

			for(int i=second.x+1; i<=N; i++) {
				if(matrix[second.x][i] == 'O') {
					if(matrix[second.x][second.y] == 'R') {  //R이 구멍이 들어갔을 때 -> 성공
						System.out.println(count+1);
						System.exit(0);
					}
				}
				else if(matrix[second.x][i] == '#') {
					matrix[i-1][second.y] = matrix[second.x][second.y];
					queue.add(new Point(i-1, second.y));
					break;
				}
			}
		}
	}

}
