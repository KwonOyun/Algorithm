import java.util.Scanner;

public class boj1963 {

	public static int T;
	public static int start;
	public static int end;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			Transaction();
		}
	}
	
	public static void Transaction() {
		
	}
	
	public static boolean checksosu(int number) {
		int count=0;
		for(int i=1; i<=number; i++) {
			if(number%i == 0) count++;
		}
		if(count==2) return true;
		else return false;
	}

}
