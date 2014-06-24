import java.util.*;
/**
 * need to check if it is possible to break the string, then build the result
 * otherwise cannot pass the test case like s = "aaaaa....aaaaab", whilc dict = {"a",",aa"};
 * @author Weizheng
 *
 */

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
		if(s == null || dict == null) return null;
		int n = s.length();	
		//is possible to break s.substring(0,i)
		boolean[] isPoss = isPossible(s, dict);
		if(isPoss[n] == false)
			return new ArrayList<String>();
		
		//result to break string[0...i]
		List<List<String>> res = new ArrayList<List<String>>();	
		for(int i=0;i<=n;i++){
			List<String> list = new ArrayList<>();
			res.add(list);
		}		
		for(int i=1;i<=n;i++){//break s.substring(0,i)
			for(int j=i-1;j>=0;j--){
				if(isPoss[j] == true && dict.contains(s.substring(j,i))){
				    List<String> list_j = res.get(j);
				    List<String> list_i = res.get(i);				    
				    if(list_j.size() == 0){//this is the first word
				    	String r = s.substring(j,i);
				    	if(i != n)
				    		r += " "; 
				    	list_i.add(r);
				    }
				    else{
				    	for(String t : list_j){//for each previous parsing way
				    		String r = t + s.substring(j,i);//append new word
				    		if(i != n)//if it is not the last word
				    			r += " ";//append space
				    		list_i.add(r);			    		
				    	}							
				    }					
					res.set(i, list_i);
				}
//				System.out.println("i = " + i + ", " + j + ": " + res.get(i));
			}				
		}	
		return res.get(n);
	}	

	public boolean[] isPossible(String s, Set<String> dict) {	
		int n = s.length();	
		//previous cut to break s.substring(0,i)
		boolean[] isPoss = new boolean[n+1];
		isPoss[0] = true;
				
		for(int i=1;i<=n;i++){//break s.substring(0,i)
			for(int j=i-1;j>=0;j--){
				if(dict.contains(s.substring(j,i)) && isPoss[j] == true)
					isPoss[i] = true;							
			}				
		}
		return isPoss;	
	}	


	

	public static void main(String[] args){
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();	
		
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
//		String s = "aaaaaaaaaaaab";
//		Set<String> dict = new HashSet<>();
//		String t = "a";
//		for(int i=0;i<3;i++){
//			dict.add(t);
//			t = t + "a";
//		}
		WordBreakII solution = new WordBreakII();
		System.out.println(solution.wordBreak(s, dict));
	}

}
