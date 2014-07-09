import java.util.*;

public class MinimumWindow_Failed {
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
		MinimumWindow_Failed solu = new MinimumWindow_Failed ();
		System.out.println(solu.minWindow(S, T));
	}

}
