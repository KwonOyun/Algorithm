public class RPN {
	//args에는 입력한 argument가 저장되어 있음.
	public static void main(String args[]) {
//		new Transform().infixToPostfix(args)를 사용하여 후위식으로 변환.
//		new RPN(new Transform().infixToPostfix(args))를 이용하여 후위식을 계산하고 결과 출력
		new RPN(new Transform().infixToPostfix(args));
	}

	public RPN(String[] args) {
		ArrayStack stack = new ArrayStack(args.length);

		for (int i = 0; i < args.length; i++) {
			String input = args[i];

			System.out.print(input + " ");

			if (isAnOperator(input)) {
				double y = Double.parseDouble((String) stack.pop());
				double x = Double.parseDouble((String) stack.pop());
				double z = evaluate(x, y, input);
				stack.push("" + z);
			} else
				stack.push(input);
		}
	}

	private boolean isAnOperator(String s) {
		return (s.length() == 1 && "ASMD".indexOf(s) >= 0);  //입력받은 String s가 ASMD중에 하나 일 경우 true반환 
	}

	private double evaluate(double x, double y, String op) {
		double z = 0;

		if (op.equals("A"))  //더하기
			z = x + y;
		else if (op.equals("S")) //빼기
			z = x - y;
		else if (op.equals("M"))  //곱하기
			z = x * y;
		else                //나누기
			z = x / y;

		System.out.println(x + " " + op + " " + y + " = " + z);
		return z;
	}
}
