
public class ConvertSortedListtoBinarySearchTree {
	/**
	 * Naive O(n*Log(n)) solution
	 * @param head
	 * @return
	 */
//	public TreeNode sortedListToBST(ListNode head) {
//		if(head == null) 
//			return null;
//		
//		if(head.next == null) 
//			return new TreeNode(head.val);
//		if(head.next.next == null) {
//			TreeNode root = new TreeNode(head.val);
//			root.right = new TreeNode(head.next.val);
//			return root;
//		}				 
//		ListNode middle = curAtMiddle(head);
//		
//		ListNode rightHead = middle.next;
//		middle.next = null;		
//		
//		TreeNode root = new TreeNode(middle.val);
//		TreeNode left = sortedListToBST(head);
//		TreeNode right = sortedListToBST(rightHead);
//		root.left = left;
//		root.right = right;
//		
//		return root;
//	}
//	private ListNode curAtMiddle(ListNode head){
//		//list has at least three nodes
//		
//		ListNode preMiddle = null;
//		
//		ListNode middle = head;
//		ListNode tail = head.next;
//		
//		while(tail != null && tail.next != null){
//			preMiddle = middle;
//			middle = middle.next;
//			tail = tail.next.next;
//		}
//		preMiddle.next = null;
//
//		return middle;	
//	}
	private ListNode head = null;
	public TreeNode sortedListToBST(ListNode head){
	    this.head = head;
		return aux(0,length(head)-1);	
	}
	/**
	 * Same order as the in-order traversal
	 * Construct the BST using linked list from l to r
	 * @param l
	 * @param r
	 * @return
	 */
	private TreeNode aux(int l, int r){
		if(l > r) return null;//boundary condition
		int m = l + (r-l)/2;//middle of current list
		TreeNode leftChild = aux(l,m-1);//construct the left subtree first
		
		TreeNode root = new TreeNode(head.val);//visit root
		root.left = leftChild;
		head = head.next;
		
		root.right = aux(m+1,r);//construct right
		return root;
	}
	private int length(ListNode head){//return length of the linked list
		int l = 0;
		while(head != null){
			l++;
			head = head.next;
		}
		return l;
	}

	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,2,3,4,5,6,7});
		ConvertSortedListtoBinarySearchTree s = new ConvertSortedListtoBinarySearchTree();
		TreeNode root = s.sortedListToBST(head);
		System.out.println(root);
	}
}
