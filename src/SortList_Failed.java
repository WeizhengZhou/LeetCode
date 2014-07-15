
public class SortList_Failed {
	public ListNode sortList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		
		int length = length(head);//total length of the list
		int subLength = 1;//sublist length
		
		while(subLength < length){		
			ListNode preL = dummyHead;
			while(preL != null && preL.next != null){
				//preL -> (l -> ....-> preR) -> (r-> ... ->preT) -> t
				ListNode l = preL.next;//left sublist's head
				preL.next = null;//disconnect preL and L
				ListNode preR = skipKNodes(l,subLength-1);//before right sublist
				if(preR.next == null) {
					preL.next = l;//connect preL and l
					break;//right sublist list is null, attention, it is a break not a continue
				}
				
				ListNode r = preR.next;//right sublist's head
				preR.next = null;//cut off the right sublist
				
				ListNode t = skipKNodes(r,subLength-1);//tail of right sublist
				ListNode postT = t.next;//node after right sublist, might be null
				t.next = null;
				
				t = (t.val > preR.val) ? t:preR;//record merged list's tail 
				
				preL.next = merge(l,r);
				t.next = postT;				
				preL = t;	
			}
			subLength *= 2;
		}
		return dummyHead.next;
	}
	private ListNode merge(ListNode a, ListNode b){
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
	
	
	private ListNode skipKNodes(ListNode l, int k){
		int count = 0;
		while(l.next != null && count < k){
			count++;
			l = l.next;
		}
		return l;		
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
		SortList_Failed solution = new SortList_Failed();
		int[] A = new int[]{6,5,4,3,2,1};
		ListNode head = new ListNode().createList(A);	
		ListNode sorted = solution.sortList(head);
		solution.print(sorted);
	}
	 private void print(ListNode head){
	    	while(head != null){
	    		System.out.print(head.val + ", ");
	    		head = head.next;
	    	}
	    	System.out.println();
	    }
	

}
