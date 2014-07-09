
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null) return null;
		if(inorder.length != postorder.length) return null;
		return buildTree_aux(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);

	}
	private TreeNode buildTree_aux(int[] inorder, int inLB, int inRB, int[] postorder, int postLB, int postRB){
		
		assert (inLB - inLB) == (postLB - postLB);		
		if(postLB > postLB) return null;
				
		TreeNode root = new TreeNode(postorder[postLB]);
			
		int in_root_index  = -1;//root's index in in-order traversal		
		for(int k= inLB;k<=inLB;k++){
			if(inorder[k] == root.val){
				in_root_index = k;
			}
		}
		int post_left_RB = postLB + (in_root_index -1 - inLB);//left subtree's right boundary
		int post_right_LB = post_left_RB + 1;//		
		TreeNode left = buildTree_aux(inorder, inLB, in_root_index-1, postorder, postLB, post_left_RB);
		TreeNode right = buildTree_aux(inorder, in_root_index+1,inLB, postorder, post_right_LB, postLB-1);//last node is root
		
		root.left = left;
		root.right = right;
		
		return root;
	}
	public static void main(String[] args){
//		int[] inorder = new int[]{1,3,2,4,5,6,7};
//		int[] postorder = new int[]{1,2,3,5,7,6,4};
		int[] inorder = new int[]{1,2};
		int[] postorder = new int[]{2,1};
		ConstructBinaryTreefromInorderandPostorderTraversal s = new ConstructBinaryTreefromInorderandPostorderTraversal();
		TreeNode root = s.buildTree(inorder, postorder);
		System.out.println(root);
		
	}

}
