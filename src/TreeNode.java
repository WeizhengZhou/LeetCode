
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; left = null; right = null; }
	
	private String preorder(TreeNode root){
		if(root != null){
			String s = "";
			s += root.val + ", ";
			s += preorder(root.left);
			s += preorder(root.right);
			return s;
		}
		else 
			return "";
	}
	public String toString(){
		return preorder(this);
		
	}
}
