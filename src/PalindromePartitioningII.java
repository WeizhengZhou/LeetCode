
public class PalindromePartitioningII {
	
	public int minCut(String s) {	
//		System.out.println(s);
		if(s == null || s.length()==0) return 0;
		
		int n = s.length();
		
		boolean[][] isPal = new boolean[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				isPal[i][j] = true;
		
		int start = 0;
		int end = 0;
				
		for(int l = 2; l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j = l+i-1; 
				isPal[i][j] = isPal[i+1][j-1] && (s.substring(i,i+1).equals(s.substring(j,j+1)));
				if( isPal[i][j]==true && l > (end - start + 1)){
					start = i;
					end = j;				
				}
//				System.out.println("[" + i + ", " + j +"]" + ", l = " + l);
			}		
		}
	
		
		if(start == 0 && end == n-1)
			return 0;
		else if(start == 0){
			return  minCut(s.substring(end+1,n)) + 1;		
		}
		else if(end == n-1){
			return minCut(s.substring(0,start)) + 1;
		}
		else{
			return minCut(s.substring(0,start)) + minCut(s.substring(end+1,n)) + 2; 
		}       
    }
	
	public static void main(String[] args){
//		String t = "ababababababababababababcbabababababababababababa";
//		String t = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
		String t = "abcd";
//		System.out.println(t.length());
		PalindromePartitioningII solution = new PalindromePartitioningII();
		System.out.println(solution.minCut(t));		
	}

}
