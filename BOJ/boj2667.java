import java.util.Scanner;

public class boj2667 {
	
	public static int N; //5<=N<=25
	public static int[][] matrix;
	public static boolean[][] visited;
	public static int[] result;
	public static int resultcount;
	public static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N+1][N+1];
		result = new int[N*N];
		visited = new boolean[N+1][N+1];
		resultcount =1;
		
		for(int i=1; i<=N; i++) {
			String temp = sc.next();
			for(int j=0; j<N; j++) {
				matrix[i][j+1] = Integer.parseInt(temp.charAt(j)+"");
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(matrix[i][j] == 1 && visited[i][j] == false) {
					DFS(i,j);
					result[resultcount++] = count;
					count=0;
				}
			}
		}
		for(int i=0; i<resultcount-1; i++) {  //오름차순 정렬
			for(int j=1; j<resultcount-1; j++) {
				if(result[j]>=result[j+1]) {
					int temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;
				}
			}
		}
		System.out.println(resultcount-1);  //단지수 출력
		for(int i=1; i<resultcount; i++) {  //오름차순으로 출력
			System.out.println(result[i]);
		}
	}
	
	public static void DFS(int x, int y) {
		matrix[x][y] = resultcount;
		visited[x][y] = true;
		count++;
		if((x-1>0 && x-1<=N) && visited[x-1][y] == false && matrix[x-1][y] == 1) {
			DFS(x-1, y);
		}
		if((y+1>0 && y+1<=N) && visited[x][y+1] == false && matrix[x][y+1] == 1) {
			DFS(x, y+1);
		}
		if((x+1>0 && x+1<=N) && visited[x+1][y] == false && matrix[x+1][y] == 1) {
			DFS(x+1, y);
		}
		if((y-1>0 && y-1<=N) && visited[x][y-1] == false && matrix[x][y-1] == 1) {
			DFS(x, y-1);
		}
	}

}
