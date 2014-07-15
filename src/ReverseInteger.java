
public class ReverseInteger {
//	public int reverse_long(int x){
//		int sign = (x > 0) ? 1:-1;
//		x = x * sign;		
//		int res = 0;
//		while(x > 0){
//			res = res * 10 + x % 10;
//			x = x / 10;
//		}
//		return res*sign;
//	}	
	public int reverse(int x){
		int res = 0;
		while(x != 0){//not x>0 or x<0
			if(res > 0 && Integer.MAX_VALUE/10 < res || (Integer.MAX_VALUE/10 == res && x%10 > 7))
				return -1;//positive overflow
			if(res < 0 && Integer.MIN_VALUE/10 > res || (Integer.MIN_VALUE/10 == res && x%10 < -8))
				return -1;//negative overflow
			
			res = res * 10 + x % 10;//multiply res by 10, then add the lsd of x			
			System.out.println("x = " + x + ", res = " + res);
			x = x / 10;//remove the least significant digit of x			
		}
		return res;
	}
	public static void main(String[] args){
		int a = -12345;
		a = Integer.MIN_VALUE;
		System.out.println(Integer.MAX_VALUE);
		ReverseInteger solution = new ReverseInteger();
		System.out.println(solution.reverse(a));
	}

}
