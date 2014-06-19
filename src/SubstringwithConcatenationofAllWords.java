
import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
    	if(S == null || L == null) return null;
    	for(int i=0;i<S.length();i=i+3){
    		
    	}
    }
    private boolean isConcatenation(String S, int p, String[] L){
    	HashMap<String, Integer> map = new HashMap<>();
    	for(int i=0;i<L.length;i++){
    		
    		String key = S.substring(p+3*i,p+3*i+3);
    		
    		boolean isInL = false;
    		for(int j=0;j<L.length;j++){
    			if(key.equals(L[i])){
    				isInL = true;
    	   			if(!map.containsKey(key))
        				map.put(key, 1);
        			else
        				return false;
    	   			
    				break;
    			}
    		}
    		if(!isInL)
    			return false;
    	}
    	return true;
    }
    

    public static void main(String[] args){
    	String S = "barfoothefoobarman";	
    	String[] L = new String[]{"foo","bar"};
    	
    	SubstringwithConcatenationofAllWords solution = new SubstringwithConcatenationofAllWords();
    	List<String> list = new ArrayList<String>();
    	list.add("");
//    	List<String> res = solution.permute(list, L, 0);
//    	System.out.println(res);
    	
    	
    }

}
