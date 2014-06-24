import java.util.*;
/**
 * We maintain two data structures, a queue and a map to solve this problem. 
 * 
 * Let the characters in T be the "needed" character, 
 * for example 'A', 'B' and 'C' are needed characters when T = "ABC". 
 * 
 * The map records the remaining number of "needed" characters in S, 
 * at the begining, the value of each key = the number of its occurrence in T.  
 * The queue record the index of the needed character in S.
 * 
 * We scan S from left to right
 * When we find a needed character, we update its value in the map. 
 * If the value equals zero, it means the window contains exactly the right number we needed.  
 * If the value drops below zero, which means the window contains the key more than we needed. 
 * 
 * Use totalCount to determine if we find a proper window, which contains all characters of T.
 * In order to do this, we initialize the totalCount = T.length(). 
 * Every time, we find a new needed character in,
 * and it is still wanted (its count > 0), we let the totalCount--.
 * When totalCount == 0, we found all the characters in the window.
 * 
 * Then we can shrink the window, since some characters may exceed the number we want. 
 * The front element in the queue is the entrance of the window.
 * If the front's occurrence is more than we wanted (its count < 0), we delete it from the window
 * by update the key's value, and dequeue it from the queue. 
 * 
 * Finally, we update the min length of the window. 
 * 
 * @author Weizheng
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if(T == null || S == null || T.length() > S.length()) return "";
		int minLength = Integer.MAX_VALUE;//minimum length of the window
		String window = null;
		
		Queue<Integer> queue = new LinkedList<>();//record the index of each character in the window
		Map<String, Integer> map = new HashMap<>();//record number of keys needed in S
		
		//initialize the <key, value> = <T[i], number of T[i] in T>
		for(int i=0;i<T.length();i++){
			String cur = T.substring(i,i+1);
			if(!map.containsKey(cur))
					map.put(cur, 1);
			else
				map.put(cur, map.get(cur)+1);
		}		
		int totalCount = T.length();//total number of characters needed in window	
		for(int i=0;i<S.length();i++){
			String cur = S.substring(i,i+1);//cur character in S		
			if(!map.containsKey(cur))//if cur is not in T, continue to next 
				continue;
			
			if(map.get(cur) > 0)//if found a needed character
				totalCount--;
			
			map.put(cur, map.get(cur)-1);//needed 
			queue.add(i);//put it in the queue	
			
			if(totalCount == 0){//found all characters
				int index = queue.peek();//index of front of the window
				String str = S.substring(index,index+1);//str of front of window
				int count = map.get(str);//count of front character of window		
				//shrink the front of window if the front character occurs more than needed
				while(count < 0){//count < 0 is more than needed, == 0 is exactly the number 
					queue.remove();//remove front character
					map.put(str,count + 1);//update its count
					index = queue.peek();//prepare next front
					str = S.substring(index,index+1);
					count = map.get(str);
				}
				//update the window
				int length = i - index + 1;
				if(length < minLength){
					minLength = length;
					window = S.substring(index,i+1);//update 
				}				
			}		
//			System.out.println("i = " + i + ", " + ", cur = " + cur);
//			System.out.print("queue = " + queue + ", map = ");
//			System.out.println(map);
		}
		if(window == null)//did't found such window
			return "";
		else 
			return window;
    }
	public static void main(String[] args){
		String S = "ADOBECODEBANC";
		String T = "BAC";
//		String S = "aa";
//		String T = "aa";
		MinimumWindowSubstring solu = new MinimumWindowSubstring ();
		System.out.println(solu.minWindow(S, T));
	}

}
