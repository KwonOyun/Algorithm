import java.util.Scanner;

public class boj1789 {

	public static long S;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		S = sc.nextLong();
		long sum = 0;
		long N =0;
		long i =1;
		while(true) {
			if(S-sum==i) {
				System.out.println(N+1);
				break;
			}
			if(S-sum<i) {
				System.out.println(N);
				break;
			}
			sum += i++;
			N++;
		}
	}

}
