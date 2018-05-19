import java.util.Scanner;

public class boj2839 {

	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int threeindex = N/3;
		int min=2000;
		for(int i=0; i<=threeindex; i++) {
			if((N-(i*3))%5 == 0) {
				int a = i+(N-(i*3))/5;
				if(a<min) min = a;
			}
		}
		if(min==2000) min=-1;
		System.out.println(min);
	}

}
