

import java.util.*;
public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] A){
		 List<List<Integer>> lists = new ArrayList<List<Integer>>();
		 if(A ==  null || A.length < 3) return lists;
		 //systematically add results, to avoid duplicates 
		 Arrays.sort(A);
		 
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(int i=0;i<A.length;i++){
			 map.put(-A[i], i);
		 }
		 for(int i=0;i<A.length-2;i++){
			 for(int j=i+1; j<A.length-1;j++){
				 int twoSum = A[i] + A[j];
				 if(map.containsKey(twoSum) && map.get(twoSum) > j){
					 List<Integer> list = new ArrayList<>();
					 list.add(A[i]);
					 list.add(A[j]);
					 list.add(-twoSum);
						 lists.add(list);
										
				 }				 
				 //skip duplicates, since A[i] unchanged, 
				 //if A[j+1] == A[j], we will have a duplicate result 
				 while(j < A.length -1 && A[j] == A[j+1])
					 j++;
			 }	
			//also to avoid duplicates 
			 while(i < A.length -1 && A[i] == A[i+1])
				 i++;			 
		 }
	 return lists;
		 	        
	 }
    public static void main(String[] args){
//    	int[] num = new int[]{-1,-1, 0, 1, 2,2};
//    	int[] num = new int[]{-12,12,-5,-4,-12,11,9,-11,13,1,12,-1,8,1,-9,-11,-13,-4,10,-9,-6,-11,1,-15,-3,4,0,-15,3,6,-4,7,3,-2,10,-2,-6,4,2,-7,12,-1,7,6,7,6,2,10,-13,-3,8,-12,2,-5,-12,6,6,-5,6,-5,-14,9,9,-4,-8,4,2,-7,-15,-11,-7,12,-4,8,-5,-12,-1,12,5,1,-5,-1,5,12,9,0,3,0,3,-14,2,-4,2,-4,0,1,7,-13,9,-1,13,-12,-11,-6,11,-1,-10,-5,-3,10,3,7,-6,-15,-4,10,1,14,-12};
    	int[] num = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//    	int[] num = new int[]{-2,0,1,1,2};
//    	int[] num = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
    	Arrays.sort(num);
    	System.out.println(Arrays.toString(num));
    	ThreeSum solution = new ThreeSum();
    	solution.print(solution.threeSum(num));
    	
    	
    }
    private void print(List<List<Integer>> lists){
    	for(List<Integer> list : lists){
    		for(Integer i:list){
    			System.out.print(i + ", ");
    		}
    		System.out.println();
    	}
    }
    
}
