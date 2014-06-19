
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null) return head;
		
		int length = length(head);
		k = k%length;
		if(k == 0) return head;
		
		ListNode l = head;
		ListNode r = head;
		
		while(r.next != null){
			if(k == 0)
				l = l.next;
			else
				k--;
				r = r.next;
		}
		
		r.next = head;
		head = l.next;
		l.next = null;
		
		return head;

	}
	public int length(ListNode head){
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
