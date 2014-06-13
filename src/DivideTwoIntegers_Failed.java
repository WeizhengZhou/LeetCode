
public class DivideTwoIntegers_Failed {
	public int divide(int a, int b){
		//Special case 1, zero divider
		if(b == 0) 
			return Integer.MAX_VALUE;
		//Special case 2, a == b
		if(a == b) return 1;	
		
		//
		if(a == 0) return 0;
		if(b == 1) return a;
		if(b == -1) return -a;
		
		//Special case 3, boundary
		if(b == Integer.MIN_VALUE) 
			return 0; 
		if(a == Integer.MIN_VALUE && b == Integer.MAX_VALUE) 
			return -1;
		
		if(a == Integer.MIN_VALUE && b != Integer.MAX_VALUE) 
			a = a+1;

		
		//-----normal cases
		//record sign
		int sign_a = (a<0)?-1:1;
		int sign_b = (b<0)?-1:1;
	
		a = (a<0) ? -a:a;
		b = (b<0) ? -b:b;
		
		if(a < b) return 0;
		int c = divide_helper(a,b);
		if(sign_a != sign_b)
			return -c;
		else 
			return c;
	}
	public int divide_helper(int a, int b){
		if(a < b) return 0;
		int c = 1;
		int x = b;
		
		while(x <= a-x){
//			System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", x = " + x);
			x = x + x;
			c = c + c;
		}
//		System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", x = " + x);
        return c + divide_helper(a-x,b); 
	}
	public static void main(String[] args){
		
		System.out.println(-1010369383 / (-2147483648));
//		System.out.println(-2/4);
//		System.out.println(1 /1);
		DivideTwoIntegers solution = new DivideTwoIntegers();
//		System.out.println(solution.divide(-1010369383, -2147483648));
		System.out.println(solution.divide(Integer.MIN_VALUE, 1));
		
		
	
	}

}
