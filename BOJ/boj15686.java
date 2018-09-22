import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class boj15686 {

	public static int N;
	public static int M;
	public static int[][] matrix;
	public static ArrayList<Point> chickenlist;
	public static ArrayList<Point> personlist;
	public static boolean[] visitchicken;
	public static int result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		result = 1000;
		chickenlist = new ArrayList<Point>();
		personlist = new ArrayList<Point>();
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				matrix[i][j] = sc.nextInt();
				if(matrix[i][j] == 2) {
					chickenlist.add(new Point(i,j)); //치킨집 좌표 저장
				}
				else if(matrix[i][j] == 1) {
					personlist.add(new Point(i,j));  //사람 좌표 저장
				}
			}
		}
		visitchicken = new boolean[chickenlist.size()];
		for(int i=0; i<chickenlist.size(); i++) {
			selection(i, 0);
			reset();
		}
//		System.out.println(result);
	}
	
	public static void selection(int index, int depth) {  //치킨집 선택하고 거리구하는 메소드
		for(int i = index; i<chickenlist.size(); i++) {
			visitchicken[i] = true;
			if(depth==M-1) {
				distance();
				break;
			}
			selection(index+1, depth+1);
			visitchicken[i] = false;
		}
	}
	
	public static void distance() {   //선택된 치킨집에 대해서 각 집까지의 최단 거리들의 합을 구하는 메소드
		int sum = 0;
		int min=100;
		for(int i=0; i<personlist.size(); i++) {
			for(int j=0; j<chickenlist.size(); j++) {
				if(visitchicken[j] == true) {
					int temp = Math.abs(chickenlist.get(j).x-personlist.get(i).x)+Math.abs(chickenlist.get(j).y-personlist.get(i).y);
					if(min>temp) min = temp;  //집에서 치킨집까지의 가장 최단거리를 구하기
				}
			}
			sum+=min;  //최단거리를 구하고 총 거리에 더하기
			min=100;
		}
		System.out.println(sum);
		if(result>sum) result = sum;  //총 거리의 크기 비교
	}
	public static void reset() {
		for(int i=0; i<chickenlist.size(); i++) {
			visitchicken[i] = false;
		}
	}

}
