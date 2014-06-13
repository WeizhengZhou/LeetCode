import java.util.*;
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
    	int leftRem  = n;
    	int rightRem = n;
    	char[] c = new char[2*n];
    	List<String> list = new ArrayList<String>();
    	helper(list, c, n, n, 0);
    	System.out.println(list);
    	return list;

    }
    private void helper(List<String> list, char[] c, int leftRem, int rightRem, int curIndex){
    	if(leftRem < 0 || rightRem < leftRem) return;
    	if(leftRem == 0 && rightRem ==0){
    		list.add(new String(c));
    		return;
    	}
    	if(rightRem > leftRem){
    		c[curIndex] = ')';
    		helper(list,c,leftRem,rightRem-1,curIndex+1);
    	}
    	
    	c[curIndex] = '(';
		helper(list,c,leftRem-1,rightRem,curIndex+1);
    	
    }

    public static void main(String[] ags){
    	GenerateParentheses solution = new GenerateParentheses();
    	solution.generateParenthesis(3);
    	
    }
 
    	

}
