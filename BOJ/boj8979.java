import java.util.Arrays;
import java.util.Scanner;

public class boj8979 {

	public static int N;
	public static int K;
	public static int[] nation;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int index=0;
		int gold =0; int silver=0; int bronze=0;
		nation = new int[N+1];
		for(int i=1; i<=N; i++) {
			index = sc.nextInt();
			gold = sc.nextInt();
			silver = sc.nextInt();
			bronze = sc.nextInt();
			nation[index] = gold*100+silver*10+bronze;
		}
		int search = nation[K];
		int count=0;
		Arrays.sort(nation);
//				for(int i=1; i<=N; i++) {
//					System.out.println(nation[i]);
//				}
		//		for(int i=N; i>0; i--) {
		//			if(nation[i]/100 > nation[K]/100) count++;
		//			else if(nation[i]/100==nation[K]/100) {
		//				if((nation[i]%100)/10>(nation[K]%100)/10) count++;
		//				else if((nation[i]%100)/10==(nation[K]%100)/10) {
		//					if(((nation[i]%100)%10)/10>((nation[K]%100)%10)/10) count++;
		//					else break;
		//				}
		//			}
		//		}
		for(int i=N; i>0; i--) {
			if(nation[i]>search) {
				count++;
			}
			else {
				break;
			}
		}
		System.out.println(count+1);

	}
}
