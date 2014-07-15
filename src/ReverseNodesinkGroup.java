
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	int length = length(head);
    	ListNode dummyHead = new ListNode(0);
    	ListNode tail = dummyHead;
    	
    	for(int i=0;i<=length-k;i=i+k){
    		ListNode remain = cutFirstKNodes(head, k);
    		tail.next =  reverse(head);
    		for(int j=0;j<k;j++){
    			tail = tail.next;
    		}
    		head = remain;
    	}
    	tail.next = head;
    	return dummyHead.next;
        
    }
    public ListNode reverse(ListNode cur){
    	if(cur == null) return null;
    	
    	ListNode head = cur;
    	cur = cur.next;
    	head.next = null;
    	
    	while(cur != null){
    		ListNode next = cur.next;
    		cur.next = head;
    		head = cur;
    		cur = next;
    	}
    	return head;
    }
    /**
     * cut the first k nodes, return the head of remaining list
     */
    public ListNode cutFirstKNodes(ListNode head, int k){
    	if(k == 0) return head;
    	ListNode pre = null;
    	ListNode cur = head;
    	
    	while(k>0){
    		k--;
    		pre = cur;
    		cur = cur.next;
    	}
    	pre.next = null;
    	return cur;
    	
    }
    public int length(ListNode head){
    	int length = 0;
    	while(head != null){
    		length++;
    		head = head.next;
    	}
    	return length;
    }
    public static void main(String[] args){
    	ListNode head = new ListNode().createList(new int[]{1,2});
    	ReverseNodesinkGroup solution = new ReverseNodesinkGroup();
    	ListNode res = solution.reverseKGroup(head, 2);
//    	ListNode res = solution.cutFirstKNodes(head, 2);
//    	head.printList(head);
    	head.printList(res);
    	
    }

}
