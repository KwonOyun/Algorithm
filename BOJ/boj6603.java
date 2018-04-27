import java.util.Scanner;
import java.util.Stack;

public class boj6603 {

	static int[] printarray;
	static Stack<Integer> st;
	static int[] number;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		st = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();   // 6 < k < 13	
		
		while(k!=0) {
			number = new int[k];
			for(int i=0; i<k; i++) {   //숫자 입력
				number[i] = sc.nextInt();
			}
			combination(k, 6, 0);
			System.out.println();
			k = sc.nextInt();
		}

	}

	public static void combination(int n, int r, int index) {
		if(r == 0) {
			showStack();
		}
		
		else if (n == r) {
			for(int i=0; i<n; i++) st.add(number[index+i]);
			showStack();
			for(int i=0; i<n;i++) st.pop();
		}
		
		else {
			st.add(number[index]);
			combination(n-1, r-1, index+1);
			st.pop();
			combination(n-1, r, index+1);
		}
	}

	public static void showStack(){
		//스택에 있는 값들을 출력한다.
		for(int i=0; i<st.size(); i++){
			System.out.print(st.get(i)+" ");
		}
		System.out.println("");
	}

}
