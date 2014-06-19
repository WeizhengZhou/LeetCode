
public class SqrtX {
	public int sqrt(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return search(0,n,n);
	}
	public int search(int l, int r, int n){
		if(l > r) return -1;
		int m = (l+r)/2;		
		if( (m+1) <= n/(m+1)) 
			return search(m+1,r,n);
		else if(m > n/m)
			return search(l,m-1,n);		
		else 
			return m;			
	}
	public static void main(String[] args){
		int n = Integer.MAX_VALUE;
		n = 14;
		n = 16;
		SqrtX s = new SqrtX();
		System.out.println(s.sqrt(n));
		System.out.println((int) Math.sqrt(n));
	}
}
