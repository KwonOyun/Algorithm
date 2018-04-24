import java.util.Scanner;

public class boj6603 {
	
	static boolean[] flag;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();   // 6 < k < 13	
		while(k!=0) {
			int[] number = new int[k];       //숫자 배열 새로 생성
			boolean[] flag = new boolean[k];  //플래그 배열 새로 생성
			for(int i=0; i<k; i++) {   //숫자 입력
				number[i] = sc.nextInt();
			}
			Combination(k, 6, number, flag);
			System.out.println();
			k = sc.nextInt();
		}
		
	}

	public static String Combination(int n, int r, int[] array, boolean[] flag) {
		if(n == r) {
			for(int i=0; i<n; i++) {
				flag[i] = true;
			}
			for(int i=0; i<n; i++) {
				if(flag[i] == true) System.out.print(array[i]+" ");
			}
			for(int i=0; i<n; i++) {
				flag[i] = false;
			}
			System.out.println();
			return "";
		}
		
		if(r==1) {
			for(int i=0; i<n; i++) {
				flag[i] = true;
				for(int j=0; j<n; j++) {
					if(flag[j] == true) System.out.print(array[j]+" ");
				}
				flag[i] = false;
				System.out.println();
			}
			return "";
		}
		flag[n-1] = true;
		Combination(n-1, r-1, array, flag);
		flag[n-1] = false;
		Combination(n-1, r, array, flag);
		return "";
	}

}
