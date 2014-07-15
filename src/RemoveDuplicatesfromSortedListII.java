
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode dh = new ListNode(head.val-1);
		ListNode tail = dh;
		tail.next = head;
		
		int value = head.val;
		ListNode cur = head.next;
		while(cur != null){
			while(cur != null && cur.val == value){
				cur = cur.next;
			}
			tail.next = cur;
			tail = tail.next;
			value = 
		}
		
		
		
		
		

	}
	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,1,2,2,3,3});
		RemoveDuplicatesfromSortedListII s = new RemoveDuplicatesfromSortedListII();
		ListNode res = s.deleteDuplicates(head);
		
		if(res == null){
			System.out.println("Null");		
		}
		else{
			res.printList(res);
		}	
	}
}
