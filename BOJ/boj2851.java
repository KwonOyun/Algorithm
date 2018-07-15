import java.util.Scanner;

public class boj2851 {

	public static int temp, sum, up, down, count;
	public static int[] number;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		number = new int[10];
		for(int i=0; i<10; i++) {
			number[i] = sc.nextInt();
		}
		sum=0;
		for(int i=0; i<10; i++) {
			if(sum + number[i] >= 100) {
				if(100-sum >= (sum + number[i])-100) sum = sum+number[i];
				break;
			}
			sum = sum+number[i];
		}
		System.out.println(sum);
	}
}
