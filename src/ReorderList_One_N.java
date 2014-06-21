
public class ReorderList_One_N {
    
	public void reorderList(ListNode head) {
		aux(head,head);
	}
	private ListNode aux(ListNode head, ListNode r){		
		if(r == null) 
			return head;
			
		ListNode l = aux(head, r.next);
	
		if(l == null)
			return null;
		System.out.println("A.....l = " + l.val + ", r = " + r.val + ", l.next = " + l.next.val);
			
		if(l.next == r)
			return null;
		
		ListNode nextL = l.next;
		l.next = r;
		r.next = nextL;
		
		System.out.println("B.....l = " + l.val + ", r = " + r.val + ", l.next = " + nextL.val);		
		return nextL;
	}
	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,2,3,4,5,6});
		ReorderList_One_N  s = new ReorderList_One_N();
		s.reorderList(head);			
	}
	private void print(ListNode head){
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}		
		System.out.println();
	}

}
