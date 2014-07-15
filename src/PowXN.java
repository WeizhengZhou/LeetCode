
public class PowXN {
    public double pow(double x, int n) {
    	boolean isIntegerMin = (n == Integer.MIN_VALUE)?true:false;//in case n is Integer.min
    	if(isIntegerMin) n++;//to avoid overflow, result will be correct at the end    	
    	boolean sign = (n > 0) ? true:false;//store the sign of n
    	n = (n > 0) ? n:-n;//convert to positive, caution, n != Integer.min,
    	int d = 0;//current digit of n 
    	double x_2_d = x;//x^2^d
    	double res = 1;//final result
    	while(d < 31 && (1<<d) <= n){//consider all 31 digits of power n,
    		if((n & (1<<d)) != 0){//this coefficient != 0
    			res *=  x_2_d ;//muplity this power
    		}
    		x_2_d = x_2_d * x_2_d ;//x^2^(d+1)
    		d++;//digits plus one    		
    	}    	
    	if(isIntegerMin) res *=x;//multiply one more x, since n++ in line 5
    	return sign ? res : 1/res;//negative n	       
    }
    public static void main(String[] args){
    	PowXN solution = new PowXN();
    	double x = 1;
    	int n = Integer.MIN_VALUE;
    	System.out.println(solution.pow(x,n));  	
    	System.out.println(Math.pow(x, n));
    }
}
