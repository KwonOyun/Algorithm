import java.util.Scanner;

public class boj2490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int j=0; j<3; j++) {
			int temp;
			int zero=0;
			int one=0;
			for(int i=0; i<4; i++) {
				temp = sc.nextInt();
				if(temp==0) zero++;
				else one++;
			}
			if(zero==0 && one==4) System.out.println("E");
			else if(zero==1 && one ==3) System.out.println("A");
			else if(zero==2 && one ==2) System.out.println("B");
			else if(zero==3 && one ==1) System.out.println("C");
			else System.out.println("D");
 		}
	}

}
