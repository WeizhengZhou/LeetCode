import java.util.*;
public class MinimumWindowSubstring {
	
	public String minWindow(String S, String T) {
		
		if(T == null || S == null || T.length() > S.length()) return "";
		
		Set<String> charSet = new HashSet<>();//character set of T
	
        //initialize the charSet
		for(int i=0;i<T.length();i++){
			charSet.add(T.substring(i,i+1));
		}
		
		Queue<Integer> queue = new LinkedList<>();//index of S which contain char in T
		Set<String> mark = new HashSet<>();//mark if char of T is found in S
		int minLength = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		
		for(int i=0;i<S.length();i++){
			String cur = S.substring(i,i+1);
			//if r is a character in T
			if(!charSet.contains(cur))
				continue;
			//else
			mark.add(cur);
			queue.add(i);
			int front = queue.peek();//front character in the queue
			if(mark.size() == T.length() && minLength > i - front){//found all characters with a smaller length
				start = front;
				end = i;	
				minLength = end - start + 1;
				System.out.println("start = " +  start + ", end = " + end + ", minLength = " + minLength );
			}		
			if(cur.equals(S.substring(front,front+1))){//if the front character has a better replacement
				queue.remove();
				queue.add(i);
			}
			System.out.print("i = " + i + ", ");
			System.out.print("queue = " + queue + ", mark = ");
			System.out.println(mark);
					
		}
		if(minLength == Integer.MAX_VALUE)
			return "";
		else 
			return S.substring(start,end+1);
    }
	public static void main(String[] args){
		String S = "ADOBECODEBANC";
		String T = "BAC";
		MinimumWindowSubstring solu = new MinimumWindowSubstring ();
		System.out.println(solu.minWindow(S, T));
	}

}
