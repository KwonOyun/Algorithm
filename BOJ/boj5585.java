import java.util.Scanner;

public class boj5585 {

	public static int N;
	public static int exchange;
	public static int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		exchange = 1000-N;
		
		count+=exchange/500;
		exchange = exchange%500;
		count+=exchange/100;
		exchange = exchange%100;
		count+=exchange/50;
		exchange = exchange%50;
		count+=exchange/10;
		exchange = exchange%10;
		count+=exchange/5;
		exchange = exchange%5;
		count+=exchange/1;
		exchange = exchange%1;
		System.out.println(count);
	}

}
