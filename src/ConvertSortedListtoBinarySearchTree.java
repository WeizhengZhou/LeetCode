
public class ConvertSortedListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) 
			return null;
		
//		new ListNode().printList(head);	
		if(head.next == null) 
			return new TreeNode(head.val);
		if(head.next.next == null) {
			TreeNode root = new TreeNode(head.val);
			root.right = new TreeNode(head.next.val);
			return root;
		}				 
		ListNode middle = curAtMiddle(head);
		
		ListNode rightHead = middle.next;
		middle.next = null;		
		
		TreeNode root = new TreeNode(middle.val);
		TreeNode left = sortedListToBST(head);
		TreeNode right = sortedListToBST(rightHead);
		root.left = left;
		root.right = right;
		
		return root;
	}
	private ListNode curAtMiddle(ListNode head){
		//list has at least three nodes
		
		ListNode preMiddle = null;
		
		ListNode middle = head;
		ListNode tail = head.next;
		
		while(tail != null && tail.next != null){
			preMiddle = middle;
			middle = middle.next;
			tail = tail.next.next;
		}
		preMiddle.next = null;

		return middle;	
	}
	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,2,3,4,5});
		ConvertSortedListtoBinarySearchTree s = new ConvertSortedListtoBinarySearchTree();
		TreeNode root = s.sortedListToBST(head);
		System.out.println(root);
	}
}
