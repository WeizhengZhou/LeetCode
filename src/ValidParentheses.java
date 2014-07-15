
import java.util.Stack;
public class ValidParentheses {
    public boolean isValid(String t) {
    	if(t == null) return true;
    	if(t.length() %2 == 1) return false;//quick check
    	
    	Stack<String> stack = new Stack<String>();
    	for(int i=0;i<t.length();i++){
    		String a = t.substring(i,i+1);
    		if(a.equals("(") || a.equals("[") || a.equals("{"))//push left
    			stack.push(a);
    		else{
    			if(stack.isEmpty())//check empty before peek
    				return false;
    			String b = stack.pop();
    			if(b.equals("(") && a.equals(")"))
    				continue;
    			else if(b.equals("[") && a.equals("]"))
    				continue;
    			else if(b.equals("{") && a.equals("}"))
    				continue;
    			else 
    				return false;			
    		}
    	}
    	if(stack.isEmpty())
    		return true;
    	else 
    		return false; 		      
    }
    public static void main(String[] args){
//    	String s = "(()])}[}[}[]][}}[}{})][[(]({])])}}(])){)((){";
    	String s= "()";
    	ValidParentheses solution = new ValidParentheses();
    	System.out.println(solution.isValid(s));
    	
    }

}
