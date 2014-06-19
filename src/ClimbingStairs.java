
public class ClimbingStairs {
	public int climbStairs(int n) {
		
		int[] L = new int[n+1];
		L[0] = 1;
		L[1] = 1;
		L[2] = 2;
		for(int i=3;i<=n;i++){
			L[i] = L[i-1] + L[i-2];
		}
		return L[n];
	}

}
