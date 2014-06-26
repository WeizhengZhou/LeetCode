
public class ValidNumber {
	public boolean isNumber(String s){
		if(s == null || s.length() == 0) return false;
		
		int n = s.length();
		if(n == 1){
			if(isOneDigitNum(s))
				return true;
			else return false;
		}
		int i = 0;
		
		//skip all spaces
		while(i < n && s.substring(i,i+1).equals(" "))
			i++;				
					
		if(i == n) return false;//s is all spaces
		
		if(s.substring(i,i+1).equals("+") || s.substring(i,i+1).equals("-"))//skip sign
			i++;
		if(s.substring(i,i+1).equals("0")){//start with zero
			//if it is last one or next character is not a dot
			if(i == n-1)
				return true;
			else{//zero followed by dot, number, e, or empty are all ok
				//although I think 00 is not a valid number. 
				String next = s.substring(i+1,i+2);
				if(!(isDot(next) || isOneDigitNum(next) ||isE(next) || next.equals(" ")))
					return false;
			}			
		}	
		int nNumBefE = 0;
		int nNumAftE = 0;
		int nDots = 0;
		int nEs = 0;	
		
		while(i < n && !s.substring(i,i+1).equals(" ")){//until found a space,
//			System.out.println("i = " + i);
			String  cur = s.substring(i,i+1);	
			if( ! (isDot(cur) || isOneDigitNum(cur) || isE(cur)) )//not a dot, number or e
				return false;
			else if(isDot(cur)){
				nDots++;
				if(nDots > 1) return false;//more than one dot
				if(nEs == 1) return false;//dots after e, not valid
			}
			else if(isE(cur)){			
				nEs++;
				if(nEs > 1) return false;//more than one e
				if(i+1 < n && (s.substring(i+1,i+2).equals("+") || s.substring(i+1,i+2).equals("-")))//skip sign after e
					i++;	
			}
			else if(isOneDigitNum(cur)){
				if(nEs == 0)
					nNumBefE++;
				else
					nNumAftE++;				
			}
			else{
				return false;
			}
			i++;			
		}	
	
		if(nNumBefE+nNumAftE == 0) return false;//not seen a number 
		if(nEs == 1 && (nNumBefE == 0 || nNumAftE == 0)) return false;//e should have number before and after
		while(i < n && s.substring(i,i+1).equals(" ")){
			i++;
		}		
		if(i < n) return false;
		else return true;
	}
	private boolean isOneDigitNum(String s){
		if(s.length() == 1 && s.compareTo("9") <= 0 && s.compareTo("0") >= 0)
			return true;
		else 
			return false;		
	}
	private boolean isDot(String s){
		if(s.equals("."))
			return true;
		else 
			return false;
	}
	private boolean isE(String s){
		if(s.equals("e") || s.equals("E"))
			return true;
		else 
			return false;
	}
	public static void main(String[] args){
		String s = "1.0";
		s = "1.";
		s = "e9";
//		s = "e";
//		s = ". 1";
//		s = ".";
//		s = " ";
//		s = "1 ";
		s = "0e";
		s = "-0.3e+3";
//		s = "00ee+3";
		s = "0";
		s = " 0 ";
		s = " .003e+02";
		
		ValidNumber  solu = new  ValidNumber();
		System.out.println(solu.isNumber(s));	
	}
}
