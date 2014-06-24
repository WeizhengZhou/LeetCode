
public class SortList {
	 public ListNode sortList(ListNode head){
		 if(head == null || head.next == null) return head;
		 ListNode dummyHead = new ListNode(0);
		 dummyHead.next = head;
		 
		 int totalLength = totalLength(head);
		 int curLength = 1;
		 
		 while(curLength < totalLength){
			 ListNode preL = dummyHead;
			 while(preL != null){
				 ListNode l = preL.next;
				 ListNode r = l;
				 int count = 0;
				 while(r.next != null && count < curLength){
					 count++;
					 r = r.next;
				 }	
				 if(l == r) 
					 break;	
				 if(preL == dummyHead && r.next == null)
					 return dummyHead.next;
				 
				 System.out.println("A, curLength = " + curLength);
				 System.out.println("l = " + l.val + ", r = " + r.val);
				 ListNode th = new ListNode(0);//temp head
				 ListNode tt = th;//temp tail
				 int countL = 0;
				 int countR = 0;
				 while(r != null && countL < curLength && countR < curLength){
					 if(l.val < r.val){
						 tt.next = l;
						 ListNode next = l.next;
						 l.next = null;
						 l = next;
						 countL ++;
					 }
					 else{
						 tt.next = r;
						 ListNode next = r.next;
						 r.next = null;
						 r = next;
						 countR ++;
					 }
					 tt = tt.next;
				 }
				 System.out.println("B, curLength = " + curLength);

				 while(countL < curLength){
					 tt.next = l;
					 ListNode next = l.next;
					 l.next = null;
					 l = next;
					 tt = tt.next;	
					 countL++;
				 }
				 while(r != null && countR < curLength){
					 tt.next = r;
					 ListNode next = r.next;
					 r.next = null;
					 r = next;
					 countR++;
				 }	
				 System.out.println("C, curLength = " + curLength);

				 preL.next = th.next;
				 preL = tt;
			 }
			 System.out.println(curLength);
			 curLength = curLength * 2;			 
		 }
		 return dummyHead.next;
	 }
	 private int totalLength(ListNode head){
		 int count = 0;
		 while(head != null){
			 count++;
			 head= head.next;
		 }
		 return count;		 
	 }
	
	public static void main(String[] args){
//		int[] A = new int[]{1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1,1,2,1,3,3,2,2,1,3,1,3,1,3,2,2,3,2,3,2,2,1,2,3,1,3,1,2,3,3,2,3,3,3,1,1,2,3,1,2,3,2,1,1,2,3,1,1,3,1,2,2,3,2,1,3,1,2,1,3,2,1,1,2,2,2,1,3,1,3,2,3,3,1,1,3,1,2,1,2,3,1,2,1,1,3,1,3,3,1,1,1,2,2,1,3,1,2,2,3,2,1,3,2,1,3,2,2,3,3,2,2,1,3,2,2,2,2,2,3,2,2,3,1,3,2,1,3,2,1,2,3,3,3,1,2,2,3,1,1,2,2,3,2,1,1,1,1,1,3,2,2,2,1,3,2,1,2,3,2,1,1,2,1,3,3,1,3,1,2,2,1,2,3,2,3,3,1,2,3,2,2,3,3,2,1,3,2,2,2,3,3,3,1,1,2,1,1,2,3,3,3,1,3,2,2,1,2,2,1,2,3,1,3,2,2,3,3,3,1,2,3,2,1,3,1,1,2,2,1,1,1,2,2,3,1,3,1,2,3,3,3,2,2,3,1,1,1,3,2,1,1,3,1,2,3,3,3,2,1,2,3,2,3,2,1,3,2,2,2,2,1,1,3,1,1,1,3,2,2,2,1,2,3,2,3,2,2,1,2,3,2,1,1,3,1,3,3,1,1,1,1,1,2,3,3,3,1,3,2,2,3,1,1,3,1,1,1,3,1,1,2,2,2,1,1,1,1,2,1,3,3,3,1,2,2,2,2,3,3,1,2,2,3,1,3,1,2,1,2,2,3,3,1,3,3,2,1,3,1,1,3,1,2,3,3,3,3,1,1,3,3,3,3,2,2,2,1,1,3,2,2,2,3,1,3,3,3,1,1,3,1,3,2,3,1,2,3,2,2,3,3,3,1,2,1,2,1,2,3,1,2,2,2,1,1,1,2,2,1,2,1,1,1,3,2,1,2,3,2,2,2,1,2,3,2,2,1,3,3,3,1,2,3,3,1,1,3,3,1,1,2,1};
		int[] A = new int[]{3,1,2};
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
