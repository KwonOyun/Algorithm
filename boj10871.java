import java.util.Scanner;

public class boj10871 {
	
	public static int N;
	public static int X;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		X = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int temp = sc.nextInt();
			if(X>temp) System.out.print(temp+" ");
		}
	}

}
