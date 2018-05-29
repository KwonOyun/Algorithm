import java.util.Scanner;

public class boj2783 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		double x, y, n;
		double min;
		
		x = sc.nextDouble();   //세븐25의 y그램당 x원 값 입력
		y = sc.nextDouble();
		n = sc.nextDouble();   //다른 편의점의 개수
		
		min = (1000/y)*x; // 최소값
		for(int i=0; i<n; i++) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			if((1000/b)*a<min) min = (1000/b)*a;
		}
		
		System.out.println(min);
	}

}
