import java.util.*;

public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null) 
			return null;
		int n = lists.size();
		if(n == 0) return null;
		if(n == 1) 
			return lists.get(0);
		if(n == 2)
			return mergeTwo(lists.get(0),lists.get(1));
		
		
		List<ListNode> la = lists.subList(0, n/2);
		List<ListNode> lb = lists.subList(n/2,n);
		
		ListNode a = mergeKLists(la);
		ListNode b = mergeKLists(lb);
		
		return mergeTwo(a,b);
		
	}
	public ListNode mergeTwo(ListNode a, ListNode b){
	
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
		tail.next = (a==null) ? b : a;		
		return dummyHead.next;
		
	}

	public static void main(String[] args){
		ListNode a = new ListNode().createList(new int[]{1,5,7});
		ListNode b = new ListNode().createList(new int[]{2,6,8});
		ListNode c = new ListNode().createList(new int[]{3,4,9});
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(a);
		lists.add(b);
		lists.add(c);
		ListNode res = new MergekSortedLists().mergeKLists(lists);
		a.printList(res);
		
	}


}
