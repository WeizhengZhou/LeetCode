import java.util.*;
public class SumRoottoLeafNumbers {
	public class Result{
		int sum = 0;
		List<Integer> digits = null;
		public String toString(){
			return "sum = " + sum + ", digits = " + digits;
		}
		
	}
	
	public int sumNumbers(TreeNode root) {
		return aux(root).sum;
	}
	
	private Result aux(TreeNode root){
		if(root == null){
			Result result =  new Result();
			result.sum = 0;
			List<Integer> digits = new LinkedList<>();
			result.digits = digits; 
			return result;
		}
				
		Result leftResult = aux(root.left);
		Result rightResult = aux(root.right);
		
		List<Integer> rootDigits = new LinkedList<>();		
		if(root.left == null && root.right == null)//leaf node is the first digit
			rootDigits.add(0);
		//each left and right possible number, root can be its last digits
		for(Integer d : leftResult.digits)
			rootDigits.add(d + 1);	
		for(Integer d : rightResult.digits)
			rootDigits.add(d + 1);
		
		
		int rootSum = leftResult.sum + rightResult.sum;
		for(Integer d : rootDigits){			
				rootSum += root.val * Math.pow(10, d);
		}
		
		Result rootResult = new Result();
		rootResult.sum = rootSum;
		rootResult.digits = rootDigits;
		
//		System.out.println("root = " + root.val + ", result = " + rootResult);
		return rootResult;			
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		SumRoottoLeafNumbers s = new SumRoottoLeafNumbers();
		System.out.println(s.sumNumbers(root));
		
	}

}
