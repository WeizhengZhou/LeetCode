/**
 * O(n^4) dynamic programming solution 
 * @see http://blog.sina.com.cn/s/blog_b9285de20101gy6n.html
 * @author Weizheng
 *
 */
public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if(s1 == null || s2 == null) return false;
		if(s1.length() != s2.length()) return false;
	
		int n = s1.length();
		//dp[i][j][l] represents whether s1.sub(i,i+l) is a scramble string of s2.sub(j,j+l)
		boolean[][][] dp = new boolean[n][n][n+1];
		for(int l=1;l<=n;l++){//length = 1 to n
			for(int i=0;i<=n-l;i++){//i from 0 to n-length
				for(int j=0;j<=n-l;j++){//j from 0 to n-length
					if(s1.substring(i,i+l).equals(s2.substring(j,j+l)))//identical
						dp[i][j][l] = true;
					else{
						for(int k=1;k<l;k++){
							//s1.sub(i,i+l) = s1.sub(i,i+k) + s1.sub(i+k,i+l)
							//s2.sub(j,j+l) = s2.sub(j,j+k) + s2.sub(j+k,j+l)
							dp[i][j][l] = dp[i][j][l] || (dp[i][j][k] && dp[i+k][j+k][l-k]);
							//s1.sub(i,i+l) = s1.sub(i,i+k)     + s1.sub(i+k,i+l)
							//s2.sub(j,j+l) = s2.sub(j,j+l-k) + s2.sub(j+l-k,j+l) 
							dp[i][j][l] = dp[i][j][l] || (dp[i][j+l-k][k] && dp[i+k][j][l-k]);
							//found a possible solution
							if(dp[i][j][l] == true) break;
						}
					}				
				}
			}
		}
//		print(dp);
		return dp[0][0][n];
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		String s1 = "great";
//		String s2 = "taerg";
		String s2 = "taegr";
//		String s1 = "tea";
//		String s2 = "tea";
		
		ScrambleString solu = new ScrambleString();
		System.out.println(solu.isScramble(s1, s2));
		
	}
	private void print(boolean[][][] dp){
		int n = dp.length;
		for(int l=1;l<=n;l++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(dp[i][j][l]+", ");			
				}
				System.out.println();
			}
			System.out.println("---------------------------");
		}
	}
}
