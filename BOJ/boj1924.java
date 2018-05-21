import java.util.Scanner;

public class boj1924 {

	public static int x;
	public static int y;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int sum=0;
		for(int i=1; i<x; i++) {
			if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) {
				sum+=31;
			}
			if(i==4 || i==6 || i==9 || i==11) {
				sum+=30;
			}
			if(i==2) {
				sum+=28;
			}
		}
		sum+=y;
		int index = sum%7;
		System.out.println(day[index]);

	}

}
