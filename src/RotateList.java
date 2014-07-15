
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null) return head;
		
		int length = length(head);
		k = k%length;
		if(k == 0) return head;
		
		ListNode l = head;//finally point to the previous node of new head
		ListNode r = head;//finally point to the tail of the list
		
		while(r.next != null){//at termination, l = new head's previous node
			if(k == 0)
				l = l.next;
			else
				k--;
			r = r.next;
		}
		
		r.next = head;//connect tail to head
		head = l.next;//assign new head
		l.next = null;//new tail.next = null
		
		return head;

	}
	public int length(ListNode head){//get the length of the list
		int l = 0;
		while(head != null){
			l++;
			head = head.next;
		}
		return l;
	}
	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,2,3,4,5});
		RotateList solution = new RotateList();
		ListNode res = solution.rotateRight(head, 5);
		head.printList(res);
	}

}
