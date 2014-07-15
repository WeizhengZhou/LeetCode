import java.util.*;
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		if(s == null || s.length() < 4)
			return new ArrayList<String>();
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder("");
		helper(s, 0, 0, sb, res);
		System.out.println(res);
		return res;
		
	}
	private void helper(String s, int index, int d, StringBuilder sb, List<String> res){
		int nDigitsRemain = s.length() - index;

		if( nDigitsRemain >  3*(4-d)) return;
		if( nDigitsRemain < (4-d)) return;
		if(d == 4){
			res.add(sb.toString());	
			return;
		}	
        int length = Math.min(3, nDigitsRemain);	
		for(int i=0;i<length;i++){				
			int t = Integer.parseInt(s.substring(index,index+i+1));
			if(t>=0 && t<=255){
				StringBuilder sbn = new StringBuilder(sb);
				sbn.append(t);
				if(d < 3) sbn.append(".");//does not append . for last one				
				helper(s,index+i+1,d+1,sbn,res);				
			}
			if(t == 0)//fisrt digit is zero, cannot parse two or three digits
				break;
		}	
	}
	public static void main(String[] args){
		String s = "25525511135";
		RestoreIPAddresses solution = new RestoreIPAddresses();
		solution.restoreIpAddresses(s);
		
	}

}
