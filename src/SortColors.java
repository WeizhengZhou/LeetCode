import java.util.Arrays;


public class SortColors {
	public void sortColors(int[] A) {
		int zero = 0;
		int one = 0;
		int two = 0;
		for(int i =0;i<A.length;i++){
			if(A[i] == 0)
				zero++;
			else if(A[i] == 1)
				one ++;
			else
				two++;
		}
		for(int i=0;i<A.length;i++){
			if(zero-- > 0)
				A[i] = 0;
			else if(one-- > 0)
				A[i] = 1;
			else
				A[i] = 2;
		}
	}
	public void sortColors_2(int[] A){
		int l = -1; 
		int r = A.length;
		int k = 0;
		while(k < r){
			if(A[k] == 0){
				swap(A,++l,k);
				k++;				
			}
			else if(A[k] == 2){
				swap(A,k,--r);
			}
			else
				k++;				
		}
	}
	private void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		
	}
	
	public static void main(String[] args){
		int[] A = new int[]{0,1,0,2,1,2,0};
		SortColors solution = new SortColors();
		solution.sortColors_2(A);
		System.out.println(Arrays.toString(A));
	}

}
