
public class ValidNumber_Test {
	public boolean isNumber(String s){
		if(s == null) return false;
		s.toLowerCase();//in case of 'E'
		s = s.trim();//trim leading and trailing spaces
		if(s.length() == 0) return false;//s only contains spaces
				
		if(s.startsWith("e") || s.endsWith("e")) return false;

		String[] aDotbEc = s.split("e");
		if(aDotbEc.length == 0 || aDotbEc.length > 2)
			return false;				
		
		String[] aDotb = aDotbEc[0].split("\\.");		
		if(aDotb.length == 0 || aDotb.length > 2)//
			return false;
		
		boolean isValid= true;
		isValid = isValid && isInteger(aDotb[0]);
		if(aDotb.length == 2)
			isValid = isValid && isInteger(aDotb[1]);
		if(aDotbEc.length == 2)
			isValid = isValid && isInteger(aDotbEc[1]);
				
		for(String a: aDotbEc)
			System.out.println(a);
		for(String a: aDotb)
			System.out.println(a);

		
		return true;
		
	}
	private boolean isInteger(String s){
		int i= 0;
		if(s.charAt(i) == '+' || s.charAt(i) == '-')
			i++;
		while(i < s.length()){
			if(s.charAt(i) > '9' || s.charAt(i) < '0')
				return false;
			i++;
		}
		return true;		
	}
	public static void main(String[] args){
		String s = "1.0";
		s = "1.e2";
//		s = "1e";
//		s = "e";
//		s = ". 1";
//		s = ".";
//		s = " ";
//		s = "1 ";
//		s = "0e";
//		s = "-0.3e+3";
//		s = "00ee+3";
//		s = "0";
//		s = " 0 ";
		s = " .003e+02";
		
		ValidNumber_Test  solu = new  ValidNumber_Test();
		System.out.println(solu.isNumber(s));	
	}
}
