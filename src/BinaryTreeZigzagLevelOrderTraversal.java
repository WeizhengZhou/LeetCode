import java.util.*;


public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		
		if(root == null) 
			return res;
		Stack<TreeNode> curLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		curLevel.push(root);		
		List<Integer> list = new LinkedList<>();
		
		boolean isLeftToRight = false;

		while(!curLevel.isEmpty()){
			TreeNode cur = curLevel.pop();
			list.add(cur.val);
			if(isLeftToRight){
				if(cur.right != null)
					nextLevel.push(cur.right);
				if(cur.left != null)
					nextLevel.push(cur.left);		
			}
			else{	
				if(cur.left != null)
					nextLevel.push(cur.left);
				if(cur.right != null)
					nextLevel.push(cur.right);			
			}
					
			if(curLevel.isEmpty()){
				res.add(new LinkedList<Integer>(list));
				list = new LinkedList<Integer>();
				
				curLevel = (Stack<TreeNode>) nextLevel.clone();
				nextLevel.clear();	
				isLeftToRight = !isLeftToRight;
			}			
		}
		return res;
	}
	public  static void main(String[] args){
		   
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		
		root.right.right = new TreeNode(7);
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> lists = s.zigzagLevelOrder(root);
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
