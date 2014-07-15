import java.util.*;
public class SymmetricTree {
	
	public boolean isSymmetric_recursive(TreeNode root){
		if(root == null) 
			return true;
		else if(root.left == null && root.right == null) 
			return true;
		else if(root.left != null && root.right != null 
				&& root.left.val == root.right.val 
				&& isSymmetric_recursive(root.left) && isSymmetric_recursive(root.right))
			return true;
		else 
			return false;
		
	}
	public boolean isSymmetric_iterative(TreeNode root){
		if(root == null) return true;
		Queue<TreeNode> curLevel = new LinkedList<>();//current level's nodes
		Queue<TreeNode> curLevelRev = new LinkedList<>();//current level's nodes in reversed order
		Queue<TreeNode> nextLevel = new LinkedList<>();//next level's nodes
		Queue<TreeNode> nextLevelRev = new LinkedList<>();//next level's nodes in reversed order
	
		curLevel.add(root);//add root
		curLevelRev.add(root);//add root
		while(!curLevel.isEmpty() && !curLevelRev.isEmpty()){
			TreeNode n = curLevel.remove();//node in normal order
			TreeNode r = curLevelRev.remove();//node reversed order
			if(n.val != r.val) return false;//not symmetric value
			if(n.left != null){//n has left child
				if(r.right == null)//but r does not have left child
					return false;
				else{
					nextLevel.add(n.left);//add n.left to normal order
					nextLevelRev.add(r.right);
				}
			}
			if(n.right != null){
				if(r.left == null)
					return false;
				else{
					nextLevel.add(n.right);
					nextLevelRev.add(r.left);
				}
			}
			if(curLevel.isEmpty() && curLevelRev.isEmpty()){
				curLevel = new LinkedList<>(nextLevel);
				curLevelRev = new LinkedList<>(nextLevelRev);
				nextLevel.clear();
				nextLevelRev.clear();
			}			
		}	
		return true;
	}
}
