import java.util.*;
public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		if(s == null || dict == null) return false;
		int n = s.length();
		boolean[] L = new boolean[n+1];//whether string.substring(0,i) is breakable
		L[0] = true;//s.substring(0,0) as base case
		for(int i=1;i<=n;i++){//string end at i, exclusive
			for(int j=0;j<=i;j++){//break string into (0,j) and (j,i)
				if(dict.contains(s.substring(j,i)) && L[j] == true)//string(0,j) is breakable and string(j,i) is a word in dict
					L[i] = true;
			}
	    }
		return L[n];
	
	}
	

	public static void main(String[] args){
		String s = "aba";
		Set<String> dict = new HashSet<>();	
		dict.add("a");
		dict.add("aba");
		WordBreak solution = new WordBreak();
		System.out.println(solution.wordBreak(s, dict));
	}

}
