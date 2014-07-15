
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode h1 = new ListNode(0);//dummy head of small list
		ListNode t1 = h1;//tail of small list
		ListNode h2 = new ListNode(0);//dummy head of large list
		ListNode t2 = h2;//tail of large list
		
		while(head != null){
			ListNode node = head;
			head = head.next;
			node.next = null;//isolate this node			
			if(node.val < x){
				t1.next = node;
				t1 = node;
			}
			else{
				t2.next = node;
				t2 = node;
			}
		}			
		t1.next = h2.next;								
		return h1.next;//dummy head
	}
	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,4,3,2,5,2});
//		ListNode head = new ListNode().createList(new int[]{2,1});
		
		PartitionList s = new PartitionList();
		ListNode res = s.partition(head, 3);
		res.printList(res);
		
	}

}
