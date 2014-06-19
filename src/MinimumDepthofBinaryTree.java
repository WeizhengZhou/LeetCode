
public class MinimumDepthofBinaryTree {
	private int minDepth = Integer.MAX_VALUE;
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		depth(root,0);
		return minDepth;	        
	}
	private void depth(TreeNode root, int d){
		if(root == null) 
			return;
		else if(root.left == null && root.right == null){
			minDepth = Math.min(minDepth, d);		
		}
	    if(root.left != null)
			depth(root.left, d+1);
		if(root.right != null)
			depth(root.right,d+1);					
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
