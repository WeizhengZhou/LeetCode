
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null) return false;
	
		int n1 = s1.length();
		int n2 = s2.length();
		int n3 = s3.length();
		if(n1+n2 != n3) return false;
		
		boolean[][] L = new boolean[n1+1][n2+1];
		
		for(int i=1;i<=n1;i++){
			if(s1.substring(0,i).equals(s3.substring(0,i)))
					L[i][0] = true;
		}
	
		for(int j=1;j<=n2;j++){
			if(s2.substring(0,j).equals(s3.substring(0,j)))
				L[0][j] = true;
		}
		L[0][0] = true;
		for(int i=1;i<=n1;i++){
			for(int j=1;j<=n2;j++){
				String t1 = s1.substring(i-1,i);
				String t2 = s2.substring(j-1,j);
				String t3 = s3.substring(i+j-1,i+j);
//				System.out.println("i = " + i + ", j = " + j + ", t1 = " + t1 + ", t2 = " + t2 + ", t3 = " + t3 );
				L[i][j] = false;			
				if(t3.equals(t1))
					L[i][j] = L[i][j] || L[i-1][j];
				
				if(t3.equals(t2))
					L[i][j] = L[i][j] || L[i][j-1];		
			}
		}
//		print(L);
		return L[n1][n2];
			
	}

	public static void main(String[] args){
			String s1 = "aabcc";
			String s2 = "dbbca";
			String s3 = "aadbbcbcac";
//			s1 = "";
//			s2 = "b";
//			s3 = "b";
			
			InterleavingString solu = new InterleavingString();
			System.out.println(solu.isInterleave(s1, s2, s3));
	}
	private void print(boolean[][] L){
		for(boolean[] row : L){
			for(boolean e:row){
				System.out.print(e + ", ");
			}
			System.out.println();
		}
	}

}
