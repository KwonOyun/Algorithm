import java.util.Scanner;

public class boj4948 {

	public static int N;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		while(N>0 && N<=123456) {
			int max = 2*N;
			int halfmax = (int)Math.sqrt(max)+1;
			visited = new boolean[2*N+1];
			for(int i=2; i<halfmax; i++) {
				int temp = i;
				int j=2;
				while(temp*j<=max) {
					if(visited[temp*j] == false) {
						visited[temp*j] = true;
					}
					j++;
				}
			}
			int count =0;
			for(int i=N+1; i<=max; i++) {
				if(visited[i] == false) count++;
			}
			System.out.println(count);
			N = sc.nextInt();
		}

	}

}
