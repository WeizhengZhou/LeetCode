import java.util.*;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if(num == null) return 0;
		Set<Integer> set = new HashSet<>();
		for(int n:num)
			set.add(n);
		
		int maxL = 0;		
		for(int i=0;i<num.length;i++){
			int curL = 0;
			int l = num[i];
			while(set.contains(l)){
				set.remove(l);
				curL++;
				l--;
			}
			int r = num[i]+1;
			while(set.contains(r)){
				set.remove(r);
				curL++;
				r++;
			}
			maxL = Math.max(maxL,curL);
		}
		return maxL;
	}

	public static void main(String[] args){
		int[] A = new int[]{100, 0, 99, 1, 3, 2};
		LongestConsecutiveSequence s = new LongestConsecutiveSequence();
		System.out.println(s.longestConsecutive(A));
	}
}
