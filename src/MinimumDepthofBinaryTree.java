
public class MinimumDepthofBinaryTree {	
	private int minDepth = Integer.MAX_VALUE;
	public int minDepth(TreeNode root){
		if(root == null) return 0;
		helper(root,0);
		return minDepth;
	}
	private void helper(TreeNode root, int d){
		if(root == null) return;
		if(root.left == null && root.right == null)
			minDepth = Math.min(minDepth,d+1);
		if(root.left != null)
			helper(root.left, d+1);
		if(root.right != null)
			helper(root.right,d+1);
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
//		root.right.left = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		MinimumDepthofBinaryTree s = new MinimumDepthofBinaryTree();
		System.out.println(s.minDepth(root));
	}
	

}
