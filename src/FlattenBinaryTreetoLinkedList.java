
public class FlattenBinaryTreetoLinkedList {
//	public void flatten(TreeNode root) {
//		aux(root);
//	}
//	private HeadTail aux(TreeNode root){
//		if(root == null) 
//			return new HeadTail(null,null);
//		if(root.left == null && root.right == null) 
//			return new HeadTail(root,root);
//		
//		if(root.right == null){
//			root.right = root.left;
//			root.left = null;	
//		}
//		if(root.left == null){
//			HeadTail headTail = aux(root.right);
//			root.right = headTail.head;
//			return new HeadTail(root,headTail.tail);
//		}
//		
//		HeadTail leftHeadTail = aux(root.left);
//		HeadTail rightHeadTail = aux(root.right);
//		
//		root.left = null;
//		root.right = leftHeadTail.head;
//		leftHeadTail.tail.right = rightHeadTail.head;
//		
//		return new HeadTail(root, rightHeadTail.tail);
//			
//	}
//	public class HeadTail{
//		TreeNode head = null;
//		TreeNode tail = null;
//		public HeadTail(TreeNode head, TreeNode tail){
//			this.head = head;
//			this.tail = tail;
//		}
//	}
//	
	private TreeNode tail = new TreeNode(0);
	public void flatten(TreeNode root) {
		aux(root);
	}
	private TreeNode aux(TreeNode root){
			
		if(root == null) return null;
		//append root to current list	
		tail.left = null;
		tail.right = root;
		tail = tail.right;
//		System.out.println(tail.val);
		
		TreeNode left = root.left;//record left
		TreeNode right = root.right;//record right
		
		tail.right = aux(left);//flatten the left subtree
		tail.right = aux(right);//flatten the right subtree
		
		return root;//return flatten root
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
		TreeNode cur = root;
		while(cur != null){
			if(cur.left != null)
				System.out.println(cur.left.val);
			System.out.print(cur.val + "->");
			cur = cur.right;
		}
	}
}
