
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode dh = new ListNode(0);
		ListNode tail = dh;
		while(a != null && b != null){
			if(a.val < b.val){
				tail.next = a;
				a = a.next;
			}
		    else{
		    	tail.next = b;
		    	b = b.next;
		    }
			tail = tail.next;
		}
		tail.next = (a != null) ? a:b;
		return dh.next;
	}
}
