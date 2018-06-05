import java.util.Scanner;

public class boj5565 {

	public static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int temp = 0;
		for(int i=0; i<9; i++) {
			temp+=sc.nextInt();
		}
		System.out.println(N-temp);
	}

}
