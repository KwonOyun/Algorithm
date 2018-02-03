import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {

	static int index=0;
	static String[] name = new String[20];
	static String[] number= new String[20];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\oyun\\Desktop\\자료구조(자바)\\1주차_01\\PhoneBook.txt"));  //텍스트파일 읽음
			String s;  //임의의 string변수
			while((s=br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(s," ");
				while(st.hasMoreTokens()!=false) {
					name[index] = st.nextToken();
					number[index] = st.nextToken();
				}
				index++;
			}
			System.out.println("원하는 것을 입력하시오. 1번->찾기, 2번->수정, 3번->출력, 0번->종료");
			Scanner aScanner = new Scanner(System.in);
			int choice = aScanner.nextInt();
			while(choice!=0) {
				if(choice==1) {
					search();
				}
				else if(choice==2) {
					update();
				}
				else if(choice==3) {
					print_to_file();
				}
				System.out.println("원하는 것을 입력하시오. 1번->찾기, 2번->수정, 3번->출력, 0번->종료");
				choice = aScanner.nextInt();
			}
			System.out.println("종료되었습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void search() throws IOException {
		System.out.println("찾으려는 이름을 입력하시오.");
		Scanner aScanner1 = new Scanner(System.in);
		String searchname = aScanner1.next();
		int i;
		for(i=0; i<index; i++) {
			if(searchname.equals(name[i])){
				System.out.println(name[i]+"의 전화번호는 "+number[i]+"입니다.");
				break;
			}
		}
		if(i==index) {
			System.out.println("찾으시는 이름이 없습니다.");
		}
	}

	public static void update() {
		System.out.println("수정하려는 이름을 입력하시오.");
		Scanner aScanner1 = new Scanner(System.in);
		String searchname = aScanner1.next();
		int i;
		for(i=0; i<index; i++) {  //이름이 존재할 경우
			if(searchname.equals(name[i])){
				System.out.println("수정하려는 번호를 입력하시오.");
				String before = number[i];
				number[i] = aScanner1.next();   //번호수정
				System.out.println(searchname+"의 번호가"+before+"->"+number[i]+"로 변경되었습니다.");
				break;
			}
		}
		if(i==index) {   //이름이 존재하지 않을 경우
			System.out.println("찾으시는 이름이 없습니다. 새로 생성하겠습니다. 번호를 입력하세요");
			name[index] = searchname; number[index] = aScanner1.next();
			System.out.println(name[index]+"의 번호는 "+number[index]+"로 설정되었습니다.");
			index++;
		}
	}

	public static void print_to_file() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\oyun\\Desktop\\자료구조(자바)\\1주차_01\\PhoneBookOutput.txt"));
			for(int i=0; i<index; i++) {
				bw.write(name[i]+" "+number[i]);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			System.out.println("출력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
