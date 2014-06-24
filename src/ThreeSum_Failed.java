

import java.util.*;
public class ThreeSum_Failed {
	 public List<List<Integer>> ThreeSum_Failed(int[] A) {
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 
		 List<Integer> preList = new ArrayList<>();
		 if(A == null || A.length < 3) return res;
		 Arrays.sort(A);
		 int l = 0;
		 int r = A.length - 1;
		 while(l+1 < r){
//			 System.out.println("l = " + l + ", r = " + r);		
			 if(A[l] + A[r] < 0){
				 //seek higher
				 if(A[l] + A[r-1] + A[r] <0)
					 l++;				 
				 else if(A[l] + A[r-1] + A[r] > 0){
					 r--;
				 }
				 else{
					 List<Integer> list = new ArrayList<>();
					 list.add(A[l]);
					 list.add(A[r-1]);
					 list.add(A[r]);
					 if(! list.equals(preList)){
						 res.add(list);
						 preList = list;
					 }					
					l++;			 		 
				 }			
			 }
			 else{
				 if(A[l] + A[l+1] +A[r] > 0){
					 r--;
				 }
				 else if(A[l] + A[l+1] +A[r] < 0){
					 l++;
					 
				 }
				 else{
					 List<Integer> list = new ArrayList<>();
					 list.add(A[l]);
					 list.add(A[l+1]);
					 list.add(A[r]);
					 if(! list.equals(preList)){
						 res.add(list);
						 preList = list;
					 }			
					r--;					 
				 }			 
			 }
			
		 }
		 return res;	        
	 }
    public static void main(String[] args){
//    	int[] num = new int[]{-1, 0, 1, 2, -1, -4};
//    	int[] num = new int[]{-12,12,-5,-4,-12,11,9,-11,13,1,12,-1,8,1,-9,-11,-13,-4,10,-9,-6,-11,1,-15,-3,4,0,-15,3,6,-4,7,3,-2,10,-2,-6,4,2,-7,12,-1,7,6,7,6,2,10,-13,-3,8,-12,2,-5,-12,6,6,-5,6,-5,-14,9,9,-4,-8,4,2,-7,-15,-11,-7,12,-4,8,-5,-12,-1,12,5,1,-5,-1,5,12,9,0,3,0,3,-14,2,-4,2,-4,0,1,7,-13,9,-1,13,-12,-11,-6,11,-1,-10,-5,-3,10,3,7,-6,-15,-4,10,1,14,-12};
//    	int[] num = new int[]{-1,0,1} ;
//    	int[] num = new int[]{-2,0,1,1,2};
    	int[] num = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
    	Arrays.sort(num);
    	System.out.println(Arrays.toString(num));
    	ThreeSum_Failed solution = new ThreeSum_Failed();
    	solution.print(solution.ThreeSum_Failed(num));
    	
    	
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
