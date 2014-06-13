import java.util.Arrays;


public class LongestPalindromicSubstring_Failed {
	private int[][] L = null;
	public String longestPalindrome(String s){
		if(s == null || s.length() <2) return s;
		int n = s.length();
		L = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				L[i][j] = 0;
		
		length(s,0,n-1);
		this.print();
		return getSubstring(s);
		
	}
	private int length(String s, int i, int j){
		if(i > j) 
			return 0;
		else if(L[i][j] > 0) 
			return L[i][j];
		else if(i == j){
			L[i][j] = 1;
			return L[i][j];		 
		}
		else if(s.charAt(i) == s.charAt(j)){
			L[i][j] = 2 + length(s,i+1,j-1);
			return L[i][j];
		}
		else{
			L[i][j] = Math.max(length(s,i+1,j),length(s,i,j-1));
			return L[i][j];
		}
	}
	
	private String getSubstring(String s){
		int i = 0;
		int j = s.length()-1;
		while(L[i][j] != (j-i+1)){
			if(s.charAt(i) == s.charAt(j)){
				i++;
				j--;
			}
			else if(L[i+1][j] > L[i][j-1]){
				i++;
			}
			else{
				j--;
			}
		}

		return s.substring(i,j+1);
		
	}
	public static void main(String[] args){
		String s = "abccba";
		s = "aaaaaaaaabcaaaaaaaa";
		LongestPalindromicSubstring_Failed solution = new LongestPalindromicSubstring_Failed();
		System.out.println(solution.longestPalindrome(s));
		
	}
	private void print(){
		for(int[] row:L){
			for(int a:row){
				System.out.print(a + ",");
			}
			System.out.println();
		}
			
	}

}
