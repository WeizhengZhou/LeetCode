
public class GasStation_TEL {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || cost == null) return -1;
		if(gas.length != cost.length) return -1;
		
		for(int i=0; i<gas.length;i++){
			if(aux(gas,cost) == true)
				return i;
			else
				rotateLeft(gas,cost);
		}		
		return -1;
	}
	private boolean aux(int[] gas, int[] cost){		
		int n = gas.length;
		int[] remain = new int[n+1];//gas remain at station i
		
		remain[0] = gas[0];
		for(int i=1;i<n;i++){
			remain[i] = remain[i-1] + gas[i] - cost[i-1];
		}
		remain[n] = remain[n-1] - cost[n-1];//back to station 0
		for(int i=0;i<=n;i++){
			if(remain[i] < 0)
				return false;
		}
		return true;
	}
	private void rotateLeft(int[] gas, int[] cost){
		int n = gas.length;
		int gas0 = gas[0];
		int cost0 = cost[0];
		for(int i=0;i<n-1;i++){
			gas[i] = gas[i+1];
			cost[i] = cost[i+1];
		}
		
		gas[n-1] = gas0;
		cost[n-1] = cost0;		
	}
}
