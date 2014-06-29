import java.util.*;
/**
 * the bfs on the built table does not use dynamic programming, therefore it is not efficient
 * bfs on a graph with n^2 nodes, starting from n different nodes, therefore time = O(n^3)
 * However, a simply dynamic solution can achieve O(n^2) easily. 
 * I don't know how did I came up with this solution !
 * @author Weizheng
 *
 */
public class PalindromePartitioningII_TEL {
	private String s = null;
	private int n = 0;
	private boolean[][] isPal = null;	
	public int minCut(String s) {	
		if(s == null || s.length() < 2) return 0;
		this.s = s;
		this.n = s.length();
		this.isPal = new boolean[n][n];		
		buildGraph(s);
		return findMinCuts();
    }
	private void buildGraph(String s){	
		for(int i=0;i<n;i++)
			isPal[i][i] = true;	
		for(int i=1;i<n;i++)
			isPal[i][i-1] = true;			
		for(int l=2;l<=n;l++){
			for(int i=0;i<=n-l;i++){
				int j = i+l-1;
				if(s.substring(i,i+1).equals(s.substring(j,j+1)))
					isPal[i][j] = isPal[i+1][j-1];	
				else
					isPal[i][j] = false;
			}		
		}
//		print(isPal);	
	}
	private int findMinCuts(){
		int minCuts = n-1;	
		for(int i=n-1;i>=0;i--){
			if(isPal[0][i] == true){
				int nCuts = bfs(i+1);
				minCuts = Math.min(nCuts, minCuts);	
			
			}
		}
		return minCuts;
	}
	private int bfs(int r){
		if(r == n) return 0;
		Queue<Integer> curRow = new LinkedList<>();
		Queue<Integer> nextRow = new LinkedList<>();
		curRow.add(r);			
		int nCuts = 1;	
		while(!curRow.isEmpty()){
			int i = curRow.remove();
//			System.out.println("row = " + i + ", nCuts = " + nCuts);
			for(int k=n-1;k>i;k--){//start from j+1 row						
				if(isPal[i][k] == true){
					if(k == n-1){
//						System.out.println("i = " + i + ", k = "+ k);
						return nCuts;
					}	
					nextRow.add(k);
				}
			}
			if(curRow.isEmpty()){
				curRow = new LinkedList<>(nextRow);
				nextRow.clear();
				nCuts++;
			}
		}		
		return nCuts;
	}
	public static void main(String[] args){
		String t = "aab";
//		String t = "abbd";
//		String t = "ababababababababababababcbabababababababababababa";
//		String t = "ababbbabbaba";
//		String t = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		String t = "cdd";
		PalindromePartitioningII_TEL solution = new PalindromePartitioningII_TEL();
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
