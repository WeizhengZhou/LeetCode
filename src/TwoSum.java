
import java.util.Arrays;
import java.util.HashMap;
public class TwoSum {
	public int[] twoSum(int[] numbers, int target){
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<numbers.length;i++){
			int other = target - numbers[i];
			hm.put(other, i);
		}
		int index1 = 0;
		int index2 = 0;
		
		for(int i=0;i<numbers.length;i++){
			if(hm.containsKey(numbers[i])){
				int otherIndex = hm.get(numbers[i]);
				if(otherIndex != i){
					index1 = i+1;
					index2 = otherIndex+1;
					
				}
			}
		}
		return new int[]{Math.min(index1,index2),Math.max(index1, index2)};
		
		
	}
	public static void main(String[] args){
		int[] numbers = new int[]{7, 6, 11, 0};
		int target = 6;
		int[] indexes = new TwoSum().twoSum(numbers,target);
		System.out.println(Arrays.toString(indexes));
		
	}

}
