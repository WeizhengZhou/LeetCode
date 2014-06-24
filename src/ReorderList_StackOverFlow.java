
public class ReorderList_StackOverFlow {
    
	public void reorderList(ListNode head) {
		aux(head,head);
	}
	private ListNode aux(ListNode head, ListNode r){	
		//r reach the tail of list, return head as upper level's l
		if(r == null) 
			return head;
		//get left node 
		ListNode l = aux(head, r.next);
		//if done with reorder, do nothing
		if(l == null)
			return null;
		
//		System.out.println("A.....l = " + l.val + ", r = " + r.val + ", l.next = " + l.next.val);
		//if only one element left, set the tail.next = null
		if(l == r){
			l.next = null;
			return null;
		}
		//if only two elements left, set tail.next = null	
		if(l.next == r){
			r.next = null;
			return null;
		}
		//swap l and r's position, and return next l nodes
		ListNode nextL = l.next;
		l.next = r;
		r.next = nextL;

		return nextL;
	}
	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,2,3,4,5});
		ReorderList_StackOverFlow  s = new ReorderList_StackOverFlow();
		s.reorderList(head);	
		s.print(head);
	}
	private void print(ListNode head){
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}		
		System.out.println();
	}

}
