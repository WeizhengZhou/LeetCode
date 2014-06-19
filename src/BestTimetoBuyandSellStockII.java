
public class BestTimetoBuyandSellStockII {
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
		int max = 0;
		for(int i=0;i<A.length;i++){
			if(A[i] > 0)
				max += A[i];
		}
		return max;
	}
	public static void main(String[] args){
		int[] prices = new int[]{5,1,5};
		BestTimetoBuyandSellStockII s = new BestTimetoBuyandSellStockII();
		System.out.println(s.maxProfit(prices));
		
	}

}
