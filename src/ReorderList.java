
import java.util.*;
public class ReorderList {
//    public void reorderList(ListNode head) {
//    	Stack<ListNode> s = new Stack<>();
//    	ListNode middle = getMiddle(head);
//    	System.out.println(middle.val);
//    	while(middle != null){
//    		s.push(middle);
//    		middle = middle.next;
//    	}
//    	
//    	ListNode cur = head;
//    	ListNode resHead = new ListNode(-1);
//    	ListNode resTail = resHead;
//    	while(!s.isEmpty() && cur != null){
//    		new ListNode().printList(resHead);   		
//    		resTail.next = cur;
//    		cur = cur.next;
//    		resTail = resTail.next;
//    		resTail.next = s.pop();
//    		resTail = resTail.next;
//    		resTail.next = null;
//    		cur = cur.next; 		
//    	}	
//    	if(!s.isEmpty()){
//    		resTail.next = s.pop();
// 
//    	}
//    	head = resHead.next;
//    
//    }
    private ListNode getMiddle(ListNode head){
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    public static void main(String[] args){
    	ListNode list = new ListNode().createList(new int[]{0,1,2,3,4});
    	ReorderList solution = new ReorderList();
    	solution.reorderList(list);
    	list.printList(list);
    	
    }
}
