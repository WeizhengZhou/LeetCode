
import java.util.*;
public class UniqueBinarySearchTreesII {
	
	public List<TreeNode> generateTrees(int n) {
		return helper(1,n);
	}
	private List<TreeNode> helper (int l, int r){
		List<TreeNode> rootList = new ArrayList<TreeNode>();
		if(l > r) {
			rootList.add(null);
			return rootList;
		}
			
		if(l == r) {
			rootList.add(new TreeNode(l));
			return rootList;
		}
		
		for(int i=l;i<=r;i++){		
			List<TreeNode> leftList = helper(l,i-1);
			List<TreeNode> rightList = helper(i+1,r);
//			System.out.println("l = " + l + ", r = " + r + ", i = " + i);
//			System.out.println("left = " + leftList);
//			System.out.println("right = " + rightList);
			
			for(TreeNode left:leftList){
				for(TreeNode right:rightList){
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					rootList.add(root);
				}
			}
		}
		return rootList;
	}
	public static void main(String[] args){
		int n = 3;
		UniqueBinarySearchTreesII s = new UniqueBinarySearchTreesII();
		List<TreeNode> list = s.generateTrees(n);
		
		for(TreeNode r:list){
		
			System.out.println(r);
		}
	}
}
