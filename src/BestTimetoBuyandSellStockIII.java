import java.util.*;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <2) 
			return 0;
		int[] diff = new int[prices.length];
		for(int i=1;i<prices.length;i++)
			diff[i] = prices[i] - prices[i-1];
		
		return largestSubsquenceSum(diff);
	}
	
	//sum up all positive diff
	private int largestSubsquenceSum(int[] A){
		List<Integer> list = new ArrayList<Integer>();		
		int max = 0;
		int cur = 0;	
		for(int i=0;i<A.length;i++){
			cur += A[i];
			if(cur > max){
				max = cur;
			}
			if(cur < 0){
				list.add(max);//last peroid's max value
				cur = 0;
				max = 0;
			}
		}
		
		list.add(max);
		Collections.sort(list);
		
		if(list.size() == 1)
			return list.get(0);
		else 
			return list.get(list.size()-1) + list.get(list.size()-2);
		
	}
	public static void main(String[] args){
		int[] prices = new int[]{1,2,1,4};
		BestTimetoBuyandSellStockIII s = new BestTimetoBuyandSellStockIII();
		System.out.println(s.maxProfit(prices));
		
	}


}
