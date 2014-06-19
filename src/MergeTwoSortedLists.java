
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		
		while(l1 != null || l2 != null){
			if(l1 == null){
				tail.next = l2;
				l2 = l2.next;				
			}
			else if(l2 == null){
				tail.next = l1;
				l1 = l1.next;
			}
			else if(l2.val < l1.val){
				tail.next = l2;
				l2 = l2.next;
			}
			else{
				tail.next = l1;
				l1 = l1.next;
			}			
			tail = tail.next;
			tail.next = null;						
		}
		return dummyHead.next;

	}

}
