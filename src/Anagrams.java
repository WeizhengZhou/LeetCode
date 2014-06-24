import java.util.*;
public class Anagrams {
	/**
	 * if sort all strs, if str[i]'s sorted version appeared more than once, 
	 * it has an anagrams in the strs 
	 * @param strs
	 * @return
	 */
	public List<String> anagrams(String[] strs) {
		List<String> list = new ArrayList<>();
		if(strs == null) return list;
		Map<String, Integer> map = new HashMap<>();
		
		for(String s: strs){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			if(!map.containsKey(key)){
				map.put(key, 1);
			}
			else{
				map.put(key, map.get(key) + 1);
			}
		}
		for(String s : strs){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			if(map.get(key) > 1){
				list.add(s);
			}
		}
		return list;
	}
	public static void main(String[] args){
		String[] strs = new String[]{"abc", "bca", "bac", "bbb", "bbca", "abcb"};
		Anagrams s = new Anagrams();
		List<String> list = s.anagrams(strs);
		System.out.println(list);
		
	}
}
