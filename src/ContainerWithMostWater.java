
public class ContainerWithMostWater {
//	public int maxArea(int[] height) {
//		int maxArea = 0;
//		for(int i=0;i<height.length-1;i++){
//			for(int j=i+1;j<height.length;j++){
//				int curArea = (j-i) * Math.min(height[i], height[j]);
//				maxArea = Math.max(curArea,maxArea);
//
//			}
//		}
//		return maxArea;
//	}
	public int maxArea(int[] height){
		int maxArea = 0;
		int l = 0;
		int r = height.length -1;
		while(l<r){
			int shortBar = Math.min(height[l], height[r]);
			int curArea = (r-l) * shortBar;
			maxArea = Math.max(curArea,maxArea);
//			System.out.println("l=" + l + ", r=" + r + ", shortBar = " + shortBar +", maxArea = " + maxArea);
			if(shortBar == height[l])
				l++;
			else
				r--;
		}
		return maxArea;
		
	}
	public static void main(String[] args){
		int[] height = new int[]{1,5,4,1};
		ContainerWithMostWater solution = new ContainerWithMostWater();
		System.out.println(solution.maxArea(height));
	}

}
