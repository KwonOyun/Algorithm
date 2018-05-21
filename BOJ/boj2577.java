import java.util.Scanner;

public class boj2577 {

	public static int A, B, C;
	public static int result;
	public static int[] number;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		result = A*B*C;
		number = new int[10];
		int length = (int)(Math.log10(result)+1);
		int temp = length;
		for(int i=1; i<temp; i++) {
			number[result/divider(length)]++;
			result = result % divider(length);
			length--;
		}
		number[result]++;
		
		for(int i=0; i<10; i++) {
			System.out.println(number[i]);
		}
	}
	
	public static int divider(int x) {
		int sum = 1;
		for(int i=1; i<x; i++) {
			sum = sum*10;
		}
		return sum;
	}

}
