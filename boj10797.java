import java.util.Scanner;

public class boj10797 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count =0;
		for(int i=0; i<5; i++) {
			int temp = sc.nextInt();
			if(a == temp) count++;
		}
		System.out.println(count);
	}

}
