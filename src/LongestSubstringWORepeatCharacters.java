import java.util.BitSet;

public class LongestSubstringWORepeatCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s == null) return 0;
		int n = s.length();
		BitSet bt = new BitSet(256);
		
		int i = 0;
		int j = 0;
		int maxL = 0;
		while(j < n){
						
			if(bt.get(s.charAt(j)) == false){
				bt.set(s.charAt(j));
				j++;
			}
			else{
				maxL = Math.max(maxL, j-i);//not j-i+1
				while(s.charAt(i) != s.charAt(j)){
					bt.clear(s.charAt(i));
					i++;
				}
				i++;
				j++;			
			}
		}
		maxL = Math.max(maxL, j-i);
		return maxL;
	}
	public static void main(String[] args){
		 LongestSubstringWORepeatCharacters solution = new LongestSubstringWORepeatCharacters();
		 String s = "qopubjguxhxdipfzwswybgfylqvjzhar";
		 System.out.println(solution.lengthOfLongestSubstring(s));
	}

}
