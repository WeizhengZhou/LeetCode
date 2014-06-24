import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * 
 * @author Weizheng
 *
 */
public class MinimumWindow_Failed {
	public String minWindow(String S, String T) {
		if(T == null || S == null || T.length() > S.length()) return "";	
		Set<String> dict = new HashSet<>();//dict of characters of T
        //initialize the dict
		for(int i=0;i<T.length();i++)
			dict.add(T.substring(i,i+1));		
		Map<String, Integer> map = new HashMap<>();//count occurrence of T's character in S
		Queue<Integer> queue = new LinkedList<>();//in the window, the index of T's character
		
		int minLength = Integer.MAX_VALUE;//minimum length of window
		String window = null;
		
		for(int i=0;i<S.length();i++){
			String cur = S.substring(i,i+1);//cur character in S		
			if(!dict.contains(cur))//if cur is not in T, continue to next 
				continue;
			
			if(!map.containsKey(cur)){//if current window does not have cur
				map.put(cur, 1);//count++
				queue.add(i);//put it in the queue
			}				
			else{
				map.put(cur, map.get(cur) + 1);//if window has this charater, count++
				queue.add(i);
			}					
			if(queue.size() == T.length()){//found all characters in T
				int index = queue.peek();//index of front of window
				String str = S.substring(index,index+1);//str of front of window
				int count = map.get(str);//count of front character of window
				//shrink window until the front character only occurs once in the window
				while(count > 1){
					queue.remove();//remove front character
					map.put(str,count-1);//update its count
					index = queue.peek();//prepare next front
					str = S.substring(index,index+1);
					count = map.get(str);
				}
				//new length of the window
				int length = i - index + 1;
				if(length < minLength){
					minLength = length;
					window = S.substring(index,i+1);//update 
				}				
			}		
			System.out.println("i = " + i + ", " + ", cur = " + cur);
			System.out.print("queue = " + queue + ", map = ");
			System.out.println(map);
		}
		if(window == null)//did't found such window
			return "";
		else 
			return window;
    }
	public static void main(String[] args){
//		String S = "ADOBECODEBANC";
//		String T = "BAC";
		String S = "aa";
		String T = "aa";
		MinimumWindow_Failed solu = new MinimumWindow_Failed ();
		System.out.println(solu.minWindow(S, T));
	}

}
