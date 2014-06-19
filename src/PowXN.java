
public class PowXN {
//    public double pow(double x, int n) {
////    	System.out.println("x = "+ x + ", n = " + n);
//    	if(n == 0) 
//    		return 1;
//    	else if(x == 0)
//    		return 0;
//    	else if(n == 1) 
//    		return x;
//    	else if(n == -1) {
//    		return 1/x;
//    	}
//    	else if(n%2 == 0) 
//    		return pow(x,n/2) * pow(x,n/2);
//    		
//    	else{
//    		System.out.println("n = " + n);
//    		return pow(x,n/2) * pow(x,n/2) * pow(x,n-n/2-n/2);
//    	}
//    		       
//    }
	
//    private double pow_helper(double x, int n){
//    	System.out.println(n);
//    	if(n == 0) return 1;
//    	if(x < Double.MIN_VALUE) return 0.;
//    	else if(n == 1) return x;
//    	else if(n % 2 == 0)
//    		return pow_helper(x,n/2) * pow_helper(x,n/2);
//    	else
//    		return pow_helper(x,n/2) * pow_helper(x,n/2) * x;
//    		
//    	
//    }
    public double pow(double x, int n){
    	if(n == 0) return 1;
    	if(x == 0) return 0;
    	
    	int sign = (n>0)?1:-1; 	
    	n = (n>0)?n:-n;
    	 	
    	double[] table = new double[32];
    	table[0] = x;
    	for(int i=1;i<table.length;i++){
    		table[i] = table[i-1] * table[i-1];
    	}
    	
    	
    	double res = 1.;
    	int i = 0;   	
    	while(n > 0){
    		System.out.println("n = " + n + ", res = " + res);
    		
    		if(((n >> i) & 1) == 1)
    			res = res*table[i];
    		
    		n = n & (~(1<<i)) ;
    		i++;  			
    	}
    		
    	if(sign > 0) 
    		return res;
    	else 
    		return 1/res;  	
    }

    public static void main(String[] args){
    	PowXN solution = new PowXN();
    	double x = 2;
    	int n = 32;
//    	System.out.println(Integer.toBinaryString(3 & ~(1<<1)));

    	System.out.println(solution.pow(x,n));  	
    	System.out.println(Math.pow(x, n));

    }
}
