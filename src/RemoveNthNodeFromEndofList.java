
public class RemoveNthNodeFromEndofList {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 if(head == null) return null;
		 if(n<1) return head;
		
		 ListNode pre = null;
		 ListNode cur = head;
		 ListNode runner = head;
		 //when runner goes to null,
		 //cur = node to be delete
		 //pre = cur.pre
		 while(runner != null){
			 //n steps later cur start to move
			 //at that time cur and runner are sepearted by n steps
			 if(n>0) n--;
			 else{
				 pre = cur;
				 cur = cur.next;
			 }
			 runner = runner.next;
		 }
		 //to be delete = head
		 if(pre == null)
			 head = head.next;
		 else
			 pre.next = cur.next;
			 
		 return head;
			        
	 }
	 public static void main(String[] args){
		 ListNode head = new ListNode().createList(new int[]{3,4});
		 RemoveNthNodeFromEndofList solution =  new RemoveNthNodeFromEndofList();
		 ListNode res = solution.removeNthFromEnd(head, 2);
		 head.printList(res);
		 
	 }
}
