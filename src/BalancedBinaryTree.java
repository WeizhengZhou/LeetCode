
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		int h = height(root);
		if(h == -1) 
			return false;
		else 
			return true;
	}
	/**
	 * compute the height of a balanced tree
	 * @param root
	 * @return height if balanced
	 *        -1 if not balanced
	 */
	private int height(TreeNode root){
		if(root == null) return 0;
		
		int hl = height(root.left);
		int hr = height(root.right);
		
		if(hl== -1 || hr == -1 || Math.abs(hl-hr) >1) 
			return -1;
		return Math.max(hl, hr)+1;
		
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		BalancedBinaryTree  s = new BalancedBinaryTree ();
		System.out.println(s.isBalanced(root));
	}
}
