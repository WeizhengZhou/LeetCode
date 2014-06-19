/**
 * 
 * @author Weizheng
 *
 */
public class DivideTwoIntegers {

	public int divide(int a, int b){
		//shoule throw zeroDivisorException
		if(b == 0) return Integer.MAX_VALUE;		

		//record sign
		int sign_a = (a<0)?-1:1;
		int sign_b = (b<0)?-1:1;
	
		//a = -abs(a), b = -abs(b), in case of overflow of Integer.min_value
		//if convert both a and b to positive value, the Integer.min_value is diffcult to deal with
		a = (a<0) ? a:-a;
		b = (b<0) ? b:-b;
		
		//if (abs(a) < abs(b)) 
		if(a > b) return 0;
		
		int c = divide_helper(a,b);
		
		//correct c's sign
		if(sign_a != sign_b)
			return -c;
		else 
			return c;
	}
	public int divide_helper(int a, int b){
		//if (abs(a) < abs(b)) 
		if(a > b) return 0;
		
		//enlarge abs(x) until it is about to exceed a
		int c = 1;// a = c*b + remindar
		int x = b;
		
		while( a-x <= x){
//			System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", x = " + x);
			x = x + x;
			c = c + c;
		}

        return c + divide_helper(a-x,b); 
	}
	public static void main(String[] args){
		

		DivideTwoIntegers solution = new DivideTwoIntegers();
//		System.out.println(solution.divide(20, 5));
		int a = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE;
		System.out.println(solution.divide(a, b));
		System.out.println(a/b);
		
	}

}
