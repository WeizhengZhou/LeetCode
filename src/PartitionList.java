
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode h1 = new ListNode(0);
		ListNode t1 = h1;
		ListNode h2 = new ListNode(0);
		ListNode t2 = h2;
		
		while(head != null){
			ListNode cur = head;
			head = head.next;
			cur.next = null;
			
			if(cur.val < x){
				t1.next = cur;
				t1 = cur;
			}
			else{
				t2.next = cur;
				t2 = cur;
			}
		}
			
		t1.next = h2.next;								
		return h1.next;
	}
	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,4,3,2,5,2});
//		ListNode head = new ListNode().createList(new int[]{2,1});
		
		PartitionList s = new PartitionList();
		ListNode res = s.partition(head, 3);
		res.printList(res);
		
	}

}
