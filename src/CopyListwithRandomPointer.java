import java.util.*;

public class CopyListwithRandomPointer {
	public class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(this.label);
			if(next != null)
				sb.append(", next = " + next.label);		
			else
				sb.append(", next = null");
			if(random != null)
				sb.append(", random = " + random.label);			
			else
				sb.append(", random = null");
			return sb.toString();
				
		}
	}
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		//map the node to its copied company
		//build a connection between original nodes and copied nodes
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		
		RandomListNode head_cp = new RandomListNode(head.label);
		RandomListNode cur = head;
		RandomListNode cur_cp = head_cp; 
	
		map.put(cur, cur_cp);//put head and head'copy to map
		while(cur.next != null){//while has next node
			cur_cp.next = new RandomListNode(cur.next.label);//create a copy
			
			cur = cur.next;//move to next
			cur_cp = cur_cp.next;
			map.put(cur, cur_cp);
		}
//		System.out.println(map);
		
		cur = head;
		cur_cp = head_cp;
		while(cur != null){
			cur_cp.random =  map.get(cur.random);//cp.random = oringal.random.company
			cur = cur.next;
			cur_cp = cur_cp.next;			
		}
		print(head_cp);
		
		return head_cp;
	}
	public static void main(String[] args){
		CopyListwithRandomPointer s = new CopyListwithRandomPointer();
		CopyListwithRandomPointer.RandomListNode head = s.new RandomListNode(1);
		head.next = s.new RandomListNode(2);
		head.next.next = s.new RandomListNode(3);
		head.random = head.next.next;
		head.next.next.random = head;	
		
		RandomListNode head_cp = s.copyRandomList(head);
//		s.print(head_cp);
	}
	private void print(RandomListNode head){
		while(head != null){
			System.out.println(head);
			head = head.next;	
		}
	}
}
