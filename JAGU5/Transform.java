public class Transform {
	
	String token;
	
	private ArrayStack stack;
	/* 구현에 필요한 변수는 임의로 선언할 것 */
	
	public String[] infixToPostfix(String[] args) {
		// 중위식을 후위식으로 변환한 결과를 String 배열로 반환하는 코드를 작성하고,
		// 마지막에 변환된 후위식을 출력함.
		stack = new ArrayStack(args.length);  //토큰 개수만큼의 스택 생성
		System.out.print("변환된 후위식 : ");
		for(int i=0; i<args.length; i++) {
			token = args[i];
			if(token.equals("(")) {  //토큰이 ( 이면 그대로 푸시
				stack.push(token);
			}
			
			else if(token.equals(")")) {  //토큰이 ) 일 경우
				while(!stack.peek().equals("(")) {  // ( 가 아닐 때 까지 계속해서 pop
					System.out.print(stack.pop()+" ");
				}
				stack.pop();
			}
			
			else if("ASMD".indexOf(token)<0){  //토큰이 피연산자일 경우 그대로 출력
				System.out.print(token+" ");
			}
			
			else if("ASMD".indexOf(token)>=0) {  //토큰이 연산자일 경우 연산자의 우선순위를 비교하여 pop
				if(stack.isEmpty()) {  //스택이 비어 있을 경우 그대로 푸시
					stack.push(token);
				}
				else {   //스택이 비어있지 않을 경우 우선순위 비교
					while(precedence((String)stack.peek()) >= precedence(token)) {
						System.out.print(stack.pop()+" ");
						if(stack.isEmpty()) break;
					}
					stack.push(token);
				}
			}
		}
		while(!stack.isEmpty()) {	//스택에 남은 것들 모두 pop
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
		
		return args;
	}

	public int precedence(String token) {
		// 연산자의 우선 순위를 반환하는 함수 작성
		// 연산자 우선 순위 *,/ > +,- > (,)
		if(token.equals("M") || token.equals("D")) {
			return 3;
		}
		else if(token.equals("A") || token.equals("S")) {
			return 2;
		}
		else {
			return 1;
		}
	}
}
