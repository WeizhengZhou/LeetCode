import java.util.*;
public class LongestValidParentheses_Failed {
//    public int LongestValidParentheses_Failed(String s) {
//    	if(s == null || s.length() < 2) return 0;
//    	Stack<String> stack = new Stack<>();
//    	int left  = 0;
//    	int right = 0;
//    	int max = 0;
//    	int cur = 0;
//    	for(int i=0;i<s.length();i++){
//    		String t = s.substring(i,i+1);
//    		if(t.equals("(")){
//    			stack.push("(");
//    			left++;
//    		}
//    		else if(left > right){
//    			stack.push(")");
//    		
//    		}
//
//    		else if (stack.peek().equals(")")){
//    			
//    			if(max < right/2)
//    		}
//    			
//    		else{				
//    			stack.pop();
//    			cur = cur+2;
//    			if(cur > max)
//    				max = cur;
//    		}
//
//    		}
//    		else{
//    			stack.clear();
//    			cur = 0;
//    		}  
//    		System.out.println("i = " + i + " : " + stack );
//    	}
//    	return max;
//        
//    }
	
	   public int LongestValidParentheses_Failed(String s) {
	    	if(s == null || s.length() < 2) return 0;
	    
	    	int left = 0;//left count
	    	int right = 0;//right count
	    	
	    	int pre = 0;//previous pairs count
	    	int cur = 0;//current pairs count
	    	int max = 0;//max valid pairs count
	    	boolean isConnectToPre = false;//is cur connected to previous
	    	for(int i=0;i<s.length();i++){
	    		if(s.substring(i,i+1).equals("(")) left++; 
	    		else right++;
	    		
	    		if(left < right){
	    			left  = 0;
	    			right = 0;	
	    			isConnectToPre = false;//not connected
	    			pre = 0;//pre count = 0
	    		}
	    		else if(left == right){
	    			cur = 2 *left;//update cur 
	    			if(isConnectToPre)//if connected to pre valid pair
	    			   max = Math.max(max, cur + pre);
	    			else
	    			   max = Math.max(max, cur);
	    			
	    			//prepare for next
	    			isConnectToPre = true;
	    			pre = cur;
    				
	    			left = 0;
	    			right = 0; 
	    		}    			  			
	    		else{
	    			//not connected to pre
	    			cur = 2 * right;
	    			max = Math.max(max, cur);	 
	    		}
	    			 
	    		System.out.println(" i = " + i + ", left = " + left + ", right = " + right + ", max = " + max + ", pre = " + pre );
	    	}
	    	return max;  
	    }
    
    public static void main(String[] args){
    	String s = null;
    	s = "()(";
    	s = "(()";
    	s = ")()";
    	s = ")()()(";
    	s = "())(())()";
    	s = "()(())";
    	s = ")()())()()(";
    	s = "(()(((()";
    	

    	LongestValidParentheses_Failed solution = new LongestValidParentheses_Failed();
    	int max = solution.LongestValidParentheses_Failed(s);
    	System.out.println(max);
    	
    }

}
