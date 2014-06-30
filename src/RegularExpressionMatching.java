
public class RegularExpressionMatching {
	private char[] S = null;
	private char[] P = null;
	private int m = 0;
	private int n = 0;
	private int[][] dp = null;
	public boolean isMatch(String strS, String strP) {	
//		System.out.println("S = " + strS + ", P = " + strP);
		if(strS == null) return strP == null;
		if(strP == null) return strS == null;
				
		this.S = strS.toCharArray();;
		this.P = strP.toCharArray();
	    this.m = this.S.length;
		this.n = this.P.length;
		this.dp = new int[m][n];
		
		
//		print(this.dp);
		
		return aux(m-1,n-1) == 1;
	}
	private int aux(int i, int j){
		System.out.println("i = " + i + ", j = " + j);
		//boundary condition
		if(i==j && i==-1)//comes from S[0] == P[0] and P[0] != '.'
			return 1;
		if(i>=0 && j<0)//P is exhausted and S has more, cannot matched
			return -1;
		if(i<0 && j>=0){//S is exhausted while P has more, only if P[0...j] are all x*x*.*x* 
			if(P[j] != '*'){
				if(j == n-1 || P[j+1] != '*') return -1;
			}		
			int k = 1;
			while(k <= j){
				if(P[k] != '*') return -1;
				else k=k+2;
			}
			return 1;		
		}
					
		if(this.dp[i][j] != 0) {//memo return 
			return this.dp[i][j];
		}			
		else if(P[j] == '*') {//current P is *, loop up previous solution
			this.dp[i][j] = aux(i,j-1);				
		}
		else if(j == this.n-1 || P[j+1] != '*'){//last P or next P is not a *
			//S[i] must match P[j] and their preceding characters should match
			this.dp[i][j] = ((S[i] == P[j] || P[j] == '.') && aux(i-1,j-1) == 1) ? 1:-1;		
		}
		else if(S[i] == P[j] || P[j] == '.'){//next P is a *
			//S[i] is matched with P[j], e.g. S = a, P = a*
			dp[i][j] = aux(i-1,j);
		}
		else{
			//e.g. S = a, P = ab*, b* cannot match any more characters, 
			dp[i][j] = aux(i,j-1);
		}
		return dp[i][j];

	}
	public void test(){
//		System.out.println(isMatch("ab", ".*.."));        // true  
//		System.out.println(isMatch("aa", "a*"));        // true  
//		System.out.println(isMatch("aa", "a"));     // false  
//		System.out.println(isMatch("aa", "aa"));    // true  
//		System.out.println(isMatch("aaa", "aa"));   // false  
//		System.out.println(isMatch("aa", "a*"));    //true  
//		System.out.println(isMatch("aa", ".*"));    // true  
//		System.out.println(isMatch("ab", ".*"));    // true  
//		System.out.println(isMatch("aab", "c*a*b"));        // true  

//		System.out.println(isMatch("", "bab"));         // false  
//		System.out.println(isMatch("ab", ".*c"));       // false  
//		System.out.println(isMatch("aaa", "a.a"));      // true  
//		System.out.println(isMatch("a", "."));          // true  
//		System.out.println(isMatch("a", "ab*"));        // true  
//		System.out.println(isMatch("bb", ".bab"));      // false  
//		System.out.println(isMatch("bb", "*"));         // false   
//		System.out.println(isMatch("aa", "a*"));         // true   
//		System.out.println(isMatch("aa", "aaa"));         // true   
		System.out.println(isMatch("aaa", "ab*a*c*a"));  // true
	}
	public static void main(String[] args){		
		RegularExpressionMatching solu = new RegularExpressionMatching();
		solu.test();	
	}
	public void print(int[][] L){
		for(int[] row:L){
			for(int e:row){
				System.out.print(e+",");
			}
			System.out.println();
		}
	}
	
}
