import java.util.Scanner;

public class boj5543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int min1=2001;
		for(int i=0; i<3; i++) {
			int temp = sc.nextInt();
			if(min1>temp) min1 = temp;
		}
		int min2 = 2001;
		for(int i=0; i<2; i++) {
			int temp = sc.nextInt();
			if(min2>temp) min2 = temp;
		}
		System.out.println(min1+min2-50);
	}

}
