
public class RemoveNthNodeFromEndofList {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 assert n > 0;
		 ListNode cur = head;//node to be deleted
		 ListNode pre = null;//pre.next = cur
		 ListNode runner = head;//runnign to end
		 while(runner != null){//when terminate, cur and runner are separated by n nodes.
			 if(n > 0) {
				 n--;
			 }
			 else{
				 pre = cur;
				 cur = cur.next;
			 }
			 runner = runner.next;
		 }
		 if(cur == head)//to be deleted = head 
			 head = head.next;
		 else 
			 pre.next = cur.next;//delete cur
		 return head;
					        
	 }
	 public static void main(String[] args){
		 ListNode head = new ListNode().createList(new int[]{3,4});
		 RemoveNthNodeFromEndofList solution =  new RemoveNthNodeFromEndofList();
		 ListNode res = solution.removeNthFromEnd(head, 3);
		 head.printList(res);	 
	 }
}
