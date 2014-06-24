
public class EditDistance {
	public int minDistance(String s1, String s2) {
		if(s1 == null || s2 == null) return 0;
		int n1 = s1.length();
		int n2 = s2.length();
		//min number of operations to match s1.substring(0,i) and s2.substring(0,j)
		int[][] L = new int[n1+1][n2+1];
		//empty s1 string need i operation to match s2.substring(0,j)
		for(int i=0;i<=n1;i++)
			L[i][0] = i;
		for(int j=0;j<=n2;j++)
			L[0][j] = j;
		for(int i=1;i<=n1;i++){
			for(int j=1;j<=n2;j++){
				int min = Math.min(L[i-1][j], L[i][j-1]);//delete and insert
				min = Math.min(min, L[i-1][j-1]);//replace
				L[i][j] = min + 1;//plut one operation
				
				//no operation
				if(s1.substring(i-1,i).equals(s2.substring(j-1,j)))
					L[i][j] = Math.min(L[i][j], L[i-1][j-1]);			
			}
		}
//		print(L);
		return L[n1][n2];
	}
	public static void main(String[] args){
		String s1 = "AC";
		String s2 = "";
		EditDistance solu = new EditDistance();
		System.out.println(solu.minDistance(s1, s2));
	}
	private void print(int[][] L){
		for(int[] row : L){
			for(int e:row){
				System.out.print(e + ", ");
			}
			System.out.println();
		}
	}

}
