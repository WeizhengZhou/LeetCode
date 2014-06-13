
public class AddTwoNumbers {
//    public ListNode addTwoNumbers_Old(ListNode l1, ListNode l2) {
//    	if(l1 == null) return l2;
//    	if(l2 == null) return l1;
//    	
//    	ListNode dummyHead = new ListNode(0);
//    	ListNode tail = dummyHead;
//    	int carry = 0;
//    	
//    	while(l1 != null && l2 != null){
//    		int digit = l1.val + l2.val + carry;
//    		carry = (digit/10 == 1) ? 1:0;   		
//    		tail.next = new ListNode(digit%10);
//    		tail = tail.next;
//    		l1 = l1.next;
//    		l2 = l2.next;
//    	}
//    	ListNode remain = (l1 == null) ? l2:l1;
//    	
//    	while(remain != null){
//    		int digit = remain.val + carry;
//    		carry = (digit/10 == 1) ? 1:0;   		
//    		tail.next = new ListNode(digit%10);
//    		tail = tail.next;
//    		remain = remain.next;
//    	}
//    	if(carry == 1){
//    		tail.next = new ListNode(1);
//    		tail = tail.next;
//    	}
//    	return dummyHead.next;
//        
//    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	
    	ListNode dummyHead = new ListNode(0);
    	ListNode tail = dummyHead;
    	int carry = 0;
    	
    	while(l1 != null || l2 != null){    		
    		if(l1 != null){
    			carry += l1.val;
    			l1 = l1.next;
    		}
    		if(l2 != null){
    			carry += l2.val;
    			l2 = l2.next;
    		}   		 		
    		tail.next = new ListNode(carry%10);
    		tail = tail.next;
    		carry = carry/10;
    
    	}
    	if(carry == 1){
    		tail.next = new ListNode(1);
    		tail = tail.next;
    	}
    	return dummyHead.next;
        
    }
    public static void main(String[] args){
    	ListNode l1 = new ListNode().createList(new int[]{2,4,3});
    	ListNode l2 = new ListNode().createList(new int[]{5,6,4});
//    	ListNode l1 = new ListNode().createList(new int[]{1});
//    	ListNode l1 = null;
//    	ListNode l2 = new ListNode().createList(new int[]{9,9,9});
    	AddTwoNumbers solution = new AddTwoNumbers();
    	ListNode res = solution.addTwoNumbers(l1, l2);
    	l2.printList(res);
    }

}
