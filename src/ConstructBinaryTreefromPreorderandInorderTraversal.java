
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || inorder == null) return null;
    	if(preorder.length != inorder.length) return null;
    	int n = preorder.length;
    	return aux(preorder,0, n-1, inorder, 0, n-1);
    			
        
    }
    private TreeNode aux(int[] preorder, int pre_L, int pre_R, int[] inorder, int in_L, int in_R){
    	if(in_L > in_R) return null;
    	TreeNode root = new TreeNode(preorder[pre_L]);
    	if(in_L == in_R) return root;
    	
    	//index of root in the inorder
    	int in_root = -1;
    	for(int k=in_L;k<=in_R;k++){
    		if(inorder[k] == preorder[pre_L])
    			in_root = k;
    	}
    	
    	//last node of left subtree in preorder = first node's index + length of left subtree
    	// pre_L+1 : left subtree's first node, 
    	//in_root -1 - in_L: length of the left subtree
    	int pre_left_R = pre_L + 1 + (in_root -1 - in_L);
    	int pre_right_L = pre_left_R + 1;//first node of right subtree in preorder
     			
    	TreeNode left = aux(preorder, pre_L+1, pre_left_R, inorder, in_L, in_root -1);
    	TreeNode right = aux(preorder,pre_right_L, pre_R, inorder, in_root+1, in_R);
    	root.left = left;
    	root.right = right;
    	return root;
    }
	public static void main(String[] args){
		int[] preorder = new int[]{4,3,1,2,6,5,7};
		int[] inorder = new int[]{1,3,2,4,5,6,7};

		ConstructBinaryTreefromPreorderandInorderTraversal  s = new ConstructBinaryTreefromPreorderandInorderTraversal ();
		TreeNode root = s.buildTree(preorder, inorder);
		System.out.println(root);
		
	}
}
