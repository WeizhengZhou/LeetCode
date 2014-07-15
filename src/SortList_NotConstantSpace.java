
public class SortList_NotConstantSpace {
	//recursively
	public ListNode SortList_NotConstSpace(ListNode head){
		if(head == null || head.next == null) return head;

		ListNode leftTail = getMiddle(head);

		ListNode leftHead = head;
		ListNode rightHead = leftTail.next;
		leftTail.next = null;
			
		leftHead = SortList_NotConstSpace(leftHead);
		rightHead = SortList_NotConstSpace(rightHead);
			
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
		int[] A = new int[8000];
		for(int i=0;i<A.length;i++){
			A[i] = (int) (4 * Math.random());
		}
//		int[] A = new int[]{1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1,1,2,1,3,3,2,2,1,3,1,3,1,3,2,2,3,2,3,2,2,1,2,3,1,3,1,2,3,3,2,3,3,3,1,1,2,3,1,2,3,2,1,1,2,3,1,1,3,1,2,2,3,2,1,3,1,2,1,3,2,1,1,2,2,2,1,3,1,3,2,3,3,1,1,3,1,2,1,2,3,1,2,1,1,3,1,3,3,1,1,1,2,2,1,3,1,2,2,3,2,1,3,2,1,3,2,2,3,3,2,2,1,3,2,2,2,2,2,3,2,2,3,1,3,2,1,3,2,1,2,3,3,3,1,2,2,3,1,1,2,2,3,2,1,1,1,1,1,3,2,2,2,1,3,2,1,2,3,2,1,1,2,1,3,3,1,3,1,2,2,1,2,3,2,3,3,1,2,3,2,2,3,3,2,1,3,2,2,2,3,3,3,1,1,2,1,1,2,3,3,3,1,3,2,2,1,2,2,1,2,3,1,3,2,2,3,3,3,1,2,3,2,1,3,1,1,2,2,1,1,1,2,2,3,1,3,1,2,3,3,3,2,2,3,1,1,1,3,2,1,1,3,1,2,3,3,3,2,1,2,3,2,3,2,1,3,2,2,2,2,1,1,3,1,1,1,3,2,2,2,1,2,3,2,3,2,2,1,2,3,2,1,1,3,1,3,3,1,1,1,1,1,2,3,3,3,1,3,2,2,3,1,1,3,1,1,1,3,1,1,2,2,2,1,1,1,1,2,1,3,3,3,1,2,2,2,2,3,3,1,2,2,3,1,3,1,2,1,2,2,3,3,1,3,3,2,1,3,1,1,3,1,2,3,3,3,3,1,1,3,3,3,3,2,2,2,1,1,3,2,2,2,3,1,3,3,3,1,1,3,1,3,2,3,1,2,3,2,2,3,3,3,1,2,1,2,1,2,3,1,2,2,2,1,1,1,2,2,1,2,1,1,1,3,2,1,2,3,2,2,2,1,2,3,2,2,1,3,3,3,1,2,3,3,1,1,3,3,1,1,2,1};
		ListNode head = new ListNode().createList(A);
		
		SortList_NotConstantSpace s = new SortList_NotConstantSpace();
		
		ListNode sorted = s.SortList_NotConstSpace(head);
		s.printList(sorted);


	}
	

}
