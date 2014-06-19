
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <2) 
			return 0;
		int[] diff = new int[prices.length];
		for(int i=1;i<prices.length;i++)
			diff[i] = prices[i] - prices[i-1];
		
		return continousLargestSum(diff);
	}
	private int continousLargestSum(int[] A){
		int max = 0;
		int cur = 0;
		
		for(int i=0;i<A.length;i++){
			cur += A[i];
			max = (cur > max) ? cur:max;
			cur = (cur < 0) ? 0:cur;
		}
		return max;
	}
	public static void main(String[] args){
		int[] prices = new int[]{5,5,5};
		BestTimetoBuyandSellStock s = new BestTimetoBuyandSellStock();
		System.out.println(s.maxProfit(prices));
		
	}

}
