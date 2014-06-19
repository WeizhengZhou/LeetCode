import java.util.*;
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if(digits == null) return new int[0];
		int n = digits.length;
		int[] res = new int[n+1];
		int carry = 1;
		for(int i=n-1;i>=0;i--){
			int v = carry + digits[i];
			res[i+1] = v%10;
			carry = v/10;
		}
		if(carry == 1){
			res[0] = 1;
			return res;
		}
		else{
			return Arrays.copyOfRange(res, 1, n+1);
		}
	}
	public static void main(String[] args){
		int[] digits = new int[]{1,2};
		PlusOne  solution = new PlusOne();
		System.out.println(Arrays.toString(solution.plusOne(digits)));
	}

}
