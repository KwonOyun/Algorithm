import java.util.Scanner;

public class boj10798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String temp1 = sc.next(); String temp2 = sc.next(); String temp3 = sc.next(); String temp4 = sc.next(); String temp5 = sc.next();
		
		for(int i=0; i<15; i++) {
			if(i<temp1.length()) System.out.print(temp1.charAt(i));
			if(i<temp2.length()) System.out.print(temp2.charAt(i));
			if(i<temp3.length()) System.out.print(temp3.charAt(i));
			if(i<temp4.length()) System.out.print(temp4.charAt(i));
			if(i<temp5.length()) System.out.print(temp5.charAt(i));
		}
	}

}
