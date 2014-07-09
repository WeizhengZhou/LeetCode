

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
			
		if(gas == null || cost == null) return -1;
		if(gas.length != cost.length) return -1;		
		int n = gas.length;
		int start = 0;//start station
		int end = 0;//end station
		while(start < n){//try all start station
			end = start;
			int remain = 0;//remain gas
			while(end < start + n && remain >=0 ){//try to reach other n-1 station, until remaining gas < 0
				remain = remain + gas[end%n] - cost[end%n];//update remaining gas
				end++;//move to next station
			}
			if(end == start+n && remain >= 0)//if can travel around the circle
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
