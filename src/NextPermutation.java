
import java.util.*;
public class NextPermutation {
	public void nextPermutation(int[] num){
		if(num == null || num.length < 2) return;
		for(int i=num.length-1;i>=0;i--){
			
			int min = smallestSuccOnRight(num,i);
			System.out.println("i = " + i + ", min = " + min)  ;
			//find the smallest elements in num[p+1,num.length-1], 
			//which is larger than num[p]
			if(min != i){
				//find such element, swap it with i
				swap(num,i,min);
				System.out.println(Arrays.toString(num));
				//sort the rest of array 
				Arrays.sort(num, i+1, num.length);
				break;
			}
			else if(i==0 && min == i){
				//case like [4,3,2,1]
				Arrays.sort(num);
				break;			
			}					
		}
		
	}
	private void swap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	/**
	 * find the smallest elements within num[p+1,num.length-1],
	 * which is larger than num[p]
	 * @param num array to be found
	 * @param p index 
	 * @return
	 */
	public int smallestSuccOnRight(int[] num, int p){
		int min = p;
		for(int i=p+1;i<num.length;i++){
			if(num[i] > num[p]){
				if(min == p)
					min = i;
				else if(num[i] < num[min])
					min = i;
			}
		}
		return min;	
	}
	public static void main(String[] args){
		int[] num = new int[]{1,3,2};
		NextPermutation solution = new NextPermutation();
		solution.nextPermutation(num);
		System.out.println(Arrays.toString(num));
		
	}

}
