import java.util.Scanner;

public class boj13458 {

	public static int N, B, C;
	public static long secondsupervisor;  //부감독관의 수
	public static int[] room;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();  //시험장의 개수
		room = new int[N+1];  //각 시험장의 응시자 수
		for(int i=1; i<=N; i++) {
			room[i] = sc.nextInt();  //각 시험방의 인원을 입력
		}
		B = sc.nextInt();  //총감독관이 관리할 수 있는 인원
		C = sc.nextInt();  //부감독관이 관리할 수 있는 인원
		
		solve();
		
	}
	public static void solve() {
		secondsupervisor = 0;
		for(int i=1; i<=N; i++) {
			int temp = room[i] - B;
			if(temp>0) {  //총감독관만으로 안될 경우
				if(temp%C==0) {
					secondsupervisor+=temp/C;
				}
				else{
					secondsupervisor+=(temp/C)+1;
				}
			}
		}
		System.out.println(N+secondsupervisor);
	}

}