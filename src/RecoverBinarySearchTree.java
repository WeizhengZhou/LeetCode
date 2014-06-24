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
		
		TreeNode l = new TreeNode(Integer.MIN_VALUE);	
		TreeNode m = new TreeNode(Integer.MIN_VALUE);	
		TreeNode r = new TreeNode(Integer.MIN_VALUE);	
		
		TreeNode cur = root;
		
		Stack<TreeNode> stack = new Stack<>();
		//push a max value to make right boundary easier	
		stack.push(new TreeNode(Integer.MAX_VALUE));
		while(cur != null || !stack.isEmpty()){
			if(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			else{
				cur = stack.pop();
//				System.out.println(cur.val+ ", ");
				r = cur;
				//find a peak, and mark it
				if(l.val <= r.val && m.val > l.val && m.val > r.val){					
					peak = m;
//					System.out.println("find peak : " + peak.val);
				}
				//find a valley, and mark it 
				else if(l.val <= r.val && m.val < l.val && m.val < r.val){
					
					valley = m;
//					System.out.println("find valley : " + valley.val);
				}
				//move l, m and r to next in-order position 
				l = m;
				m = r;
				r = cur;
				cur = cur.right;
			}
		}
//		System.out.println("Before recover : " + root);
		int v = peak.val;
		peak.val = valley.val;
		valley.val = v;
//		System.out.println("After recover : " + root);
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
