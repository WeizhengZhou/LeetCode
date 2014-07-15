
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode dummyHead = new ListNode(0);
    	
    	//preOne -> one -> two -> postTwo
    	ListNode preOne, one, two, postTwo;
    	
    	preOne = dummyHead;//previous node of node one
    	one = head;//node one 
    	  
    	while(one != null){
    		two = one.next;//node two
    		if(two == null) break;//two node is null, no need to swap
        	postTwo = two.next;//node after node two
        	
        	//preOne -> two -> one -> postTwo
        	preOne.next = two;//swap node one and node 2
        	two.next = one;
        	one.next = postTwo;
        	
        	preOne = one;//prepare next swap
        	one = postTwo;
    	}	
    	return dummyHead.next;
    }
    public static void main(String[] args){
    	ListNode head = new ListNode().createList(new int[]{1,2,3,4,5,6});
    	SwapNodesinPairs solution = new SwapNodesinPairs();
    	ListNode res = solution.swapPairs(head);
    	head.printList(res);
    		
    }
}
