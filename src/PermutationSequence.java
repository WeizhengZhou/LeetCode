
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int[] table = factorial(n);
		boolean[] mark = new boolean[n];
		StringBuilder sb = new StringBuilder();
		
		k--;//easier to handle, when n=3, k=0, result = 123
		for(int i=0;i<n;i++){	
			int rank = k/table[n-i-1];//rank of this digits in remaining 		
			for(int j=0;j<n;j++){		
				if(mark[j] == true)//if used 
					continue;
				else{//not used
					rank--;
					if(rank < 0){//find this digit
						mark[j] = true;//mark as used
						sb.append(j+1);//append result
						break;
					}
				}
			}
			k = k % table[n-i-1];//prepare next digit			
		}
		return sb.toString();
	}
	public int[] factorial(int n){
		int[] table = new int[n+1];
		table[0] = 1;
		table[1] = 1;
		for(int i=2;i<n+1;i++)
			table[i] = i * table[i-1];
		return table;
	}
	public static void main(String[] args){
		PermutationSequence solution = new PermutationSequence();
		System.out.println(solution.getPermutation(3, 4));	
	}
}
