
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null) return null;
		if(inorder.length != postorder.length) return null;
		return buildTree_aux(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);

	}
	private TreeNode buildTree_aux(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR){
		
//		System.out.println("inL = " + inL + ", inR = " + inR + ", postL = " + postL + ", postR = " + postR);
		assert (inR - inL) == (postR - postL);
		
		if(postL > postR) return null;
				
		int root_value = postorder[postR];//last element of postorder is the root;
		TreeNode root = new TreeNode(root_value);
		//root does not have children
		if(postR == postL) 
			return root;
		
		//root's index in inorder traversal		
		int in_root  = -1;
		for(int k= inL;k<=inR;k++){
			if(inorder[k] == root_value){
				in_root = k;
			}
		}
//		System.out.println("in_root = " + in_root);
		//last node of left subtree in postorder
		int post_left_R = postL + (in_root -1 - inL);//postL plus length of left subtree
		//first node of right subtree in postorder
		int post_right_L = post_left_R + 1;
		
		TreeNode left = buildTree_aux(inorder, inL, in_root-1, postorder, postL, post_left_R);
		TreeNode right = buildTree_aux(inorder, in_root+1,inR, postorder, post_right_L, postR-1);//last enode is root
		
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
