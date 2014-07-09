
import java.util.*;
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
    	List<String> list = new LinkedList<String>();
    	list.add("");
    	return helper(list,digits,0);
    }
    private List<String> helper(List<String> list, String digits, int k){
    	if(k > digits.length() -1) return list;
    	String letter = digitToLetter(digits.substring(k,k+1));
    	List<String> res = new LinkedList<String>();
    	for(String s:list){
    		for(int i=0;i<letter.length();i++){
    			res.add(s + letter.substring(i,i+1));
    		}   		
    	}
//    	System.out.println("k = " + k);
//    	print(res);
    	return helper(res,digits,k+1);	
    }
    private String[] letter = new String[]{"",   "abc",  "def",
                                          "ghi", "jkl",  "mno",
                                           "pqrs","tuv",  "wxyz", " "};
    private String digitToLetter(String s){

    	if(s.compareTo("9") <=0 && s.compareTo("0") >=0)
    		return letter[Integer.parseInt(s)-1];
    	else
    		return "";
    	   	
    }
    public static void main(String[] args){
    	String s = ".23";
    	LetterCombinationsPhoneNumber solution = new LetterCombinationsPhoneNumber();
    	solution.letterCombinations(s);
    	
    }
    private void print(List<String> list){
    	for(String s : list){
    		System.out.println(s);
    	}
    }

}
