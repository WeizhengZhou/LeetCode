import java.util.*;
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> lists = new ArrayList<List<Integer	>>();
		List<Integer> list = new ArrayList<>();
		aux(root, sum, list, lists);
		return lists;
	}
	private void aux(TreeNode root, int sum, List<Integer> list, List<List<Integer>> lists){
		if(root == null) return;
		if(root.left == null && root.right == null){
			   if(root.val == sum){
				   list.add(root.val);
				   lists.add(new ArrayList<>(list));
				   list.remove(list.size() - 1);
			   }
			  return;
		}
		list.add(root.val);
		aux(root.left,  sum - root.val, list, lists);
		aux(root.right, sum - root.val, list, lists);
		list.remove(list.size() - 1);
	}
	public static void main(String[] args){
//		TreeNode root = new TreeNode(5);
//		root.left = new TreeNode(4);
//		root.right = new TreeNode(8);
//		root.left.left = new TreeNode(11);
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(2);
//		
//		
//		root.right = new TreeNode(8);
//		root.right.left = new TreeNode(13);
//		root.right.right = new TreeNode(4);
//		root.right.right.left = new TreeNode(5);
//		root.right.right.right = new TreeNode(1);
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(-2);
		
		root.left.left = new TreeNode(1);
		
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(-1);
		
		
		root.right = new TreeNode(-3);
		root.right.left = new TreeNode(-2);
		
	
		
		PathSumII s = new PathSumII();
		List<List<Integer>> lists = s.pathSum(root, 2);
		s.print(lists);
			
	}
	private void print(List<List<Integer>> lists){
		for(List<Integer> list:lists){
			for(Integer e:list){
				System.out.print(e+", ");
			}
			System.out.println();
		}
	}
}
