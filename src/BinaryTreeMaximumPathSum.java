
public class BinaryTreeMaximumPathSum {
	private int maxPathSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		aux(root);
		return this.maxPathSum;
	}
	private PathSum aux(TreeNode root){
		if(root == null) return new PathSum(0,0);
		PathSum leftPathSum  = aux(root.left);
		PathSum rightPathSum = aux(root.right);
		
		
		int startRoot = Math.max(leftPathSum.startRoot, rightPathSum.startRoot) + root.val;
		//if both subpath are negative
		if(startRoot < root.val)
			startRoot = root.val;
		
		int crossRoot = leftPathSum.startRoot + rightPathSum.startRoot + root.val;
		
		if(startRoot > maxPathSum) 
			maxPathSum = startRoot;
		if(crossRoot > maxPathSum)
			maxPathSum = crossRoot;
				
		PathSum rootPathSum = new PathSum(startRoot,crossRoot); 
		System.out.println(rootPathSum.startRoot + ", " + rootPathSum.crossRoot);
		return rootPathSum;
				                         
	}
	public class PathSum{
		int startRoot = 0;
		int crossRoot = 0;
		public PathSum(int s, int c){
			startRoot = s;
			crossRoot = c;
		}
	}
	public static void main(String[] args){
//		TreeNode root = new TreeNode(2);
//		root.left = new TreeNode(-1);
//		root.right = new TreeNode(-2);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.left = new TreeNode(10);
		BinaryTreeMaximumPathSum s = new BinaryTreeMaximumPathSum();
		System.out.println(s.maxPathSum(root));
		
		
	}
	

}
