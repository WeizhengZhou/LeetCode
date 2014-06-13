
public class SortList {
	//recursively
	public ListNode sortList(ListNode head){
		if(head == null || head.next == null) return head;

		ListNode leftTail = getMiddle(head);

		ListNode leftHead = head;
		ListNode rightHead = leftTail.next;
		leftTail.next = null;
			
		leftHead = sortList(leftHead);
		rightHead = sortList(rightHead);
			
		ListNode sortedList = merge(leftHead,rightHead);
		
		return sortedList;
		
	}
	public ListNode getMiddle(ListNode head){
		if(head == null) return null;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;	
	}

	public ListNode merge(ListNode leftHead, ListNode rightHead){
		//use a dummy head for less code
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		while(leftHead != null && rightHead != null){
			if(leftHead.val < rightHead.val){
				tail.next = leftHead;
				leftHead = leftHead.next;
			}
			else{
				tail.next = rightHead;
				rightHead = rightHead.next;
			}
			tail = tail.next;
		}
		tail.next = (leftHead == null) ? rightHead:leftHead;
		
		return dummyHead.next;
	}
	
	public void printList(ListNode head){
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args){
		ListNode head = new ListNode(4);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		
		SortList sortList = new SortList();
		sortList.printList(head);
		ListNode sorted = sortList.sortList(head);
		sortList.printList(sorted);

		
//		ListNode rightHead = new ListNode(4);
//		rightHead.next = new ListNode(5);
//		sortList.printList(sortList.merge(head, rightHead));
	}
	

}
