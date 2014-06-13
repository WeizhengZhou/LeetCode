
public class ListNode {
	int val;
	ListNode next;
	public ListNode(){
		
	}
	public ListNode(int x){
		this.val = x;
		this.next = null;
	}
	public ListNode createList(int[] A){
		ListNode head = new ListNode(0);
		ListNode tail = head;
		for(int a: A){
			tail.next = new ListNode(a);
			tail = tail.next;
		}
		return head.next;		
	}
	public void printList(ListNode head){
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();
	}
}
