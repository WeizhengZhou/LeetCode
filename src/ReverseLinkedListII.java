
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		ListNode revHead = null;//head of the reversed list
		ListNode revTail = null;//tail of the reversed list
		ListNode beforeM = null;//before node m
		ListNode afterN = null;//after node n
		
		ListNode cur = head;
		ListNode next = null;//cur.next
		int count = 0;//number of nodes traversed 
		while(cur != null){
			count++;			
			next = cur.next;//store cur.next
			if(count+1 == m){//store node before m
				beforeM = cur;
			}
			else if(count == m){//start to reverse list
				cur.next = null;//isolate cur node
				revTail = cur;//set reversed list's head and tail
				revHead = cur;
			}
			else if(count > m && count <= n){//reverse the middle list
				cur.next = revHead;
				revHead = cur;
			}
			else if(count == n+1){//store node after n
				afterN = cur;
			}		
			cur = next;
		}
		
		revTail.next = afterN;//append afterN to reversed list's tail
		if(beforeM == null)//beforeM might be null, m = 1
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
