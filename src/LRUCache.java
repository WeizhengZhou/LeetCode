import java.util.*;
/**
 *  *
 *  A Node class, with fields key, value, pre and next. 
 * Using two data structures to implement the least recently used cache
 * Using a HashMap<key,Node> to fast get O(1) and fast set O(1)
 * A doubly linked list to quickly find the LRU node, insert and delete O(1). 
 * The list has a dummy head and a dummy tail, which do not record real data
 * Whenever insert or get a node, it is placed as the first node.
 * Whenever the cache reaches its capacity, we evict its last node, which should be the least used node
 * Pay attention to the speical case, head <==> tail. 
 * @author Weizheng
 *
 */
public class LRUCache{	
	private int capacity = 0;
	private int count = 0;
	private Node head = null;
	private Node tail = null;
	private Map<Integer,Node> hm = null;
	
	public class Node{
		int key = 0;
		int value = 0;
		Node pre = null;
		Node next =null;
		public Node(int k, int v){
			key = k;
			value = v;
		} 
		public String toString(){
			return "[" + key + "," + value + "]";
		}
	}
	public LRUCache(int c) {
		capacity = c;
		head = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
		tail = new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
		head.next = tail;
		tail.pre = head;
		hm = new HashMap<Integer, Node>();	
	}
	public int get(int k) {
		if(!hm.containsKey(k))
			return -1;
		else{
			Node n = hm.get(k);
			moveToFirst(n);
			return n.value;
		}	
	}
	public void set(int k, int v) {
		if(hm.containsKey(k)){
			Node n = hm.get(k);
			n.value = v;
			moveToFirst(n);
//			System.out.println("Updating node " + n);
		}
		else{
			if(count == capacity){//new node, exceed capacity
				Node last = tail.pre;
				hm.remove(last.key);		
				tail.pre = last.pre;
				last.pre.next = tail;	
				count--;
//				System.out.println("Deleting node = " + last);
			}
			Node n = new Node(k,v);
			hm.put(k,n);
			count++;				
			if(count == 0){
				head.next = n;
				n.pre = head;
				n.next = tail;
				tail.pre = n;				
			}
			else{
				Node first = head.next;//first data node
				//insert n to be first data node
				head.next = n;
				n.pre = head;
				n.next = first;
				first.pre = n;							
			}	
//			System.out.println("Inserting node" + n);
		}	
	}

	private void moveToFirst(Node n){
		if(head.next == n) return;
		Node pre = n.pre;//previous node of n
		Node next = n.next;//next node of n
		Node first = head.next;//first data node
		//connect pre and next, isolate n
		pre.next = next;
		next.pre = pre;		
		//insert n to be first data node
		head.next = n;
		n.pre = head;
		n.next = first;
		first.pre = n;	
	}
	public String toString(){
		return "size = " + hm.size() + ", " + hm.toString();
	}
	public static void test(){
		LRUCache c = new LRUCache(2);
		c.set(2, 2);
		c.set(2, 1);
		System.out.println(c);
		c.get(2);
		c.set(1, 1);
		c.set(3, 3);
		c.get(2);
		System.out.println(c);
		
	}
	public static void main(String[] args){
		LRUCache.test();		
	}
}
