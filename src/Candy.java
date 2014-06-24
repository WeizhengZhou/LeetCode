
public class Candy {
    public int candy(int[] A) {
    	if(A == null) return 0;
    	if(A.length == 1) return 1;

    	int nCandy = 0;  
    	
    	int lv = 0;//left valley
		int peak = 0;//peak between the left valley and the right valley
		int rv = 0;//right valley
    		  	
        lv = nextValley(A,0);
        
        //A[0] is a peak, give candy between A[0] to A[lv]     
    	if(lv != 0){
    		nCandy += monoCandy(lv+1);
    	}
    	//move though all duplicates 
    	while(lv < A.length -1 && A[lv] == A[lv+1]){
    		nCandy++;
    		lv++;
    	}
    
    	while(lv < A.length){
    		peak = nextPeak(A, lv);
    		rv = nextValley(A, peak);
    		if(peak == A.length -1){
    			nCandy += monoCandy(peak - lv + 1);
    		}
    		else if(peak - lv < rv - peak){//left is longer
    			
    			  			
    		}
    		else{
    			
    		}   			  		
    	}	   		 	
    }
    private int peakCandy(int lv, int peak, int rv){
    	
    }
    private int monoCandy(int n){
    	int cur = 1;
    	int nCandy = 0;
    	while(n > 0){
    		nCandy += cur;
    		cur++;
    	}
    	return nCandy;   	
    }
    private int nextPeak(int[] A, int s){
    	if(s == 0 && A[0] >= A[1]) return 0;
    	for(int i=1;i<A.length-1;i++){
    		if(A[i]>=A[i-1] && A[i] >= A[i+1])
    			return i;
    	}
    	return A.length-1; 	
    }
    private int nextValley(int[] A, int s){
    	if(s == 0 && A[0] <= A[1]) return 0;
    	for(int i=1; i<A.length-1;i++){
    		if(A[i] <= A[i-1] && A[i] <= A[i+1])
    			return i;
    	}
    	return A.length-1;   	
    }
}
