import java.util.Arrays;


public class PermutationSequence {
	public String getPermutation(int n, int k) {
		boolean[] mark = new boolean[n];
		int[] table = factorial(n);
		StringBuilder sb = new StringBuilder();
		
		k--;
		while(n > 0){
//			System.out.println("n = " + n + ", k = " + k);
			int rank = k / table[n-1];
			
			for(int i=0;i<mark.length;i++){
				if(mark[i] == false){
					rank --;
				}
				if(rank < 0){
					sb.append(i+1);
					mark[i] = true;
					break;
				}
					
			}
//			System.out.println(Arrays.toString(mark) + ", " + sb.toString());
			k = k % table[n-1];
			n = n-1;
		}
		return sb.toString();
	        
	}
	public int[] factorial(int n){
		int[] table = new int[n+1];
		table[0] = 1;
		table[1] = 1;
		for(int i=2;i<n+1;i++){
			table[i] = i * table[i-1];
		}
		return table;
	}
	public static void main(String[] args){
		PermutationSequence solution = new PermutationSequence();
		System.out.println(solution.getPermutation(4, 4*3*2));
		
	}

}
