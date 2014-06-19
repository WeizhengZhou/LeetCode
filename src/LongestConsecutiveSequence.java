import java.util.*;

public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] num) {
		if(num == null) return 0;
		//  key = num[i], value = count of num[i]
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<num.length;i++){
			int key = num[i];
			if(!map.containsKey(key))
				map.put(key, 1);
			else
				map.put(key, map.get(key) + 1);
		}
		
		int maxLength = 0;//max consecutive length
		
		for(int i=0;i<num.length;i++){
			//current element
			int middle = num[i];
			
			if(map.containsKey(middle)){//if not visited before
				int left = middle;//left boundary of consecutive sequence
				int right = middle;//right boundary
				while(map.containsKey(left-1)){//can extend to left
					int count = map.get(left-1);//count the occurrence of left-1
					if(count > 1)//count is larger than 1, update count
						map.put(left-1, count-1);//left-1 not changed
					else{//all left-1 is visited, remove it from map
						map.remove(left-1);
						left--;
					}					
				}
				while(map.containsKey(right+1)){					
					int count = map.get(right+1);
					if(count > 1)
						map.put(right+1, count-1);
					else{
						map.remove(right+1);
						right++;				
					}						
				}
				
				if(maxLength < (right - left +1))//longer length is found
					maxLength = right - left + 1;				
			}		
		}
		return maxLength;
	}
	public static void main(String[] args){
		int[] A = new int[]{100, 4, 200, 1, 3, 2};
		LongestConsecutiveSequence s = new LongestConsecutiveSequence();
		System.out.println(s.longestConsecutive(A));
	}
}
