
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) return null;
		//does not work
//		ListNode slow = head;//should 
//		ListNode fast = head.next;
		//works
		ListNode slow = head.next;//should 
		ListNode fast = head.next.next;
		while(fast != null && fast.next != null && slow != fast){
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast == null || fast.next == null)
			return null;
		//else there is a cycle
		System.out.println("meet at " + slow.val );
		
		slow = head;
		while(slow != fast){
			System.out.println("slow = " + slow.val + ", fast = " + fast.val);
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head.next;
		
		LinkedListCycleII s = new LinkedListCycleII();
		ListNode enter = s.detectCycle(head);
		System.out.println(enter.val);
		
	}

}
