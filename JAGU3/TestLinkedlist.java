import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class TestLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PhoneBook phonebook = new PhoneBook();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\oyun\\Desktop\\자료구조(자바)\\3주차+실습\\PhoneBook.txt"));  //텍스트파일 읽음
			String s;  //임의의 string변수
			System.out.println("파일 읽기 성공");
			while((s=br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(s," ");
				while(st.hasMoreTokens()!=false) {
					String name = st.nextToken();
					String number = st.nextToken();
					phonebook.insert(name, number);
					System.out.println("삽입 : "+name+" - "+number);
				}
			}
			System.out.println("\n전화번호를 출력합니다.");
			phonebook.print();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
