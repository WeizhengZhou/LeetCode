
import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
    	if(S == null || L == null) return new ArrayList<>();
    	List<Integer> res = new ArrayList<>();
    	Map<String,Integer> map = new HashMap<>();
    	
    	for(int i=0;i<L.length;i++)
    		map.put(L[i],i);
    	for(int i=0;i< S.length() - L[0].length() * L.length;i++){
    		
    		boolean[] mark = new boolean[L.length];
    		int j = i;
    		while(j < i+ L[0].length()*L.length){
//    			System.out.println(" i= " + i + ", j = "+ j);
    			String s = S.substring(j,j+L[0].length());
    			if(map.containsKey(s)){
    				int index = map.get(s);
    				if(mark[index] == false)
    					mark[index] = true;
    				else
    					break; 				 				
    			}
    			j = j + L[0].length();
    		}
    		boolean isValid = true;
    		for(int k=0;k< mark.length;k++)
    			if(mark[k] == false)
    				isValid = false;
    		if(isValid){
    			res.add(i);
    		}
    	}
    	return res;
    }
   
    

    public static void main(String[] args){
//    	String S = "barfoothefoobarman";	
//    	String[] L = new String[]{"foo","bar"};
    	String S = "aaa";
    	String[] L = new String[]{"a","a"};
    	
    	SubstringwithConcatenationofAllWords solution = new SubstringwithConcatenationofAllWords();
    
       System.out.println(solution.findSubstring(S, L));
    	
    }

}
