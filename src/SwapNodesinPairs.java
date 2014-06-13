
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode one = head;
    	ListNode two = head.next;
    	ListNode dummyHead = new ListNode(0);
    	ListNode tail = dummyHead;
    	while(one != null && two != null){
    		//record new one
    		ListNode temp = two.next;
    		//
    		tail.next = two;
    		two.next = one;
    		one.next = null;
    		tail = one;
    		
    		if(temp == null)
    			break;
    		else if(temp.next == null){
    			tail.next = temp;
    			break;
    		}
    		else{
        		one = temp;
        		two = temp.next;
    		}
		
    	}
    	
    	return dummyHead.next;
        
    }
    public static void main(String[] args){
    	ListNode head = new ListNode().createList(new int[]{1,2,3,4});
    	SwapNodesinPairs solution = new SwapNodesinPairs();
    	ListNode res = solution.swapPairs(head);
    	head.printList(res);
    		
    }
}
