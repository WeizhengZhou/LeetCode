import java.util.*;
/**
 * @see http://blog.csdn.net/linhuanmars/article/details/21424783
 * 
 * @author Weizheng
 *
 */
public class Candy {
    public int candy(int[] A) {
    	if(A == null||A.length == 0) return 0;
    	int n = A.length;
    	int[] L = new int[n];//least candy needed compared to left child
    	int[] R = new int[n];//least candy needed compared to right child
    	L[0] = 1;//first child need as least one
    	for(int i=1;i<n;i++){
    		if(A[i]>A[i-1]) //if larger rating than left
    			L[i] = L[i-1]+1;//candy + 1
    		else
    			L[i]=1;//else, it may be a valley
    	}
        R[n-1] = 1;//last child candy needed is one
    	for(int i=n-2;i>=0;i--){
    		if(A[i]>A[i+1]) //larger than right child
    			R[i] = R[i+1]+1;
    		else
    			R[i]=1;
    	}
//    	System.out.println(Arrays.toString(L));
//    	System.out.println(Arrays.toString(R));
    	int res = 0;
    	for(int i=0;i<n;i++)
    		res+=Math.max(L[i], R[i]);
    	return res;   	
    }
    
    public static void main(String[] args){
    	int[] A = new int[]{1,2,2};
//    	int[] A = new int[]{2,1};
//    	int[] A = new int[]{2,2,1};
    	Candy c = new Candy();
    	System.out.println(c.candy(A));
    	
    }
}
