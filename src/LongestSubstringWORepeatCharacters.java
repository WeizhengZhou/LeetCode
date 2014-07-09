import java.util.BitSet;

public class LongestSubstringWORepeatCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s == null) return 0;
		int n = s.length();
		BitSet bt = new BitSet(256);//ASCII characters assumed		
		int l = 0;
		int r = 0;
		int maxL = 0;
		while(r < n){	
			if(bt.get(s.charAt(r)) == false){
				bt.set(s.charAt(r));
				maxL = Math.max(maxL, r-l+1);
				r++;
			}
			else{	
				//find A[k] = A[r]
				while(s.charAt(l) != s.charAt(r)){
					bt.clear(s.charAt(l));
					l++;
				}
				l++;
				r++;			
			}
		}
		maxL = Math.max(maxL, r-l);//not r-l+1, since r = n
		return maxL;
	}
	public static void main(String[] args){
		 LongestSubstringWORepeatCharacters solution = new LongestSubstringWORepeatCharacters();
		 String s = "qopubjguxhxdipfzwswybgfylqvjzhar";
		 System.out.println(solution.lengthOfLongestSubstring(s));
	}

}
