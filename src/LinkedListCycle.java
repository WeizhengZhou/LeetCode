
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null && slow != fast){
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast == null || fast.next == null)
			return false;
		else 
			return true;
	}

}
