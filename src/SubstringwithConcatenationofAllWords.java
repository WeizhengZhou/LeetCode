
import java.util.*;

public class SubstringwithConcatenationofAllWords {
	private String S = null;
	private String[] L = null;
    public List<Integer> findSubstring(String S, String[] L) {
    	if(S == null || L == null) 
    		return new ArrayList<>();
    	this.S = S;
    	this.L = L;
    	
    	Map<String,Integer> map = new HashMap<String,Integer>();//count each string's occurrence 
    	for(int i=0;i<L.length;i++){
    		if(!map.containsKey(L[i]))
    			map.put(L[i],1);
    		else
    			map.put(L[i], map.get(L[i])+1);
    	}	
    	
    	List<Integer> res = new ArrayList<>();
    	for(int i=0;i<=S.length() - L.length * L[0].length();i++){
    		if(isSubstring(i, new HashMap<String, Integer>(map)))
    			//if S[i...] is a Concatenation of All Words of all words of L[] 
    				res.add(i);	
    	}
    	   	
    	return res;
    }
    private boolean isSubstring(int i, Map<String, Integer> map){
    	int step = L[0].length();    	
    	String cur = null;
    	while(i <= S.length()-step){//not i < S.length()
    		cur = S.substring(i,i+step);
    		if(!map.containsKey(cur)) break;
    		else{
    			int count = map.get(cur);
        		if(count == 1)
        			map.remove(cur);
        		else
        			map.put(cur, count-1);
    		}   		
    		i += step;		
    	}
    	if(map.size() == 0) return true;//all words found and cleared 
    	else return false;//clear process being interrupted    	  	
    }
   
    

    public static void main(String[] args){
//    	String S = "barfoothefoobarman";	
//    	String[] L = new String[]{"foo","bar"};
//    	String S = "aaa";
//    	String[] L = new String[]{"a","a"};
    	String S = "acaacc";
    	String[] L = new String[]{"ca","ac"};
    	
    	SubstringwithConcatenationofAllWords solution = new SubstringwithConcatenationofAllWords();
    
       System.out.println(solution.findSubstring(S, L));
    	
    }

}
