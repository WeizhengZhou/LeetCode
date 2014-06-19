
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
	public static void main(String[] args){
		int n = 2;
		UniqueBinarySearchTree s = new UniqueBinarySearchTree();
		System.out.println(s.numTrees(n));
		
	}
}
