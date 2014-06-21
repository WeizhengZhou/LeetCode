import java.util.Arrays;


public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
			
		if(gas == null || cost == null) return -1;
		if(gas.length != cost.length) return -1;
		
		int n = gas.length;
		int[] extra = new int[n];//gas remain at station i
		
		
		for(int i=0;i<n;i++){
			extra[i] = gas[i] - cost[i];
		}
		System.out.println(Arrays.toString(extra));
		
		int start = 0;
		int end = 0;
		while(start < n){
			end = start;
			int remain = 0;
			while(end < start + n && remain >=0 ){
				remain = remain + extra[end%n];
				end++;
			}
			if(end == start+n && remain >= 0)
				return start;
			start = end;
		}
		return -1;
	}
	public static void main(String[] args){
		int[] gas = new int[]{5,2,10,3};
		int[] cost = new int[]{4,4,4,4};
		GasStation s = new GasStation();
		System.out.println(s.canCompleteCircuit(gas, cost));
		
	}
	
}
