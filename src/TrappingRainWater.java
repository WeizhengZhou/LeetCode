
public class TrappingRainWater {
    public int trap(int[] A) {
    	if(A == null || A.length <3) return 0;
    	int n = A.length;
    	
    	int[] lBar = new int[n];//left bar index
    	int[] rBar = new int[n];//right bar index
    	
    	for(int i=1;i<n;i++)
    		lBar[i] = Math.max(A[i-1],lBar[i-1]);//left highest bar
    	for(int i=n-2;i>=0;i--)
    		rBar[i] = Math.max(A[i+1], rBar[i+1]);//right highest bar
    	
    	int totalWater = 0;//total water trapped
    	for(int i=0;i<n;i++){
    		int waterLevel = Math.min(lBar[i],rBar[i]);//water level at this point
    		totalWater += Math.max(waterLevel-A[i], 0);//if water level is higher than base, add it
    	}
    	return totalWater;
    }
    public static void main(String[] ags){
//    	int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    	int[] A = new int[]{5,2,1,2,1,5};
//    	int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    	TrappingRainWater solution = new TrappingRainWater();
    	System.out.println(solution.trap(A));
    }

}
