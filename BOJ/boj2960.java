import java.util.Scanner;

public class boj2960 {

	public static int N;
	public static int K;
	public static boolean[] visited;
	public static int count;
	public static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[N+1];

		for(int i=2; i<=N; i++) {
			if(visited[i] == false) {
				int j=1;
				while(i*j<=N) {
					if(visited[i*j] == false) {
						visited[i*j] = true;
						count++;
						if(count==K) {
							result = i*j; 
						}
					}
					j++;
				}
			}
		}
		System.out.println(result);
	}

}
