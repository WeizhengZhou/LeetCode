
public class SingleNumber {
    public int singleNumber(int[] A) {
    	if(A == null) return 0;
    	int res = A[0];
    	for(int i =1;i<A.length;i++)
    		res = res ^ A[i];
    	return res;
        
    }
    public static void main(String[] args){
    	int[] A = new int[]{1,2,2,3,3,1,4};
    	SingleNumber s = new SingleNumber();
    	System.out.println(s.singleNumber(A));
    
    }
}
