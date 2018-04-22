import java.util.Scanner;

public class boj10026 {

	static char[][] dot;
	static boolean[][] visited;
	static boolean[][] jukrokvisited;
	static int n;
	static int dfscount;
	static int jukrokcount;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();  //사이즈
		dot = new char[n+1][n+1];  //각 점을 나타내는 배열
		visited = new boolean[n+1][n+1];  //방문을 나타내는 배열
		jukrokvisited = new boolean[n+1][n+1];
		String temp;  //입력받기위한 temp

		for(int i=0; i<n; i++) {   //데이터 입력d
			temp = sc.next();
			for(int j=0; j<n; j++) {
				dot[i][j] = temp.charAt(j);
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j] == false) {
					visited[i][j] = true;
					char v = dot[i][j];
					if(v=='R') Rdfs(i, j);
					else if(v=='G') Gdfs(i, j);
					else if(v=='B') Bdfs(i, j);
					dfscount+=1;
				}
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(jukrokvisited[i][j] == false) {
					jukrokvisited[i][j] = true;
					char v = dot[i][j];
					if(v=='R'||v=='G') RGdfs(i, j);
					else if(v=='B') Bdfs2(i, j);
					jukrokcount+=1;
				}
			}
		}


		System.out.print(dfscount+" ");
		System.out.print(jukrokcount);

	}

	public static String RGdfs(int x, int y) {
		for(; x<n; x++) {
			for(; y<n; y++) {
				if(x-1>=0 && (dot[x-1][y]=='R' || dot[x-1][y]=='G') && jukrokvisited[x-1][y] == false) {
					jukrokvisited[x-1][y] = true;
					RGdfs(x-1, y);	
				}
				if(y+1<n && (dot[x][y+1]=='R' || dot[x][y+1]=='G') && jukrokvisited[x][y+1] == false) {
					jukrokvisited[x][y+1] = true;
					RGdfs(x, y+1);	
				}
				if(x+1<n && (dot[x+1][y]=='R' || dot[x+1][y]=='G') && jukrokvisited[x+1][y] == false) {
					jukrokvisited[x+1][y] = true;
					RGdfs(x+1, y);	
				}
				if(y-1>=0 && (dot[x][y-1]=='R'|| dot[x][y-1]=='G') && jukrokvisited[x][y-1] == false) {
					jukrokvisited[x][y-1] = true;
					RGdfs(x, y-1);	
				}
				return "";	
			}
		}
		return "";
	}
	

	public static String Rdfs(int x, int y) {
		for(; x<n; x++) {
			for(; y<n; y++) {
				if(x-1>=0 && dot[x-1][y]=='R' && visited[x-1][y] == false) {
					visited[x-1][y] = true;
					Rdfs(x-1, y);	
				}
				if(y+1<n && dot[x][y+1]=='R' && visited[x][y+1] == false) {
					visited[x][y+1] = true;
					Rdfs(x, y+1);	
				}
				if(x+1<n && dot[x+1][y]=='R' && visited[x+1][y] == false) {
					visited[x+1][y] = true;
					Rdfs(x+1, y);	
				}
				if(y-1>=0 && dot[x][y-1]=='R' && visited[x][y-1] == false) {
					visited[x][y-1] = true;
					Rdfs(x, y-1);	
				}
				return "";	
			}
		}
		return "";
	}
	
	public static String Gdfs(int x, int y) {
		for(; x<n; x++) {
			for(; y<n; y++) {
				if(x-1>=0 && dot[x-1][y]=='G' && visited[x-1][y] == false) {
					visited[x-1][y] = true;
					Gdfs(x-1, y);	
				}
				if(y+1<n && dot[x][y+1]=='G' && visited[x][y+1] == false) {
					visited[x][y+1] = true;
					Gdfs(x, y+1);	
				}
				if(x+1<n && dot[x+1][y]=='G' && visited[x+1][y] == false) {
					visited[x+1][y] = true;
					Gdfs(x+1, y);	
				}
				if(y-1>=0 && dot[x][y-1]=='G' && visited[x][y-1] == false) {
					visited[x][y-1] = true;
					Gdfs(x, y-1);	
				}
				return "";	
			}
		}
		return "";
	}
	
	public static String Bdfs(int x, int y) {
		for(; x<n; x++) {
			for(; y<n; y++) {
				if(x-1>=0 && dot[x-1][y]=='B' && visited[x-1][y] == false) {
					visited[x-1][y] = true;
					Bdfs(x-1, y);	
				}
				if(y+1<n && dot[x][y+1]=='B' && visited[x][y+1] == false) {
					visited[x][y+1] = true;
					Bdfs(x, y+1);	
				}
				if(x+1<n && dot[x+1][y]=='B' && visited[x+1][y] == false) {
					visited[x+1][y] = true;
					Bdfs(x+1, y);	
				}
				if(y-1>=0 && dot[x][y-1]=='B' && visited[x][y-1] == false) {
					visited[x][y-1] = true;
					Bdfs(x, y-1);	
				}
				return "";	
			}
		}
		return "";
	}
	
	public static String Bdfs2(int x, int y) {
		for(; x<n; x++) {
			for(; y<n; y++) {
				if(x-1>=0 && dot[x-1][y]=='B' && jukrokvisited[x-1][y] == false) {
					jukrokvisited[x-1][y] = true;
					Bdfs2(x-1, y);	
				}
				if(y+1<n && dot[x][y+1]=='B' && jukrokvisited[x][y+1] == false) {
					jukrokvisited[x][y+1] = true;
					Bdfs2(x, y+1);	
				}
				if(x+1<n && dot[x+1][y]=='B' && jukrokvisited[x+1][y] == false) {
					jukrokvisited[x+1][y] = true;
					Bdfs2(x+1, y);	
				}
				if(y-1>=0 && dot[x][y-1]=='B' && jukrokvisited[x][y-1] == false) {
					jukrokvisited[x][y-1] = true;
					Bdfs2(x, y-1);	
				}
				return "";	
			}
		}
		return "";
	}
}
