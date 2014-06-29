import java.util.Arrays;
public class Candy_Complicated {
    public int Candy_Complicated(int[] A) {
    	if(A == null||A.length == 0) return 0;
    	if(A.length == 1) return 1;
    	int[] C = new int[A.length];
    	
    	C[0] = 1;
    	int nCandies = 1;
    	
    	int prePeak = -1;
    
    	if(isPeak(A,0))
    		prePeak = 0;
       	
    	int i =1;
    	while(i < A.length){
    		if(A[i] < A[i-1])
    			C[i] = C[i-1] - 1;
    		else if(A[i] > A[i-1])
    			C[i] = C[i-1] +1;
    		else
    			C[i] = C[i-1];  		 		
    		if(isPeak(A,i)){
    			prePeak = i;        		
        		nCandies += C[i];
    		}
    		else if(isValley(A,i)){ 			
    			if(C[i] < 1){
    				nCandies += C[i];
    				nCandies += (i - prePeak + 1) * (1 - C[i]);   			
    			}
    			else{  				
    				nCandies += 1;			
    			}
    			C[i] = 1; 
    		}
    		 		
    		System.out.println("i = " + i + ", nCandies " + nCandies);
    		i++;
    	} 
    	System.out.println(Arrays.toString(C));
    	return nCandies;
    }
    public boolean isPeak(int[] A, int i){
    	if(i == 0){
    		if(A[i] > A[i+1]) return true;
    		else return false;
    	}
    	else if(i == A.length-1){
    		if(A[i] > A[i-1]) return true;
    		else return false;
    	}
    	else{
    		if((A[i] > A[i-1] && A[i] >= A[i-1]) || (A[i] >= A[i-1] && A[i] > A[i-1]))
    		     return true;
    		else return false;
    	}   	
    }
    public boolean isValley(int[] A, int i){ 
    	if(i == 0){
    		if(A[i] <= A[i+1]) return true;
    		else return false;
    	}
    	else if(i == A.length-1){
    		if(A[i] <= A[i-1]) return true;
    		else return false;
    	}
    	else{
    		if(A[i] <= A[i-1] && A[i] <= A[i+1]) return true;
    		else return false;
    	}   	
    }   
    public static void main(String[] args){
//    	int[] A = new int[]{1,2,2};
//    	int[] A = new int[]{2,1};
    	int[] A = new int[]{2,2,1};
    	Candy_Complicated c = new Candy_Complicated();
    	System.out.println(c.Candy_Complicated(A));
    	
    }
}
