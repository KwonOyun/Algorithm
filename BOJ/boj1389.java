import java.util.Scanner;

public class boj1389 {

	public static int N;
	public static int M;
	public static int[][] matrix;
	public static boolean[] visited;  //방문한 점을 표시하는 배열
	public static int count;
	public static int distanceOfnumber;
	public static int[] indexofall;
	public static int[] indexfordot;
	public static int dotindex;
	public static int target;
	public static int startpoint;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		matrix = new int[N+1][N+1];
		visited= new boolean[N+1];
		indexofall = new int[N+1];
		indexfordot = new int[N+1];

		for(int i=1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] = matrix[b][a] = 1;
		}

		//		for(int i=1; i<=N; i++) {  //입력받은거 출력
		//			for(int j=1; j<=N; j++) {
		//				System.out.print(matrix[i][j]+" ");
		//			}
		//			System.out.println();
		//		}

		for(int i=1; i<=N; i++) {
			indexofall[i] = bakonDFS(i);  //각 사람 마다의 케빈 베이컨의 수를 구해서 배열에 입력, 사람선택
			distanceOfnumber = 0;
			visited[i] = false;
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(indexofall[i]+" ");
		}

		for(int i=1; i<N; i++) {   //사람들마다의 케빈 베이컨의 수 중에 가장 작은 값을 찾기위해 내림 차순 정렬
			if(indexofall[i]>=indexofall[i+1]) {
				int temp = indexofall[i];
				indexofall[i] = indexofall[i+1];
				indexofall[i+1] = temp;
			}
		}
//		System.out.println(indexofall[1]);

	}

	public static int bakonDFS(int v) {
		startpoint = v;  //시작점설정
		visited[startpoint] = true;
		int min=0;  //최소값
		for(int i=1; i<=N; i++) {  //자신을 제외한 상대방 선택
			if(v!=i) {
				target = i;  //타켓 설정
				SearchShortestPath(v);  //타켓에 대해 최소 거리를 구한다
				for(int j=0; j<dotindex-1; j++) {
					if(indexfordot[j]>=indexfordot[j+1]) {  //
						int temp = indexfordot[j];
						indexfordot[j] = indexfordot[j+1];
						indexfordot[j+1] = temp;
					}
				}
				min = indexfordot[0];
				distanceOfnumber+=min;   //케빈 베이컨의 수 구하기
			}
			reset();  //리셋
		}
		return distanceOfnumber;
	}

	public static String SearchShortestPath(int v) {
		for(int i=1; i<=N; i++) {
			if(matrix[v][i] == 1 && visited[i] == false) {
				visited[i] = true;
				count++;
				if(target == i) {
					indexfordot[dotindex++] = count;  //타켓까지의 거리입력
					visitedreset(startpoint);
					count=0;
					return "";
				}
				else {
					SearchShortestPath(i);
					return "";
				}
			}
		}
		return "";
	}

	public static void reset() {
		count=0;
		dotindex=0;
		for(int i=0; i<=N; i++) {
			indexfordot[i] = 0;
		}
		for(int i=1; i<=N; i++) {
			if(i!=startpoint) visited[i] = false;
		}
	}

	public static void visitedreset(int start) {
		for(int i=1; i<=N; i++) {
			if(i!=start) {
				visited[i] = false;
			}
		}
	}

}
