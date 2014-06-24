import java.util.Arrays;


public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(S == null || T == null || T.length() > S.length())
			return 0;
		int m = S.length();
		int n = T.length();
		//number of distinct T[0...j] can be found in S[0...i] 
		int[][] L = new int[m+1][n+1];
		
		//empty T can be found in each S[0,m]
		for(int i=0;i<m;i++)
			L[i][0] = 1;	
		
		//fill the array
		for(int i=1;i<m+1;i++){
			for(int j=1;j<=Math.min(n,i);j++){
				//find subsequence T[0...j-1] in S[0...i-1]
				System.out.println("i = " + i + ", j = " + j);
				//count number of continuous T[j-1]'s occurrence in S
				int count = 0;
				while(i-1-count >=0  && T.charAt(j-1) == S.charAt(i-1 -count))
					count++;
				//if T.charAt(j-1) != S.charAt(i-1), find previous occurrence of T[j-1]
				if(count == 0)
					L[i][j] = L[i-1][j];
				else{//multiply T[0...j-2]'s occurrence with T[j-1]'s occurrence 					
					L[i][j] = L[i-count][j-1] * count;
				}							
			}
		}
		print(L);
		return L[m][n];
	}
	public static void main(String[] args){
//		String S = "rabbbit";
//		String T = 	"rabit";
		String S = "ddd";
		String T = "dd";
		DistinctSubsequences solution = new DistinctSubsequences();
		System.out.println(solution.numDistinct(S, T));	
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
