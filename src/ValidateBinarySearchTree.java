
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	return isValid_aux(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isValid_aux(TreeNode root, int lower, int upper){
    	if(root == null) return true;
    	else if(root.val <= lower || root.val >= upper) 
    		return false;
    	else 
    		return isValid_aux(root.left,lower,root.val) &&
    				isValid_aux(root.right,root.val,upper);
    	
    }
    public static void main(String[] args){
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(1);
    	root.right = new TreeNode(5);
    	root.right.left = new TreeNode(3);
    	ValidateBinarySearchTree s = new ValidateBinarySearchTree();
    	System.out.println(s.isValidBST(root));
    	
    }

}
