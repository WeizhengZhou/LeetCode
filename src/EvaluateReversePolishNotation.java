
import java.util.Stack;
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if(tokens == null) return Integer.MIN_VALUE;
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i=0;i<tokens.length;i++){
			String t = tokens[i];
			
			if(t.equals("+"))
				s.push(s.pop() + s.pop());
			else if(t.equals("*"))
				s.push(s.pop() * s.pop());
			else if(t.equals("-")){
				int a = s.pop();
				int b = s.pop();
				s.push(b - a);			
			}
			else if(t.equals("/")){
				int a = s.pop();
				int b = s.pop();
				s.push(b / a);	
			}
			else
				s.push(Integer.parseInt(t));		
			
			System.out.println(s);
		}
		return s.pop();

	}
	public static void main(String[] args){
		String[] t = new String[]{"2", "1", "+", "3", "*"};
		t = new String[]{"4", "13", "5", "/", "+"};
		t = new String[]{"3","-4","+"};
		t = new String[]{"18"};
//		t = new String[]{"13","5","/"};
		t = new String[]{"4","3","-"};
		
		System.out.println(new EvaluateReversePolishNotation().evalRPN(t));
	}

}
