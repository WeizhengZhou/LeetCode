
public class PalindromePartitioningII {
	public int minCut(String s){
		if(s == null || s.length() <= 1) return 0;
		int n = s.length();
		boolean[][] isPal = new boolean[n][n];//isPal[i][j] = true if s[i...j] is a palindrome
		int[] minCuts = new int[n];//minCuts[i] = number of min cuts for s[0,i]

		//build isPal table
		for(int i=1;i<n;i++)
			isPal[i][i-1] = true;//empty string is palindrome
		for(int i=0;i<n;i++)
			isPal[i][i] = true;//single character is palindrome
		for(int len=2;len<=n;len++){//length from 2 to n
			for(int i=0;i<=n-len;i++){//i from 0 to n-1
				int j = i+len-1;
				if(s.charAt(i) == s.charAt(j)){//
					isPal[i][j] = isPal[i+1][j-1];				
				}
			}
		}		
		for(int i=0;i<n;i++)
			minCuts[i] = i;//min cuts at most i-1
		for(int i=0;i<n;i++){//s[0...i]
			for(int j=0;j<=i;j++){//cut at 0<=j<=i
				if(isPal[j][i]){
					if(j ==0)
						minCuts[i] = 0;
					else
						minCuts[i] = Math.min(minCuts[i], minCuts[j-1]+1);
				}				
			}
		}
				
//		print(isPal);
		return minCuts[n-1];
	}
	
	public static void main(String[] args){
//		String t = "aab";
//		String t = "abbd";
//		String t = "ababababababababababababcbabababababababababababa";
//		String t = "ababbbabbaba";
//		String t = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		String t = "cdd";
		String t="eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
		PalindromePartitioningII solution = new PalindromePartitioningII();
		System.out.println(solution.minCut(t));		
	}
	private void print(boolean[][] isPal){
    	for(boolean[] row : isPal){
    		for(boolean c : row){
    			System.out.print(c + ", ");
    		}
    		System.out.println();
    	}
    }

}
