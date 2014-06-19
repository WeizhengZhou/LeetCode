import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		
		if(root == null) 
			return res;
		List<TreeNode> curLevel = new LinkedList<TreeNode>();
		List<TreeNode> nextLevel = new LinkedList<TreeNode>();
		curLevel.add(root);
		
		List<Integer> list = new LinkedList<>();	

		while(!curLevel.isEmpty()){
			TreeNode cur = curLevel.remove(0);
			list.add(cur.val);
			
			if(cur.left != null)
				nextLevel.add(cur.left);
			if(cur.right != null)
				nextLevel.add(cur.right);
			if(curLevel.isEmpty()){
				res.add(new LinkedList<Integer>(list));
				list = new LinkedList<Integer>();
				curLevel = new LinkedList<TreeNode>(nextLevel);
				nextLevel = new LinkedList<TreeNode>();				
			}			
		}
		reverseList(res);
		return res;
	}
	private void reverseList(List<List<Integer>> lists){
		Collections.reverse(lists);	
	}
	public  static void main(String[] args){
		   
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		BinaryTreeLevelOrderTraversalII s = new BinaryTreeLevelOrderTraversalII();
		List<List<Integer>> lists = s.levelOrderBottom(root);
		s.print(lists);
	
	}
	private void print(List<List<Integer>> lists){
		for(List<Integer> list : lists){
			for(Integer e:list){
				System.out.print(e+",");
			}
			System.out.println();
		}
	}
}
