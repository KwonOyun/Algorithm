
public class Search {
	
	private int sequentialSearchCount; /* 순차 탐색 비교 연산 횟수 저장 */
	private int binarySearchCount; /* 이진 탐색 비교 연산 횟수 저장 */
	
	/* 생성자 */
	public Search(){
		this.sequentialSearchCount = 0;
		this.binarySearchCount = 0;
	}
	
	/* 선형 탐색에 대한 비교 횟수를 반환하는 메소드 */
	public int getSequentialSearchCount(){
		return this.sequentialSearchCount;
	}
	
	/* 이진 탐색에 대한 비교 횟수를 반환하는 메소드 */
	public int getBinarySearchCount(){
		return this.binarySearchCount;
	}
	
	/* 순차 탐색 메소드 */
	public int sequentialSearch(int arr[], int x){
		/************ 내부 코드 구현할 것 ************/
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == x) {
				return i;
			}
			sequentialSearchCount++;
		}
		return -1; /* x를 탐색하지 못했을 경우 -1 반환 */	
	}
	
	/* 이진 탐색 메소드 */
	public int binarySearch(int arr[], int x){
		/************ 내부 코드 구현할 것 ************/
		
		int p=0;
		int q=arr.length-1;
		while(p <= q) {
			int i = (p + q)/2;
			
			if(arr[i] == x) return i;
			
			if(arr[i] < x) p = i+1;
			
			else q = i-1;

			binarySearchCount++;
		}
		return -1; /* x를 탐색하지 못했을 경우 -1 반환 */
	}
}
