
import java.util.*;
public class ReorderList {
	public void reorderList(ListNode head) {
		//list' length <= 2
		if(head == null || head.next == null || head.next.next == null) return;
		ListNode tail = head;
		ListNode middle = head;
		
		//find middle node
		while(tail != null && tail.next != null){
			middle = middle.next;
			tail = tail.next.next;
		}
		//cut list into two halves, 
		ListNode left = head;
		ListNode right = middle.next;
		middle.next = null;
		
		right = reverse(right);
		merge(left, right);
	
	}
	
	public ListNode reverse(ListNode cur){
		if(cur == null || cur.next == null) return cur;
		ListNode head = cur;
		ListNode next = cur.next;
		cur.next = null;
		cur = next;
		while(cur != null){
			next = cur.next;
			cur.next = head;
			head = cur;
			cur = next;
		}
		
		return head;	
	}
	public ListNode merge(ListNode a, ListNode b){
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		ListNode aNext = null;
		ListNode bNext = null;
		
		while(a != null && b != null){
			aNext = a.next;
			bNext = b.next;
		    tail.next = a;
			a.next = b;
			b.next = null;
			tail = b;
			a = aNext;
			b = bNext;
			
			
		}
		if(a != null)
			tail.next = a;
		if(b != null)
			tail.next = b;
	
		return head.next;
		
	}
    public static void main(String[] args){
    	ListNode head = new ListNode().createList(new int[]{1,2,3,4,5});
    	
    	
    	ReorderList solution = new ReorderList();

    	solution.reorderList(head);
    	solution.print(head);
//    	solution.reorderList(list);
//    	list.printList(list);	
    }
    private void print(ListNode head){
    	while(head != null){
    		System.out.print(head.val + ", ");
    		head = head.next;
    	}
    	System.out.println();
    }
}
