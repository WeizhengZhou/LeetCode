import java.util.*;
/**
  * @see http://leetcodenotes.wordpress.com/2013/10/19/leetcode-longest-valid-parentheses-%E8%BF%99%E7%A7%8D%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%EF%BC%8C%E6%9C%80%E9%95%BF%E7%9A%84valid%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%E6%9C%89%E5%A4%9A/
 * @author Weizheng
 *
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if(s == null || s.length() < 2) return 0;		
		int n = s.length();
		int[] L = new int[n];// length of longest valid parentheses start with s[i]
		L[n-1] = 0;
		int maxLength = 0;
		for(int i=n-2;i>=0;i--){
			if(s.substring(i,i+1).equals(")")){
				L[i] = 0;//no valid parentheses start with ")"
			}
			else{//check longest valid parentheses start at i+1, end at i+L[i+1] 
				int j = i + 1 + L[i+1];			
				if(j < n && s.substring(j,j+1).equals(")")){
					L[i] = 2 + L[i+1];//( (...) )		    
					if(j+1 < n)
						L[i] += L[j+1];//( (...) )(...)  
				}			
			}	
			maxLength = Math.max(maxLength, L[i]);
		}
		return maxLength;
	}
	public int longestValidParentheses_2(String s) {
		if(s == null) return 0;
		int maxL = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '(' || stack.isEmpty() || s.charAt(stack.peek()) == ')')
				stack.push(i);
			else{
				stack.pop();
				if(stack.isEmpty())
					maxL = Math.max(maxL, i+1);
				else
					maxL = Math.max(maxL, i-stack.peek());
			}
		}
		return maxL;
	}	
	public static void main(String[] args){
		String s = null;
		s = "()(";
		s = "(()";
		s = ")()";
		s = ")()()(";
//		s = "())(())()";
//		s = "()(())";
//		s = "(((()(()";
		LongestValidParentheses solution = new LongestValidParentheses();
		int max = solution.longestValidParentheses(s);
		System.out.println(max);	
	}
	 
}
