
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null){
			if(pre.val == cur.val){
				pre.next = cur.next;
			}
			else{
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	public static void main(String[] args){
//		ListNode list = new ListNode().createList(new int[]{1,1,2,2,3,4});
		ListNode list = new ListNode().createList(new int[]{1,1});
		RemoveDuplicatesfromSortedList s = new RemoveDuplicatesfromSortedList();
		ListNode res = s.deleteDuplicates(list);
		res.printList(res);
	}
	

}
