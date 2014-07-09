import java.util.*;
/**
 * should compare this results with O(n^2)
 * O(n^2) solution
 * for(each cut at i = 1:n-1)
 *    l = left max profit
 *    r = right max profit
 *    max = max(max,l+r);
 * end
 * Think hwo to transform such a O(n^2) solution into a O(n) solution
 * @see http://www.tuicool.com/articles/U7Nvme
 * @author Weizheng
 *
 */

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <2) return 0;
		int n = prices.length;

		int[] L = new int[n];// max profit of prices[0...i]
		int max = 0;
		int curMax = 0;
		for(int i=1;i<n;i++){
			curMax+= prices[i] - prices[i-1];
			max = (curMax > max) ? curMax:max;
			curMax = (curMax < 0) ? 0:curMax;
			L[i] = max;
		}
		
		int[] R = new int[n];
		//min profit of prices[i...n], if but at later time and sell at earlier time	
		//minimize this value also maximize the profit
		int min = 0;
		int curMin = 0;

		for(int i=n-2;i>=0;i--){
			curMin += (prices[i] - prices[i+1]);
			min = (curMin < min) ? curMin:min;
			curMin = (curMin > 0) ? 0:curMin;
			R[i] = min;
		}
		
		int maxProfit = L[n-1];//one transition
		for(int i=0;i<n-1;i++){//two transitions, cut at i
			maxProfit = Math.max(maxProfit,L[i]- R[i+1]);		
		}

		
		return maxProfit;
	}

	public static void main(String[] args){
		int[] prices = new int[]{1,2,1,4};
//		int[] prices = new int[]{2,4,1};
//		int[] prices = new int[]{6,1,3,2,4,7};
//		int[] prices = new int[]{1,2};
		BestTimetoBuyandSellStockIII s = new BestTimetoBuyandSellStockIII();
		System.out.println(s.maxProfit(prices));
		
	}


}
