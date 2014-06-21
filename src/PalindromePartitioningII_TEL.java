import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII_TEL {
	
	private int minCut = Integer.MAX_VALUE;
	
    public int minCut(String s) {
    	if(s == null)
			return 0;
		
		aux(s, 0,  0);
		return minCut;       
    }
	
	public void aux(String s, int start, int nCut){
		System.out.println(start);
		if(start == s.length()){
			minCut = Math.min(nCut, minCut);
			return;
		}
		//partition the string into two parts, the first half is a palindrome
		for(int end = start +1; end <= s.length(); end++){
			if(isPalindrome(s, start, end)){
				if(end == s.length())
					aux(s, end, nCut);
				else
					aux(s, end,  nCut+1);
			}
		}	
	}
	public boolean isPalindrome(String s, int start, int end){
		int i = start;
		int j = end-1;
		while(i <= j){
			if(!s.substring(i,i+1).equals(s.substring(j,j+1)))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args){
		String t = "ababababababababababababcbabababababababababababa";
		PalindromePartitioningII_TEL solution = new PalindromePartitioningII_TEL ();
		System.out.println(solution.minCut(t));		
	}
	
}
