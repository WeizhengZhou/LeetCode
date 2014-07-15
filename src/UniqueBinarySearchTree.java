
public class UniqueBinarySearchTree {
	public int numTrees(int n) {
		return helper(1,n);
	}
	private int helper(int l, int r){
		if(l >= r) return 1;
		
		int numTrees = 0;
		for(int i=l;i<=r;i++){
			numTrees += helper(l,i-1) * helper(i+1,r);
		}
		return numTrees;	
	}
	public int numTrees_dp(int n) {
		if(n < 0) return 0;
		int[] nTrees = new int[n+1];//number of unique trees with i nodes
		nTrees[0] = 1;
		nTrees[1] = 1;
		for(int i=2;i<=n;i++){
			int res = 0;
			for(int k=0;k<=i-1;k++){
				res += nTrees[k]*nTrees[i-k-1];
			}
			nTrees[i] = res;
		}
		return nTrees[n];	
	}	
	public static void main(String[] args){
		int n = 8;
		UniqueBinarySearchTree s = new UniqueBinarySearchTree();
		System.out.println(s.numTrees(n));		
	}
}
