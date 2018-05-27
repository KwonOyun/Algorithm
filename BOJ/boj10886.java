import java.util.Scanner;

public class boj10886 {

	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int temp=0;
		int x = 0;
		int o = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			temp = sc.nextInt();
			if(temp == 0) x++;
			else o++;
		}
		if(o>x) System.out.println("Junhee is cute!");
		else if(x>o) System.out.println("Junhee is not cute!");
	}

}
