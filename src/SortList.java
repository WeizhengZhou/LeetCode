
public class SortList {
	
	public ListNode sortList(ListNode head){
		int totalLength = length(head);//total length of the list
		int subListLength = 1;//sublist's length, start with 1
				
		ListNode preTail, leftHead, leftTail, rightHead, rightTail, postHead;
		ListNode dummyHead = new ListNode(0);//dummy head 
		dummyHead.next = head;
		
		while(subListLength < totalLength){//until sublist's length is larger than total length
			preTail = dummyHead;//previous sublist's tail			
			leftHead = preTail.next;//left sublist'head	
			while(leftHead != null){	
				leftTail  = skipKNodes(leftHead,subListLength-1);//left sublist's tail
				rightHead = leftTail.next;//right sublist' head
				if(rightHead == null) break;//right sublist is empty	
				rightTail = skipKNodes(rightHead,subListLength-1);//right sublist' tail
				postHead = rightTail.next;//next sublist' head
				
				leftTail.next = null;//disconnect left sublist and right sublist
				rightTail.next = null;//disconnect right sublist and next sublist
							
				//assign merged tail be the larger of two sublist
				//if leftTail.val == rightTail.val, according to merge method, the mergedTail = rightTail.
				ListNode mergedTail = (leftTail.val < rightTail.val) ? rightTail:leftTail;
				preTail.next = merge(leftHead,rightHead);//merge two lists and connect to previous list
			
				mergedTail.next = postHead;//connect merged sublist with next list
								
				preTail = mergedTail;//set new previous list's tail
				leftHead = preTail.next;//set new left list's head
			}
			subListLength *= 2;//sublist's length * 2
		}
		return dummyHead.next;//return sorted head
			
	}
	private ListNode merge(ListNode a, ListNode b){//merge two sorted list
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		while(a != null && b != null){
			if(a.val < b.val){
				tail.next = a;
				a = a.next;
			}
			else{
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		tail.next = (a != null)? a:b;
		return dummyHead.next;
	}
	private ListNode skipKNodes(ListNode n, int k){//skip k nodes from node n, return a non-null node
		while(n != null && n.next != null && k > 0){
			k--;
			n = n.next;
		}
		return n;
	}
	private int length(ListNode head){
		 int length = 0;
		 while(head != null){
			 length++;
			 head= head.next;
		 }
		 return length;		 
   }
	
	public static void main(String[] args){
		int[] A = new int[]{1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1,1,2,1,3,3,2,2,1,3,1,3,1,3,2,2,3,2,3,2,2,1,2,3,1,3,1,2,3,3,2,3,3,3,1,1,2,3,1,2,3,2,1,1,2,3,1,1,3,1,2,2,3,2,1,3,1,2,1,3,2,1,1,2,2,2,1,3,1,3,2,3,3,1,1,3,1,2,1,2,3,1,2,1,1,3,1,3,3,1,1,1,2,2,1,3,1,2,2,3,2,1,3,2,1,3,2,2,3,3,2,2,1,3,2,2,2,2,2,3,2,2,3,1,3,2,1,3,2,1,2,3,3,3,1,2,2,3,1,1,2,2,3,2,1,1,1,1,1,3,2,2,2,1,3,2,1,2,3,2,1,1,2,1,3,3,1,3,1,2,2,1,2,3,2,3,3,1,2,3,2,2,3,3,2,1,3,2,2,2,3,3,3,1,1,2,1,1,2,3,3,3,1,3,2,2,1,2,2,1,2,3,1,3,2,2,3,3,3,1,2,3,2,1,3,1,1,2,2,1,1,1,2,2,3,1,3,1,2,3,3,3,2,2,3,1,1,1,3,2,1,1,3,1,2,3,3,3,2,1,2,3,2,3,2,1,3,2,2,2,2,1,1,3,1,1,1,3,2,2,2,1,2,3,2,3,2,2,1,2,3,2,1,1,3,1,3,3,1,1,1,1,1,2,3,3,3,1,3,2,2,3,1,1,3,1,1,1,3,1,1,2,2,2,1,1,1,1,2,1,3,3,3,1,2,2,2,2,3,3,1,2,2,3,1,3,1,2,1,2,2,3,3,1,3,3,2,1,3,1,1,3,1,2,3,3,3,3,1,1,3,3,3,3,2,2,2,1,1,3,2,2,2,3,1,3,3,3,1,1,3,1,3,2,3,1,2,3,2,2,3,3,3,1,2,1,2,1,2,3,1,2,2,2,1,1,1,2,2,1,2,1,1,1,3,2,1,2,3,2,2,2,1,2,3,2,2,1,3,3,3,1,2,3,3,1,1,3,3,1,1,2,1};
//		int[] A = new int[]{6,5,4,3,2,1};
		ListNode head = new ListNode().createList(A);
		
		SortList sortList = new SortList();
		ListNode sorted = sortList.sortList(head);
		sortList.print(sorted);
	}
	 private void print(ListNode head){
	    	while(head != null){
	    		System.out.print(head.val + ", ");
	    		head = head.next;
	    	}
	    	System.out.println();
	    }
}
