import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1600 {

	public static int K, W, H;
	public static int[][] matrix;
	public static Queue<Point> queue;
	public static int horsecount;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		
		matrix = new int[W+1][H+1];
		queue = new LinkedList<Point>();
		for(int i=1; i<=W; i++) {
			for(int j=1; j<=H; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		queue.add(new Point(0,0));
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int[] horsemove = {};
			}
		}
	}

}
