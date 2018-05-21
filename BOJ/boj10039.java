import java.util.Scanner;

public class boj10039 {

	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int sum =0;
		int count=0;
		for(int i=0; i<5; i++) {
			if(N<40) N = 40;
			sum = sum +N;
			count++;
			if(count==5) break;
			
			N = sc.nextInt();
		}			


		double result =0;
		result = sum/count;
		System.out.println((int)result);
	}

}
