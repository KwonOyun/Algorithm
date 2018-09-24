import java.util.Scanner;

public class boj15651 {

	public static int N,M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		DFS("", 0);
	}

	public static void DFS(String str, int depth) {

		if(depth == M) {
			System.out.println(str);
		}
		else {
			for(int i=1; i<=N; i++) {
				String temp = str;
				str+=(i+" ");
				DFS(str, depth+1);
				str = temp;

			}
		}
	}

}
