
import java.util.Arrays;
import java.util.Random;

public class TestSearch {
	public static void main(String args[]){
		Random mRandom = new Random();
		Search mSearch = new Search();	
		int size = 10000;
		int randomInt[] = new int[size];
		
		/************ Test 코드 작성 ************/
		int i;
		for(i=0; i<size; i++) {  //난수입력
			randomInt[i] = mRandom.nextInt(size)+1;
			for(int j=0; j<i; j++) {
				if(randomInt[i] == randomInt[j]) {
					i--;
					break;
				}
			}
		}
		int searchnumber = mRandom.nextInt(size);
		System.out.println("데이터 크기 : "+size+" / 찾으려는 값 : "+searchnumber);
		System.out.println("******선형 탐색********");
		long start = System.nanoTime();
		System.out.print("찾은 위치(index) : "+mSearch.sequentialSearch(randomInt, searchnumber)+"/ 비교횟수 : "+mSearch.getSequentialSearchCount());
		long end = System.nanoTime();
		long result = end - start;
		System.out.println("/ 경과시간 :"+result/1000000.0);
		System.out.println("******이진 탐색********");
		start = System.nanoTime();
		System.out.print("찾은 위치(index) : "+mSearch.binarySearch(randomInt, searchnumber)+"/ 비교횟수는 "+mSearch.getBinarySearchCount());
		end = System.nanoTime();
		result = end - start;
		System.out.println("/ 경과시간 :"+result/1000000.0);
	}
}
