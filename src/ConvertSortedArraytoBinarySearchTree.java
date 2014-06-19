
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if(num == null) return null;
		return aux(num,0,num.length-1);

	}
	private TreeNode aux(int[] num, int l, int r){
		if(l>r) return null;
		int m = (l+r)/2;
		TreeNode root = new TreeNode(num[m]);
		TreeNode left = aux(num,l,m-1);
		TreeNode right = aux(num,m+1,r);
		root.left = left;
		root.right = right;
		return root;
	}
}
