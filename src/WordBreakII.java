import java.util.*;

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
		if(s == null || dict == null) return null;
		int n = s.length();
		boolean[] L = new boolean[n+1];
		
		List<List<String>> lists = new ArrayList<List<String>>();
		
		for(int i=0;i<=n;i++){
			List<String> list = new ArrayList<>();
			list.add("");
			lists.add(list);
		}
		
		
		L[0] = true;//s.substring(0,0) as base case
		for(int i=1;i<=n;i++){//string end at i, exclusive
			for(int j=0;j<=i;j++){//break string into (0,j) and (j,i)
				if(dict.contains(s.substring(j,i)) && L[j] == true){
					//string(0,j) is breakable and string(j,i) is a word in dict
					L[i] = true;
					List<String> list_j = lists.get(j);
					List<String> list_i = lists.get(i);
					for(String t:list_j){
						if(i < n)
						    list_i.add(t + s.substring(j,i) + " ");
						else
							list_i.add(t + s.substring(j,i));						  
					}
 					lists.set(i, list_i);				
				}					
			}
			System.out.println(lists.get(i));
		}
		
		System.out.println(lists.get(n));
		return null;
	}


	public static void main(String[] args){
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();	
		
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		WordBreakII solution = new WordBreakII();
		solution.wordBreak(s, dict);
	}

}
