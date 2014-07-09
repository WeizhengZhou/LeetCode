
public class DivideTwoIntegers {
	public int divide(int a, int b){
		if(b == 0) return Integer.MAX_VALUE;//should throw zeroDivisorException	
		int sign_a = (a<0)?-1:1;//record sign
		int sign_b = (b<0)?-1:1;	
		//a = -abs(a), b = -abs(b), in case of overflow of Integer.min_value
		//if convert both a and b to positive value, the Integer.min_value is difficult to deal with
		a = (a<0) ? a:-a;
		b = (b<0) ? b:-b;			
		int c = divide_helper(a,b);
		if(sign_a != sign_b)//correct c's sign
			return -c;
		else 
			return c;
	}
	public int divide_helper(int a, int b){
		
		if(a > b) return 0;
		//accumulate abs(x) until it is about to exceed a
		int c = 1;// a = c*b + r
		int x = b;		
		while( a-x <= x){//x+x>=a may lead overflow
			x = x + x;
			c = c + c;
		}
        return c + divide_helper(a-x,b); 
	}
	
//	public int divide(int a, int b){
//		if(b == 0) return Integer.MAX_VALUE;//should throw zeroDivisorException	
//		return helper(a,b);
//		
//	}
//	private int helper(int a, int b){
//     
//		int d = 0;
//		while(d<31 && b<<(d+1) < a)
//			d++;
//		   System.out.println("a = " + a + ", b = " + b + ", d = " + d);
//		return 1<<d + helper(a-b*(1<<d), b);
//	}
	
	public static void main(String[] args){
//		System.out.println(Integer.toBinaryString(1<<1));

		DivideTwoIntegers solution = new DivideTwoIntegers();
		System.out.println(solution.divide(20, 5));
//		int a = Integer.MIN_VALUE;
//		int b = Integer.MAX_VALUE;
//		System.out.println(solution.divide(a, b));
//		System.out.println(a/b);
		
	}

}
