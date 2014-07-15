
public class SingleNumberII {	
	public int singleNumber(int[] A) {
		//ones' and twos' dth digit records the occurrence of "1" in all numbers in A
		//if one[d] = 1, two[d] = 0, total number of "1" occurred on digit d is 1
		//if one[d] = 0, two[d] = 1, total number of "1" occurred on digit d is 2
		//if one[d] = 0, two[d] = 0, total number of "1" occurred on digit d is 0 or 3
		int ones = 0;
		int twos = 0;
		for(int i=0;i<A.length;i++){
			twos = twos | (ones & A[i]);//01^11 =10, the 0th digit carry 1 into twos
			ones = ones ^ A[i];//for example, 01^11 = 10, the 0th digit, has its information in twos
			//if both ones and twos are 1, the occurrence is three, we should clear it
			int mask = ~(ones & twos);
			ones &= mask;
			twos &= mask;
		}
		return ones;
	}
	public static void main(String[] arsgs){
		int[] A = new int[]{2,2,2,3,3,1};
		SingleNumberII s = new SingleNumberII();
		s.singleNumber(A);
		
	}
//	public class QBit{
//		int one;
//		int two;
//		public QBit(){
//			one = 0;
//			two = 0;
//		}
//		public void plusOne(int x){
//			two = two | (one & x);
//			one = one ^ x;
//		}
//	}
}
