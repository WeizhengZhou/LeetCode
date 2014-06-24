import java.util.*;


public class ThreeSumCloset {
    public int threeSumClosest(int[] A, int target) {
    	if(A == null || A.length < 3) return 0;
    	Arrays.sort(A);
    	int minDiff = Integer.MAX_VALUE;
    	int closet = Integer.MAX_VALUE;
    	
    	for(int i=0;i<A.length-2;i++){
    		int l = i+1;
        	int r = A.length - 1;      	
        	while(l < r){
        		int s = A[i] -target + A[l] + A[r];
//        		System.out.println("i = " + i + ", l = " + l + ", r = " + r + ", s = " + s);
        		if(s == 0)
        			return target;      			
        		if(Math.abs(s) < minDiff){
        			closet = s + target;
        			minDiff = Math.abs(s);
        		}
        			
        		if(s < 0)
        			l++;
        		else
        			r--;
        	}   		
    	} 
    	return closet;
    }
    public static void main(String[] args){
    	int target = 20;
    	int[] A = new int[]{-1,2,1,4,5};
    	ThreeSumCloset s = new ThreeSumCloset();
    	System.out.println(s.threeSumClosest(A, target));
    }
}
