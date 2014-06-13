

import java.util.*;
public class ThreeSum {
//	   public List<List<Integer>> threeSum(int[] num) {
//	    	Arrays.sort(num);
//	    	HashMap<Integer,Integer> map = new HashMap<>();   	
//	    	for(int k=0;k<num.length;k++){
//	    		map.put(-num[k], k);
//	    	}
//	    	List<List<Integer>> lists = new ArrayList<List<Integer>>();       
//	    	for(int i=0;i<num.length-1;i++){
//	    		for(int j=i+1;j<num.length;j++){
//	    			if(map.containsKey(num[i] + num[j]) 
//	    					&& map.get(num[i]+num[j]) != i
//	    					&&map.get(num[i]+num[j]) != j){ 	
//	      				List<Integer> list = new ArrayList<Integer>();
//	      				list.add(num[i]);
//	      				list.add(num[j]);
//	      				list.add(-(num[i]+num[j]));
//	      				Collections.sort(list);
////	      				if(!lists.contains(list))
//	      					lists.add(list);     				
//	    			} 				
//	    		}
//	    	}
////	    	print(lists);
//	    	return lists;
//	    }
    public List<List<Integer>> threeSum(int[] num) {
    	if(num == null || num.length < 3) return null;
    	Arrays.sort(num);	
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	List<Integer> preList = new ArrayList<Integer>();
    	
    	for(int i=0;i<num.length-2;i++){
    		for(int j=i+1;j<num.length-1;j++){
    			int twoSum = num[i] + num[j];
    			int k = num.length -1;
    			while(k > j && num[k] >= -twoSum){
    				if(num[k] == -twoSum){
	      				List<Integer> curList = new ArrayList<Integer>();
	      				curList.add(num[i]);
	      				curList.add(num[j]);
	      				curList.add(num[k]);
	      				if(!curList.equals(preList)){
	      					lists.add(curList);
	      					preList = curList;
	      					
	      				}
//	      				System.out.println("i = " + i + ", j=" + j + ", k=" + k);
    				}
    				k--;
    			}			 				
    		}
    	}
    	return lists;
    }
    public static void main(String[] args){
    	int[] num = new int[]{-1, 0, 1, 2, -1, -4};
//    	int[] num = new int[]{-12,12,-5,-4,-12,11,9,-11,13,1,12,-1,8,1,-9,-11,-13,-4,10,-9,-6,-11,1,-15,-3,4,0,-15,3,6,-4,7,3,-2,10,-2,-6,4,2,-7,12,-1,7,6,7,6,2,10,-13,-3,8,-12,2,-5,-12,6,6,-5,6,-5,-14,9,9,-4,-8,4,2,-7,-15,-11,-7,12,-4,8,-5,-12,-1,12,5,1,-5,-1,5,12,9,0,3,0,3,-14,2,-4,2,-4,0,1,7,-13,9,-1,13,-12,-11,-6,11,-1,-10,-5,-3,10,3,7,-6,-15,-4,10,1,14,-12};
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
