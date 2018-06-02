import java.util.Scanner;

public class boj2583 {

	static int M;
	static int N;
	static int K;
	static int[][] square;
	static boolean[] visited;
	static int squarewidth[];
	static int count; //빈공간 개수


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();   //세로
		N = sc.nextInt();   //가로
		K = sc.nextInt();   //사각형 개수
		square = new int[K][4];  //사각형 정보 입력 배열 생성
		visited = new boolean[M*N+1];   //방문한 사각형을 나타내기 위한 boolean배열
		squarewidth = new int[M*N];   //빈공간 사각형의 넓이들의 배열

		for(int i=0; i<K; i++) {
			for(int j=0; j<4; j++) {
				square[i][j] = sc.nextInt();   //사각형 정보 입력
			}
		}

		for(int i=0; i<K; i++) {
			for(int a=0; a<square[i][3]-square[i][1]; a++) {
				for(int j=1; j<=square[i][2]-square[i][0]; j++) {
					visited[(square[i][1]+a)*N+j+square[i][0]] = true;  //검은색 빗금 표시
				}
			}
		}

		for(int i=1; i<=M*N; i++) {   //사각형을 처음부터 끝까지 방문 안한 사각형에 대해서 DFS메소드 수행
			if(visited[i] == false) {
				visited[i] = true;
				squarewidth[count]++;
				DFS(i);
				count++;
			}
		}

		for(int a=0; a<count-1; a++) {  //오름 차순 정렬
			for(int i=0; i<count-1; i++) {
				if(squarewidth[i]>=squarewidth[i+1]) {
					int temp = 0;
					temp = squarewidth[i];
					squarewidth[i] = squarewidth[i+1];
					squarewidth[i+1] = temp;
				}
			}
		}

		System.out.println(count);
		for(int i=0; i<count; i++) {
			System.out.print(squarewidth[i]+" ");
		}
	}

	public static String DFS(int index) {

		if(index-1>0 && (index-1)%N != 0 && visited[index-1] == false) {
			visited[index-1] = true;
			squarewidth[count]++;
			DFS(index-1);
		}
		if(index+N<=M*N && visited[index+N] == false) {
			visited[index+N] = true;
			squarewidth[count]++;
			DFS(index+N);
		}
		if(index+1<=M*N && (index+1)%N != 1 && visited[index+1] == false) {
			visited[index+1] = true;
			squarewidth[count]++;
			DFS(index+1);
		}
		if(index-N>0 && visited[index-N] == false) {
			visited[index-N] = true;
			squarewidth[count]++;
			DFS(index-N);
		}
		return "";
	}

}
