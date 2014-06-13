
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s){
		if(s == null || s.length() < 2) return s;
		int n = s.length();
		boolean[][] B = new boolean[n][n];
		
		int maxL = 1;
		int start = 0;
		int end = 0;
		
		for(int l =1;l<=n;l++){
			for(int i=0;i<=n-l;i++){
				int j = i + l -1;
				if(isPal(B,i+1,j-1) == false || s.charAt(i) != s.charAt(j)){
					B[i][j] = false;
				}
				else{
					B[i][j] = true;
					if(l > maxL){
						maxL = l;
						start = i;
						end = j;
					}						
				}
			}
		}
		return s.substring(start,end+1);
		
	}
	private boolean isPal(boolean[][] B, int i, int j){
		if(i>j) return true;
		else
			return B[i][j];
		
	}
	public static void main(String[] args){
		String s = "abccda";
//		s = "abcaaa";
		LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
		System.out.println(solution.longestPalindrome(s));
		
	}
 

}
