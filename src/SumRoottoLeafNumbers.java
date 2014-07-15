
public class SumRoottoLeafNumbers {
	private int sum = 0;
	public int sumNumbers(TreeNode root) {
		helper(root,0);
		return this.sum;
	}
	private void helper(TreeNode root, int pathNum){
		if(root == null) return;
		pathNum = pathNum*10 + root.val;//add root.val as the lsd
		if(root.left == null && root.right == null)//leaf node
			sum += pathNum;
		if(root.left != null)//root has left subtree
			helper(root.left, pathNum);
		if(root.right != null)//root has right subtree
			helper(root.right, pathNum);		
	}
	public static void main(String[] args){
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		SumRoottoLeafNumbers s = new SumRoottoLeafNumbers();
		System.out.println(s.sumNumbers(root));
		
	}

}
