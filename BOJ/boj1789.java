import java.util.Scanner;

public class boj1789 {

	public static int S;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		int sum = 0;
		int N =0;
		int i =1;
		while(true) {
			if(S-sum<=i) {
				System.out.println(N);
				break;
			}
			sum += i++;
			N++;
		}
	}

}
