
public class InsertionSortList {
	 public ListNode insertionSortList(ListNode head) {
		 ListNode nh = new ListNode(Integer.MIN_VALUE);
		 ListNode nt = nh;
		 while(head != null){
			 ListNode min = head;
			 ListNode minPre = null;
			 ListNode cur = head.next;
			 ListNode curPre = head;
			 while(cur != null){
				 if(cur.val < min.val){
					 minPre = curPre;
					 min = cur;
				 }
				 curPre = cur;
				 cur = cur.next;
			 }
			 if(min == head) 
				 head = head.next;
			 else
				 minPre.next = min.next;
			 nt.next = min;
			 nt = min;
			 nt.next = null;
		 }
		 return nh.next;        
	 }
	 public static void main(String[] args){
		 ListNode head = new ListNode().createList(new int[]{3,1,2,4,7,6,4});
		 ListNode sorted = new InsertionSortList().insertionSortList(head);
		 new ListNode().printList(sorted);
		 
		 
	 }

}
