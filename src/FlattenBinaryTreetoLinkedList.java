
public class FlattenBinaryTreetoLinkedList {

	public void flatten(TreeNode root) {
		aux(root);

	}
	private HeadTail aux(TreeNode root){
		if(root == null) 
			return new HeadTail(null,null);
		if(root.left == null && root.right == null) 
			return new HeadTail(root,root);
		
		if(root.right == null){
			root.right = root.left;
			root.left = null;	
		}
		if(root.left == null){
			HeadTail headTail = aux(root.right);
			root.right = headTail.head;
			return new HeadTail(root,headTail.tail);
		}
		
		HeadTail leftHeadTail = aux(root.left);
		HeadTail rightHeadTail = aux(root.right);
		
		root.left = null;
		root.right = leftHeadTail.head;
		leftHeadTail.tail.right = rightHeadTail.head;
		
		return new HeadTail(root, rightHeadTail.tail);
			
	}
	public class HeadTail{
		TreeNode head = null;
		TreeNode tail = null;
		public HeadTail(TreeNode head, TreeNode tail){
			this.head = head;
			this.tail = tail;
		}
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);	
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		FlattenBinaryTreetoLinkedList s = new FlattenBinaryTreetoLinkedList ();
		s.flatten(root);
//		System.out.println(root);
		TreeNode cur = root;
		while(cur != null){
			System.out.println(cur.val + "->");
			cur = cur.right;
		}
	}
}
