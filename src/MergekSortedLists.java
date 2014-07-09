import java.util.*;

public class MergekSortedLists {
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
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0) return null;
		return helper(lists,0,lists.size()-1);			
	}
	private ListNode helper(List<ListNode> lists, int l, int r){
		if(l == r) return lists.get(l);
		int m = l + (r-l)/2;
		ListNode mergedL = helper(lists, l, m);
		ListNode mergedR = helper(lists, m+1, r);
		return mergeTwo(mergedL, mergedR);		
	}
	public ListNode mergeKLists_PriorityQueue(List<ListNode> lists){
		if(lists == null || lists.size() == 0) return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>(){
			@Override
			public int compare(ListNode a, ListNode b){
				return a.val - b.val;
			}
		});
		for(ListNode head : lists)
			if(head != null)
				queue.add(head);
				
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		while(!queue.isEmpty()){
			tail.next = queue.poll();
			tail = tail.next;
			if(tail.next != null)
				queue.add(tail.next);
		}
		return dummyHead.next;
	}
	public static void main(String[] args){
		ListNode a = new ListNode().createList(new int[]{1,5,7});
		ListNode b = new ListNode().createList(new int[]{2,6,8});
		ListNode c = new ListNode().createList(new int[]{});
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(a);
		lists.add(b);
		lists.add(c);
//		ListNode res = new MergekSortedLists().mergeKLists(lists);
		ListNode res = new MergekSortedLists().mergeKLists_PriorityQueue(lists);
		a.printList(res);		
	}
}
