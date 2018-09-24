import java.util.Scanner;

public class boj15652 {

	public static int N,M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		DFS("", 1, 0);
	}

	public static void DFS(String str, int index, int depth) {

		if(depth == M) {
			System.out.println(str);
		}
		else {
			for(int i=index; i<=N; i++) {
				String temp = str;
				str+=(i+" ");
				DFS(str, i, depth+1);
				str = temp;

			}
		}
	}

}
