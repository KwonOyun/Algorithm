import java.util.Scanner;

public class boj14503 {

	public static int N, M;
	public static int RobotX, RobotY;
	public static int d;  //로봇청소기의 초기 방향
	public static int[][] matrix;
	public static int row[] = {-1, 0, 1, 0};
	public static int col[] = {0, 1, 0, -1};
	public static final int BLANK = 0;
	public static final int WALL = 1;
	public static final int CLEANED = 2;
	public static int cleanspace;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[51][51];   //좌표
		RobotX = sc.nextInt(); RobotY=sc.nextInt();
		d = sc.nextInt();
		cleanspace=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		solve(RobotX, RobotY, d);
	}

	public static void solve(int cRow, int cCol, int cDir) {
	
		while(true) {

			int count=0;
			if(matrix[cRow][cCol] == BLANK) {  //빈공간을 경우
				matrix[cRow][cCol] = CLEANED;  //청소
				cleanspace++;
			}

			for(int i=0; i<4; i++) {  //총 4번을 돔

				int nextDir = (cDir - 1 + 4) % 4;  //다음방향설정
				int nextRow = cRow + row[nextDir];  //다음 행의 위치
				int nextCol = cCol + col[nextDir];  //다음 열의 위치

				if(matrix[nextRow][nextCol] == BLANK) {
					cDir = nextDir;
					cRow = nextRow;
					cCol = nextCol;
					break;
				}
				else {
					cDir = nextDir;
				}
				count++;
			}

			if(count==4) {  //네바퀴 다 돌았을 경우

				if(matrix[cRow-row[cDir]][cCol-col[cDir]]==WALL) {
					System.out.println(cleanspace);
					break;
				}
				else {
					cRow-=row[cDir]; cCol-=col[cDir];
				}
			}
		}
	}

}
