import java.util.*;
public class PopulatingNextRightPointersinEachNode {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		Queue<TreeLinkNode> curLevel = new LinkedList<>();
		Queue<TreeLinkNode> nextLevel = new LinkedList<>();
		
		TreeLinkNode cur = null;
		TreeLinkNode pre = null;
		
		curLevel.add(root);
		while(!curLevel.isEmpty()){
		    cur = curLevel.remove();
		    
			if(cur.left != null)
				nextLevel.add(cur.left);
			if(cur.right != null)
				nextLevel.add(cur.right);
			if(pre == null)
				pre = cur;
			else{
				pre.next = cur;
				pre = cur;
			}
			if(curLevel.isEmpty()){
				cur.next = null;
				pre = null;
				curLevel = new LinkedList<>(nextLevel);
				nextLevel.clear();
			}		
		}
	}

}
