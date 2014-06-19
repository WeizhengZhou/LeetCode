
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(head.val -1);
		dummyHead.next = head;
		
		ListNode pre = dummyHead;
		ListNode cur = head;
		while(cur != null){
//			System.out.print("pre = " + pre.val + ", ");
//			System.out.print("remain list = ");
//			head.printList(cur);
			while(cur.next != null && cur.val == cur.next.val){
				cur = cur.next;
			}
			if(pre.next == cur){//cur.val != cur.next.val
				pre = cur;
				cur = cur.next;
			}
			else{
				pre.next = cur.next;//delete pre.next to cur
				cur = cur.next;				
			}	
			
		}	
		return dummyHead.next;

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
