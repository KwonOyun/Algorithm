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
	public static Point Redbead, Bluebead;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		matrix = new char[N+1][M+1];
		Rqueue = new LinkedList<Point>();  //빨간구슬 큐
		Bqueue = new LinkedList<Point>();  //파란구슬 큐

		for(int i=1; i<=N; i++) {    //보드 입력
			String temp = sc.next();
			for(int j=1; j<=M; j++) {
				matrix[i][j] = temp.charAt(j-1);
				if(matrix[i][j] == 'R') {
					Rqueue.add(new Point(i,j));   //빨간구슬
				}
				else if(matrix[i][j] == 'B') {
					Bqueue.add(new Point(i,j));  //파란구슬 
				}
				else if(matrix[i][j] == 'O') {  //구멍의 좌표 설정
					targetX = i; targetY = j;
				}
			}
		}
		Solution();
		if(count>10) System.out.println(-1);
	}

	public static void Solution() {
		while(!Rqueue.isEmpty()) {
			int size = Rqueue.size();
			while(size-->0) {  //왼쪽 위쪽 오른쪽 아래쪽
				Redbead = Rqueue.poll();
				Bluebead = Bqueue.poll();
				leftmove();
				upmove();
				rightmove();
				downmove();
			}
			count++;
		}
	}

	public static void leftmove() {
		if(Redbead.x == Bluebead.x) {  //두 개의 구슬이 같은 이동경로에 있을 경우
			if(Redbead.y > Bluebead.y) {
				int temp=0;
				for(int i=Bluebead.y-1; i>=1; i--) {
					if(matrix[Bluebead.x][i]=='#') {
						Bqueue.add(new Point(Bluebead.x,i+1));
						temp = i+1;
						break;
					}
					else if(matrix[Bluebead.x][i]=='O') return;  //파란색공이 구멍에 들어갔을 경우 메소드 종료
				}
				for(int i=Redbead.y-1; i>=1; i--) {
					if(matrix[Redbead.x][i]=='#' || i==temp) {
						Rqueue.add(new Point(Redbead.x,i+1));
						break;
					}
					else if(matrix[Redbead.x][i]=='O') {
						System.out.println(count+1);
						System.exit(0);
					}
				}
			}
			else if(Redbead.y<Bluebead.y){
				int temp=0;
				for(int i=Redbead.y-1; i>=1; i--) {
					if(matrix[Redbead.x][i]=='#') {
						Rqueue.add(new Point(Redbead.x, i+1));
						temp = i+1;
						break;

					}
					else if(matrix[Redbead.x][i]=='O') {
						for(int j=Redbead.y+1; j<Bluebead.y; j++) {
							if(matrix[Redbead.x][j]=='#') {
								System.out.println(count+1);
								System.exit(0);
							}
						}
						return;
					}
				}
				for(int i=Bluebead.y-1; i>=1; i--) {
					if(matrix[Bluebead.x][i]=='#' || i==temp) {
						Bqueue.add(new Point(Bluebead.x,i+1));
						break;
					}
					else if(matrix[Bluebead.x][i]=='O') return;   //파란색공이 구멍에 들어갔을 경우 메소드 종료
				}
				
			}
		}
		else {   //두 개의 구슬이 다른 이동경로에 있을 경우
			for(int i=Redbead.y-1; i>=1; i--) {
				if(matrix[Redbead.x][i]=='#') {
					Rqueue.add(new Point(Redbead.x, i+1));
					break;	
				}
				else if(matrix[Redbead.x][i] =='O') {
					System.out.println(count+1);
					System.exit(0);
				}
			}

			for(int i=Bluebead.y-1; i>=1; i--) {
				if(matrix[Bluebead.x][i]=='#') {
					Rqueue.add(new Point(Bluebead.x, i+1));
					break;	
				}
				else if(matrix[Bluebead.x][i]=='O') return;   //파란색공이 구멍에 들어갔을 경우 메소드 종료
			}
		}
	}

	public static void upmove() {  //위로 이동
		if(Redbead.y == Bluebead.y) {  //두 개의 구슬이 같은 이동경로에 있을 경우
			if(Redbead.x > Bluebead.x) {
				int temp=0;
				for(int i=Bluebead.x-1; i>=1; i--) {
					if(matrix[i][Bluebead.y]=='#') {
						Bqueue.add(new Point(Bluebead.x,i+1));
						temp = i+1;
						break;
					}
					else if(matrix[i][Bluebead.y]=='O') return;  //파란색공이 구멍에 들어갔을 경우 메소드 종료
				}
				for(int i=Redbead.x-1; i>=1; i--) {
					if(matrix[i][Redbead.y]=='#' || i==temp) {
						Rqueue.add(new Point(Redbead.x,i+1));
						break;
					}
					else if(matrix[i][Redbead.y]=='O') {
						System.out.println(count+1);
						System.exit(0);
					}
				}
			}
			else if(Redbead.x<Bluebead.x){
				int temp=0;
				for(int i=Redbead.x-1; i>=1; i--) {
					if(matrix[i][Redbead.y]=='#') {
						Rqueue.add(new Point(Redbead.x, i+1));
						temp = i+1;
						break;

					}
					else if(matrix[i][Redbead.y]=='O') {
						for(int j=Redbead.x+1; j<Bluebead.x; j++) {
							if(matrix[Redbead.x][j]=='#') {
								System.out.println(count+1);
								System.exit(0);
							}
						}
						return;
					}
				}
				for(int i=Bluebead.x-1; i>=1; i--) {
					if(matrix[i][Bluebead.y]=='#' || i==temp) {
						Bqueue.add(new Point(i+1,Bluebead.y));
						break;
					}
					else if(matrix[Bluebead.x][i]=='O') return;   //파란색공이 구멍에 들어갔을 경우 메소드 종료
				}
				
			}
		}
		else {   //두 개의 구슬이 다른 이동경로에 있을 경우
			for(int i=Redbead.x-1; i>=1; i--) {
				if(matrix[i][Redbead.y]=='#') {
					Rqueue.add(new Point(i+1, Redbead.y));
					break;	
				}
				else if(matrix[i][Redbead.y] =='O') {
					System.out.println(count+1);
					System.exit(0);
				}
			}

			for(int i=Bluebead.x-1; i>=1; i--) {
				if(matrix[i][Bluebead.y]=='#') {
					Rqueue.add(new Point(i+1, Redbead.y));
					break;	
				}
				else if(matrix[i][Redbead.y]=='O') return;   //파란색공이 구멍에 들어갔을 경우 메소드 종료
			}
		}
	}

	public static void rightmove() {
		if(Redbead.x == Bluebead.x) {  //두 개의 구슬이 같은 이동경로에 있을 경우
			if(Redbead.y < Bluebead.y) {
				int temp=0;
				for(int i=Bluebead.y+1; i<=M; i++) {
					if(matrix[Bluebead.x][i]=='#') {
						Bqueue.add(new Point(Bluebead.x,i-1));
						temp = i-1;
						break;
					}
					else if(matrix[Bluebead.x][i]=='O') return;  //파란색공이 구멍에 들어갔을 경우 메소드 종료
				}
				for(int i=Redbead.y+1; i<=M; i++) {
					if(matrix[Redbead.x][i]=='#' || i==temp) {
						Rqueue.add(new Point(Redbead.x,i-1));
						break;
					}
					else if(matrix[Redbead.x][i]=='O') {
						System.out.println(count+1);
						System.exit(0);
					}
				}
			}
			else if(Redbead.y>Bluebead.y){
				int temp=0;
				for(int i=Redbead.y+1; i<=M; i++) {
					if(matrix[Redbead.x][i]=='#') {
						Rqueue.add(new Point(Redbead.x, i-1));
						temp = i-1;
						break;

					}
					else if(matrix[Redbead.x][i]=='O') {
						for(int j=Redbead.y-1; j>Bluebead.y; j--) {
							if(matrix[Redbead.x][j]=='#') {
								System.out.println(count+1);
								System.exit(0);
							}
						}
						return;
					}
				}
				for(int i=Bluebead.y+1; i<=M; i++) {
					if(matrix[Bluebead.x][i]=='#' || i==temp) {
						Bqueue.add(new Point(Bluebead.x,i-1));
						break;
					}
					else if(matrix[Bluebead.x][i]=='O') return;   //파란색공이 구멍에 들어갔을 경우 메소드 종료
				}
				
			}
		}
		else {   //두 개의 구슬이 다른 이동경로에 있을 경우
			for(int i=Redbead.y+1; i<=M; i++) {
				if(matrix[Redbead.x][i]=='#') {
					Rqueue.add(new Point(Redbead.x, i-1));
					break;	
				}
				else if(matrix[Redbead.x][i] =='O') {
					System.out.println(count+1);
					System.exit(0);
				}
			}

			for(int i=Bluebead.y+1; i<=M; i++) {
				if(matrix[Bluebead.x][i]=='#') {
					Rqueue.add(new Point(Bluebead.x, i-1));
					break;	
				}
				else if(matrix[Bluebead.x][i]=='O') return;   //파란색공이 구멍에 들어갔을 경우 메소드 종료
			}
		}
	}

	public static void downmove() {
		if(Redbead.y == Bluebead.y) {  //두 개의 구슬이 같은 이동경로에 있을 경우
			if(Redbead.x < Bluebead.x) {
				int temp=0;
				for(int i=Bluebead.x+1; i<=N; i++) {
					if(matrix[i][Bluebead.y]=='#') {
						Bqueue.add(new Point(i-1,Bluebead.y));
						temp = i-1;
						break;
					}
					else if(matrix[i][Bluebead.y]=='O') return;  //파란색공이 구멍에 들어갔을 경우 메소드 종료
				}
				for(int i=Redbead.x+1; i<=N; i++) {
					if(matrix[i][Redbead.y]=='#' || i==temp) {
						Rqueue.add(new Point(i,Redbead.y));
						break;
					}
					else if(matrix[i][Redbead.y]=='O') {
						System.out.println(count+1);
						System.exit(0);
					}
				}
			}
			else if(Redbead.x>Bluebead.x){
				int temp=0;
				for(int i=Redbead.x+1; i<=N; i++) {
					if(matrix[i][Redbead.y]=='#') {
						Rqueue.add(new Point(i-1, Redbead.y));
						temp = i-1;
						break;

					}
					else if(matrix[i][Redbead.y]=='O') {
						for(int j=Redbead.x-1; j>Bluebead.x; j--) {
							if(matrix[j][Redbead.y]=='#') {
								System.out.println(count+1);
								System.exit(0);
							}
						}
						return;
					}
				}
				for(int i=Bluebead.x+1; i<=N; i++) {
					if(matrix[i][Bluebead.y]=='#' || i==temp) {
						Bqueue.add(new Point(i-1,Bluebead.y));
						break;
					}
					else if(matrix[i][Bluebead.y]=='O') return;   //파란색공이 구멍에 들어갔을 경우 메소드 종료
				}
				
			}
		}
		else {   //두 개의 구슬이 다른 이동경로에 있을 경우
			for(int i=Redbead.x+1; i<=N; i++) {
				if(matrix[i][Redbead.y]=='#') {
					Rqueue.add(new Point(i-1, Redbead.y));
					break;	
				}
				else if(matrix[i][Redbead.y] =='O') {
					System.out.println(count+1);
					System.exit(0);
				}
			}

			for(int i=Bluebead.x+1; i<=N; i++) {
				if(matrix[i][Bluebead.y]=='#') {
					Rqueue.add(new Point(i-1, Bluebead.y));
					break;	
				}
				else if(matrix[i][Bluebead.y]=='O') return;   //파란색공이 구멍에 들어갔을 경우 메소드 종료
			}
		}
	}

}
