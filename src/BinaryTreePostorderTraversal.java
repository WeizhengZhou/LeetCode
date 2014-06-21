import java.util.*;
public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		TreeNode cur = root;
		TreeNode last = null;	
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		while(cur != null || !stack.isEmpty()){
			if(cur != null){
				stack.push(cur);				
				cur = cur.left;
			}
			else{
				TreeNode peek = stack.peek();
				if(peek.right != null && last != peek.right){
					cur = peek.right;
				}
				else{
					stack.pop();
					list.add(peek.val);
					last = peek;
				}				
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		 BinaryTreePostorderTraversal  s  = new  BinaryTreePostorderTraversal ();
		List<Integer> list = s.postorderTraversal(root);
		System.out.println(list);
	}

}
