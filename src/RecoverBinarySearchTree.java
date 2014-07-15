import java.util.*;
public class RecoverBinarySearchTree {
	/**
	 * the swapped two elements must be a peak and a valley
	 *  of the in-order traversal of the tree,
	 *  use three marker l, m and r to mark three continuous tree nodes 
	 *  check if m is a peak or valley, if it is, mark it
	 *  finally swap the value of peak and valley
	 *  one trick is to push a max value into the stack,
	 *  which makes the last node easier to handle
	 *  another trick is to initialize the l, m and r to be tree node with min value
	 *  also to simplify the boundary condition
	 * @param root
	 */
	public void recoverTree(TreeNode root) {	
		if(root == null) return;
		if(root.left == null && root.right == null) return;
		TreeNode peak = null;
		TreeNode valley = null;
		
		TreeNode cur = root;	
		TreeNode l = new TreeNode(Integer.MIN_VALUE);	
		TreeNode m = new TreeNode(Integer.MIN_VALUE);	
		TreeNode r = cur;	
				
		Stack<TreeNode> stack = new Stack<>();	
		stack.push(new TreeNode(Integer.MAX_VALUE));//push a max value to make right boundary easier	
		while(cur != null || !stack.isEmpty()){
			if(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			else{
				cur = stack.pop();
				r = cur;			
				if(l.val <= r.val && m.val > l.val && m.val > r.val)//m is a peak					
					peak = m;				
				else if(l.val <= r.val && m.val < l.val && m.val < r.val)//m is a valley
					valley = m;				
				l = m;//move l, m and r to next in-order position 
				m = r;
				cur = cur.right;
			}
		}
		
		int v = peak.val;//swap peak and valley
		peak.val = valley.val;
		valley.val = v;
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		RecoverBinarySearchTree s = new  RecoverBinarySearchTree();
		s.recoverTree(root);
	}

}
