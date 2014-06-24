import java.util.Arrays;


public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(S == null || T == null || T.length() > S.length())
			return 0;
		int m = S.length();
		int n = T.length();
		//number of distinct T[0...j] can be found in S[0...i] 
		int[][] L = new int[m+1][n+1];
		
		L[0][0] = 1;
		//T[0,0] can be found in S[0,i]
		for(int i=1;i<m+1;i++)
			L[i][0] = 1;
		//T[0,j] cannot be found S[0,0]
		for(int j=1;j<n+1;j++)
			L[0][j] = 0;
		
		for(int i=1;i<m+1;i++){
			for(int j=1;j<n+1;j++){
//				System.out.println("i = " + i + ", j = " + j);				
				if( S.charAt(i-1) == T.charAt(j-1)){
					//we can choose to match i-1 with j or match i with j
					L[i][j] = L[i-1][j] + L[i-1][j-1];
				}
				else{
					L[i][j] = L[i-1][j];
				}							
			}
		}
//		print(L);
		return L[m][n];
	}
	public static void main(String[] args){
		String S = "rabbitt";
		String T = 	"rabit";
//		String S = "ddd";
//		String T = "dd";
		DistinctSubsequences solution = new DistinctSubsequences();
		solution.numDistinct(S, T);
//		System.out.println(solution.numDistinct(S, T));	
	}
	private void print(int[][] L){
		for(int[] row:L){
			for(Integer e:row){
				System.out.print(e + ", ");
			}
			System.out.println();
		}
	}

}
