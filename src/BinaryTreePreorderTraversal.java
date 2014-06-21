import java.util.*;
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			if(cur != null){
				list.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			}
			else{
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return list;
		
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		BinaryTreePreorderTraversal s  = new BinaryTreePreorderTraversal();
		List<Integer> list = s.preorderTraversal(root);
		System.out.println(list);
	}

}
