import java.util.Scanner;

public class boj14501 {

	public static int N;
	public static int[] term, money;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		term = new int[N+1];
		money = new int[N+1];

		for(int i=1; i<=N; i++) {
			term[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}

		solve();
	}

	public static void solve() {
		int MaxMoney=Integer.MIN_VALUE;

		for(int i=1; i<=N; i++) {
			int temp=0;
			int index = i;
			while(true) {
	
				if(index+term[index]<=N) {
					temp+=money[index];  //돈 추가
					index = index + term[index];  //걸린 일수 만큼 건너 뛰기
				}
				
				else {
					MaxMoney = Math.max(MaxMoney, temp);
					break;
				}
			}
		}
		System.out.println(MaxMoney);
	}

}
