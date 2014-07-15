import java.util.*;
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
    	if(num == null) return new ArrayList<List<Integer>>();
    	
    	Arrays.sort(num);
    	int[] res = new int[num.length]; 
    	
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	helper(num,0,res,0,lists);
    	print(lists);
    	return lists;
        
    }
    public void helper(int[] num, int i, int[] res, int j, List<List<Integer>> lists){
    	if(i == num.length){
    		List<Integer> list = new ArrayList<>();
    		for(int k=0;k<j;k++){
    			list.add(res[k]);
    		}
    		lists.add(list);
    		return;
    	}
    	//count how many num[i]'s duplicates
    	int count = 0;
    	int k = i;
    	while(k < num.length && num[i] == num[k]){
    		count++;
    		k++;
    	}
    	//include 0 num[i]
    	helper(num,k,res,j,lists);
    	//include 1 to count num[i]
    	for(int t=1;t<=count;t++){
    		res[j+t-1] = num[i]; 		
    		helper(num,k,res,j+t,lists);
    	}
    }
    public static void main(String[] args){
    	int[] num = new int[]{1,2,3,3};
    	SubsetsII s = new SubsetsII();
    	s.subsetsWithDup(num);
    	
    	
    }
    private void print(List<List<Integer>> lists){
    	for(List<Integer> list:lists){
    		for(Integer i:list){
    			System.out.print(i + ", ");
    		}
    		System.out.println();
    	}
    }

}
