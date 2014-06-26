import java.util.Arrays;

/**
 * Use dynamic programming,
 * Maintain an array L, where L[i] means the length of longest valid paren. start with s[i]
 * L[i] = 0            if s[i] = "("
 * let j = i+1+L[i+1], (i+1, i+L[i+1]) is a valid parentheses wrapped by (i, i+L[i])
 * if s[j] = ")", it is matched with s[i], then L[i] = 2 + L[i+1], meaning the maxLength + 2
 * 
 * if more string beyond j, we may also consider L[j+1], 
 * to see if the current longest parentheses can be extended. 
 * 
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
				L[i] = 0;//start with ")", no valid parentheses start with ")"
			}
			else{
				//check longest valid parentheses start with s[i+1]
				int j = i + 1 + L[i+1];
				
				if(j < n && s.substring(j,j+1).equals(")")){
				     //  i    valid    j
					//  (    (...)    )
					L[i] = 2 + L[i+1];
				    //  i    valid    j    j+1
				    //  (    (...)    )    (...)  
					if(j+1 < n)
						L[i] += L[j+1];
				}			
			}	
			maxLength = Math.max(maxLength, L[i]);
		}
		System.out.println(Arrays.toString(L));
		return maxLength;
	}
	 public static void main(String[] args){
	    	String s = null;
	    	s = "()(";
	    	s = "(()";
	    	s = ")()";
	    	s = ")()()(";
	    	s = "())(())()";
	    	s = "()(())";
//	    	s = ")()())()()(";
//	    	s = "(()(((()";
	    	s = "(((()(()";
	    	LongestValidParentheses solution = new LongestValidParentheses();
	    	int max = solution.longestValidParentheses(s);
	    	System.out.println(max);
	    	
	    }


}
