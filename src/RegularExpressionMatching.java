
public class RegularExpressionMatching {
	public boolean isMatch(String A, String B) {
		if(A == null && B == null) return true;
		if(A == null && B != null) return false;
		if(A != null && B == null) return false;
		int m = A.length();
		int n = B.length();
		boolean[][] L = new boolean[m+1][n+1];
		L[m][n] = true;
		for(int i=m;i>=0;i--){
			if(A.charAt(i-1) != '*'){
				if(i == m)
					L[i][0] = false;
				else if(A.charAt(i) == '*')
					L[i][0] = L[i+1][0];
				else
					L[i][0] = false;				
			}
			else
				L[i][0] = L[i+1][0];
						
		}
		for(int j=n;j>=0;j--){
			if(B.charAt(j) != '*'){
				if(j == n-1)
					L[0][j] = false;
				else if(B.charAt(j+1) == '*')
					L[0][j] = L[0][j+1];
				else
					L[0][j] = false;				
			}
			else
				L[0][j] = L[0][j+1];
						
		}
		for(int i=m-1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(A.charAt(i-1) == '*')
					L[i][j] = L[i-1][j];
				if(B.charAt(j-1) == '*')
					L[i][j] = L[i][j-1];
				if(A.charAt(i-1) == B.charAt(j-1) || A.charAt(i-1) == '.' || B.charAt(j-1) == '.'){
					if(A.charAt(i) == '*')
						L[i][j] = L[i][j-1];
					if(B.charAt(j) == '*')
						L[i][j] = L[i-1][j];
				}
				else{
					L[i][j] = false;
				}
				
			}
		}
		 
	}
	
	public static void main(String[] args){
		String A = "c..a*b";
		String B = "c..b";
		RegularExpressionMatching solu = new RegularExpressionMatching();
		System.out.println(solu.isMatch(A, B));
	
		
	}

}
