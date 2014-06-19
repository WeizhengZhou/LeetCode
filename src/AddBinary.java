
public class AddBinary {
	public String addBinary(String a, String b) {
		if(a == null) return b;
		if(b == null) return a;
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while(i >= 0 || j >=0){
			System.out.println("i = " + i + ", j = " +j);
			if(i >= 0){
				carry += Integer.parseInt(a.substring(i,i+1));
				i--;
			}
			if(j >= 0){
				carry += Integer.parseInt(b.substring(j,j+1));
				j--;
			}
			sb.append(carry%2);
			carry /=2;
			System.out.println(sb);
			
		}
		
		if(carry == 1)
			sb.append(1);
		return sb.reverse().toString();

	}
	public static void main(String[] args){
		String a = "11110011001011110111110001010000111110011110101100011111010010001000001101111001000111";
		String b = "111001011011111010001001111001100000101010000101100010101100010010010011011000";
		AddBinary solution = new AddBinary();
		System.out.println(solution.addBinary(a,b));
	}
}
