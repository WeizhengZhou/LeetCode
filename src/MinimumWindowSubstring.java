import java.util.*;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if(T == null || S == null || T.length() > S.length()) return "";
		Map<String, Integer> dict = new HashMap<>();//store characters to be found in S, and their number
		for(int i=0;i<T.length();i++){//initialize the dictionary 
			String key = T.substring(i,i+1);
			if(!dict.containsKey(key))
				dict.put(key, 1);
			else
				dict.put(key, dict.get(key)+1);
		}
		String res = "";//final result
		int minL = Integer.MAX_VALUE;//minimum length of window found so far
		int nCharRemaining = T.length();//number of characters remaining to be found in S
		int l = 0;//left boundary of window
		int r = 0;//right boundary of window
		while(r < S.length()){
			String key = S.substring(r,r+1);
			if(!dict.containsKey(key)){//character not needed
				r++;
				continue;
			}
			if(dict.get(key) > 0)//found one needed character
				nCharRemaining--;
			dict.put(key, dict.get(key)-1);//update character count in dictionary			
			if(nCharRemaining == 0){//found all needed characters
				while(l < r){//shrink window
					String z = S.substring(l,l+1);
					if(!dict.containsKey(z)){//not needed character
						l++;
					}
					else if(dict.get(z) < 0){//redundant character
						dict.put(z, dict.get(z)+1);
						l++;
					}
					else //cannot shrink any more
						break;			
				}
				if(minL > r-l+1){//shorter window is found
					minL = r-l+1;
					res = S.substring(l,r+1);
				}			
			}	
			r++;
		}
		return res;
    }
	
	public static void main(String[] args){
		String S = "ADOBECODEBANC";
		String T = "BAC";
//		String S = "aa";
//		String T = "aa";
		MinimumWindowSubstring solu = new MinimumWindowSubstring ();
		System.out.println(solu.minWindow(S, T));
	}

}
