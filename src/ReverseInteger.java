
public class ReverseInteger {
	public int reverse(int x){
		int sign = (x > 0) ? 1:-1;
		x = x * sign;
		
		int res = 0;
		while(x > 0){
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return res*sign;
	}
	public static void main(String[] args){
		int a = -12345;
		ReverseInteger solution = new ReverseInteger();
		
		System.out.println(solution.reverse(a));
	}

}
