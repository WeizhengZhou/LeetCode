
import java.util.*;

public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String S, String[] L) {
    	if(S == null || L == null) 
    		return new ArrayList<>();
    	//expected number of keys to be found
    	Map<String, Integer> expected = new HashMap<>(); 	
    	for(int i=0;i<L.length;i++){
    		if(!expected.containsKey(L[i]))
    			expected.put(L[i],1);
    		else
    			expected.put(L[i], expected.get(L[i])+1);
    	}	
    	
    	int wordLength = L[0].length();//length of words in L
    	Map<String, Integer> real = new HashMap<>();//real number of keys found in S
    	List<Integer> res = new ArrayList<>();//result
    	for(int start=0;start<=S.length()-L.length*L[0].length();start++){//until remaining substring is longer than L's total characters   		
    		real.clear();//clear real counter
    		int nWords = 0;//index of words in L
    		while(nWords < L.length){
    			String cur = S.substring(start+nWords*wordLength, start+(nWords+1)*wordLength);//current word
    			if(!expected.containsKey(cur))//no cur in L
    				break;
    			else if(!real.containsKey(cur))//not found cur before
    				real.put(cur, 1);
    			else if(real.get(cur) < expected.get(cur))//not exceed expected 
    				real.put(cur, real.get(cur)+1);
    			else//more than expected 
    				break;
    			nWords++;
    		}    	
    		if(nWords == L.length)
    			res.add(start);
    	}   	   	
    	return res;
    }
    
    

    public static void main(String[] args){
    	String S = "barfoothefoobarman";	
    	String[] L = new String[]{"foo","bar"};
//    	String S = "aaa";
//    	String[] L = new String[]{"a","a"};
//    	String S = "acaacc";
//    	String[] L = new String[]{"ca","ac"};
    	
    	SubstringwithConcatenationofAllWords solution = new SubstringwithConcatenationofAllWords();
    
       System.out.println(solution.findSubstring(S, L));
    	
    }

}
