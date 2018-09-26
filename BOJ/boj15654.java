import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj15654 {

	public static int N,M;
	public static boolean[] visit;
	public static ArrayList<Integer> list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N+1];
		list = new ArrayList();
		for(int i=1; i<=N; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		DFS("",0);
	}
	
	public static void DFS(String str, int depth) {
		if(depth==M) {
			System.out.println(str);
		}
		else {
			for(int i=1; i<=N; i++) {
				if(!visit[i]) {
					visit[i] = true;
					String temp = str;
					str +=list.get(i-1)+" ";
					DFS(str, depth+1);
					str = temp;
					visit[i] = false;
				}
			}
		}
	}

}
