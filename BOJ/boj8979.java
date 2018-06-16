import java.util.Scanner;

public class boj8979 {

	public static int N;  //국가 수
	public static int K;  //등수를 알고 싶은 국가
	public static int[][] nation;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int index=0;
		int gold=0; int silver=0; int bronze=0;
		nation = new int[N+1][3];

		for(int i=1; i<=N; i++) {
			index = sc.nextInt();
			gold = sc.nextInt();
			silver = sc.nextInt();
			bronze = sc.nextInt();
			nation[index][0] = gold; nation[index][1] = silver; nation[index][2] = bronze;
		}
		int count=0;
		for(int i=1; i<=N; i++) {
			if(i==K) continue;
			
			if(nation[i][0]>nation[K][0]) count++;  //금메달비교
			
			else if(nation[i][0]==nation[K][0]){
				if(nation[i][1]>nation[K][1]) count++;   //은메달 비교
				
				else if(nation[i][1]==nation[K][1]){
					if(nation[i][2]>nation[K][2]) count++;  //동메달 비교
				}
			}
		}

		System.out.println(count+1);

	}
}
