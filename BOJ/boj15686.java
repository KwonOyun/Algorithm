import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class boj15686 {

	public static int N;
	public static int M;
	public static int[][] matrix;
	public static ArrayList<Point> chicken;
	public static ArrayList<Point> person;
	public static boolean[] visitchicken;
	public static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		result = 100000;
		chicken = new ArrayList<Point>();
		person = new ArrayList<Point>();
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				matrix[i][j] = sc.nextInt();
				if(matrix[i][j] == 2) {
					chicken.add(new Point(i,j)); //치킨집 좌표 저장
				}
				else if(matrix[i][j] == 1) {
					person.add(new Point(i,j));  //사람 좌표 저장
				}
			}
		}
		visitchicken = new boolean[chicken.size()];  //선택된 치킨집 표시
		selection(0,0);
		System.out.println(result);
	}

	public static void selection(int index, int depth) {  //치킨집 선택하고 거리구하는 메소드
		
		if(depth == M) result = Math.min(result, distance());
		
		else{
			for(int i = index; i<chicken.size(); i++) {
				visitchicken[i] = true;
				selection(i+1, depth+1);	
				visitchicken[i] = false;
			}
		}
	}
	
	public static int distance() {
		int sum = 0;
		for(int i=0; i<person.size(); i++) {   //일반 집
			int minimum=Integer.MAX_VALUE;
			for(int j=0; j<chicken.size(); j++) {  //치킨 집
				if(visitchicken[j]) {
					minimum = Math.min(minimum, Math.abs(chicken.get(j).x-person.get(i).x)+Math.abs(chicken.get(j).y-person.get(i).y));
				}
			}
			sum+=minimum;  //최단거리를 구하고 총 거리에 더하기
		}
		return sum;
	}
	
	public static void reset() {
		for(int i=0; i<chicken.size(); i++) {
			visitchicken[i] = false;
		}
	}
}
