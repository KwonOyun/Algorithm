import java.util.Scanner;

public class boj14502 {

	public static int[][] matrix;
	public static int[][] temp;
	public static boolean[][] visited;
	public static int N;
	public static int M;
	public static int vacant;
	public static int max;
	public static int x1, x2, x3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  //세로
		M = sc.nextInt();  //가로
		matrix = new int[N+1][M+1];
		temp = new int[N+1][M+1];   //초기 입력값을 저장하기 위한 배열
		visited = new boolean[N+1][M+1];

		for(int i=1; i<=N; i++) {   //입력
			for(int j=1; j<=M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		for(int i=1; i<=N; i++) {  //임시배열에 입력받은 배열을 입력
			for(int j=1; j<=M; j++) {
				temp[i][j] = matrix[i][j];
			}
		}

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][j] = 1;
					for(int k=i; k<=N; k++) {
						for(int l=1; l<=M; l++) {
							if(matrix[k][l] == 0) {
								matrix[k][l] = 1;
								for(int a=k; a<=N; a++) {
									for(int b=1; b<=M; b++) {
										if(matrix[a][b] == 0) {
											matrix[a][b] = 1;
											Birus();
											SearchVacant();
											if(vacant>=max) max = vacant;
											Reset();
											for(int tempi=1; tempi<=N; tempi++) {
												for(int tempj=1; tempj<=M; tempj++) {
													if((tempi==i && tempj==j) || (tempi==k && tempj==l) ) {
														continue;
													}
													matrix[tempi][tempj] = temp[tempi][tempj]; 
												}
											}
										}
									}
								}
								matrix[k][l] = 0;
							}
						}
					}
					matrix[i][j] = 0;
				}
			}
		}
		System.out.println(max);  //빈공간 출력
	}

	public static void Birus() {  //바이러스 감염 메소드
		for(int i=1; i<=N; i++) {   
			for(int j=1; j<=M; j++) {
				if(matrix[i][j] == 2 && visited[i][j] == false) {
					visited[i][j] = true;
					DFS(i,j);
				}
			}
		}
	}

	public static void SearchVacant() {  //빈공간을 찾는 메소드
		for(int i=1; i<=N; i++) {   
			for(int j=1; j<=M; j++) {
				if(matrix[i][j] == 0) {
					vacant++;
				}
			}
		}
	}

	public static void Reset() {  //방문표시를 리셋해주는 메소드
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				visited[i][j] = false;
			}
		}
		vacant=0;
	}

	public static void DFS(int x, int y) {  //바이러스 감염을 위한 DFS메소드

		if(x-1>=1 && matrix[x-1][y] == 0) {
			visited[x-1][y] = true;
			matrix[x-1][y] = 2;
			DFS(x-1, y);
		}
		if(y+1<=M && matrix[x][y+1] == 0) {
			matrix[x][y+1] = 2;
			visited[x][y+1] = true;
			DFS(x, y+1);
		}
		if(x+1<=N && matrix[x+1][y] == 0) {
			matrix[x+1][y] = 2;
			visited[x+1][y] = true;
			DFS(x+1, y);
		}
		if(y-1>=1 && matrix[x][y-1] == 0) {
			matrix[x][y-1] = 2;
			visited[x][y-1] = true;
			DFS(x, y-1);
		}
	}

}
