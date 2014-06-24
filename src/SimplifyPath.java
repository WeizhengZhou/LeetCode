import java.util.*;
public class SimplifyPath {

	public String simplifyPath(String path) {
		List<String> list = new LinkedList<>();
		int cur = 0;
		while(cur < path.length()){
			int start = nextNonSlash(path, cur);//next non slash character
			int end = nextSlash(path, start+1);//next slash character
//			System.out.println("start " + start + ",  end = " + end);
			if(start >= path.length())
				break;
			String t = path.substring(start,end);
			
			if(!t.equals(".") && ! t.equals(".."))
				list.add(t);
			else if(t.equals("..") && list.size() > 0){
				list.remove(list.size()-1);
			}
			cur = end+1;				
		}			
	
		if(list.size() == 0)
			return "/";
			
		StringBuilder sb = new StringBuilder();
		for(String s : list){
			sb.append("/" + s);
		}
		return sb.toString();
	}
	private int nextNonSlash(String path, int i){
		while(i < path.length() && path.substring(i,i+1).equals("/"))
			i++;
		return i;		
	}
	
	private int nextSlash(String path, int i){
		while(i < path.length() && !path.substring(i,i+1).equals("/"))
			i++;
		return i;	
	}
	
	
	public static void main(String[] args){
//		String path = "/home/user/../abc/c/./d";
//		String path = "/home/user/../abc/./";
//		String path = "/home//foo/";
//		String path = "/";
		String path = "/../.././././";
		SimplifyPath solu = new SimplifyPath();
//		System.out.println(solu.nextName(path, 14));
		
		String res = solu.simplifyPath(path);
		System.out.println(res);
	}

}
