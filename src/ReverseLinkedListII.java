
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m >= n) return head;
		
		ListNode revHead = null;//head of reversed list
		ListNode revTail = null;//tail of reversed list
		ListNode beforeM = null;//before node m
		ListNode afterN = null;//after node n
		
		ListNode cur = head;
		ListNode next = null;
		int count = 0;
		while(cur != null){
			count++;			
			next = cur.next;//record next			
			
			if(count+1 == m){//record node before node m
				beforeM = cur;
			}
			else if(count == m){//start to reverse list
				cur.next = null;
				revTail = cur;
				revHead = cur;
			}
			else if(count > m && count <= n){//reverse list
				cur.next = revHead;
				revHead = cur;
			}
			else if(count == n+1){	//record node after n
				afterN = cur;
			}
			
			cur = next;
		}
		//cat reverse list with list after n
		revTail.next = afterN;
		//cat list before m with reversed list
		if(beforeM == null)
			return revHead;
		else{
			beforeM.next = revHead;
			return head;
		}		
	}	
	public static void main(String[] args){
		ListNode head = new ListNode().createList(new int[]{1,2,3,4,5});
		int m = 4;
		int n = 5;
		ReverseLinkedListII  s = new ReverseLinkedListII();
		head = s.reverseBetween(head, m, n);
		head.printList(head);
		
	}
}
