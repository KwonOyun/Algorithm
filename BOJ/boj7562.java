import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7562 {
	
	public static int testcase;
	public static int I;
	public static int startX, startY, endX, endY;
	public static int[][] matrix;
	public static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		testcase = sc.nextInt();
		
		for(int i=0; i<testcase; i++) {
			I = sc.nextInt();
			visited = new boolean[I][I];
			matrix = new int[I][I];
			startX = sc.nextInt();
			startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();
			BFS();
			
		}
	}
	
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startX); queue.add(startY);
		int count=0;
		while(!queue.isEmpty()) {
			int size = queue.size()/2;
			while(0<size--) {
				int presentX = queue.poll();
				int presentY = queue.poll();
				if(presentX == endX && presentY == endY) {
					System.out.println(count);
					break;
				}
				visited[presentX][presentY] = true;
				int nextX=0; int nextY=0;
				int check=0;
				int[] nextcase = {+1, +2, +2, +1, +2, -1, +1, -2, -1, -2, -2, -1, -2, +1, -1, +2};
				for(int i=0; i<nextcase.length; i++) {
					
					if(i%2==0) nextX = presentX+nextcase[i];  //x좌표 더하기
					else nextY = presentY+nextcase[i];  //y좌표 더하기
					
					check++;
					if(check%2==0) {
						if(nextX<0 || nextY<0) continue;
						if(nextX>=I || nextY>=I) continue;
						if(visited[nextX][nextY] == true) continue;
						queue.add(nextX); queue.add(nextY);
						visited[nextX][nextY] = true;
					}
				}
			}
			count++;
		}
	}

}
