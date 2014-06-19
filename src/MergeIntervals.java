import java.util.*;


public class MergeIntervals {
	public class Interval{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		public String toString(){
			return "[" + start + ", " + end + "]";  
		}
	}
	public void sortOnStart(List<Interval> list){
		
		Comparator<Interval> comparator = new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start - b.start;
			}
		};
		Collections.sort(list, comparator);
		
	}
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null) return new ArrayList<Interval>();

		sortOnStart(intervals);
		List<Interval> res = new ArrayList<>();
		
		int l = 0;
		int r = 0;
		while(l < intervals.size()){
			int start = intervals.get(l).start;
			int end = intervals.get(l).end;
			r = l + 1;
			while(r < intervals.size()){
				if(intervals.get(r).start > end)
					break;
				
				if(intervals.get(r).end > end)
					end = intervals.get(r).end;
				r++;
			}
			res.add(new Interval(start,end));
			l = r;
		}
		
		return res;
		
	}
	public static void main(String[] args){
		
	
		MergeIntervals s = new MergeIntervals();
		
		MergeIntervals.Interval a = s.new Interval(1,3) ;			
		MergeIntervals.Interval b = s.new Interval(2,6);
		MergeIntervals.Interval c = s.new Interval(8,10);
		MergeIntervals.Interval d = s.new Interval(15,18);
		
		List<MergeIntervals.Interval> list = new ArrayList<>();
		
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
//		s.sortOnStart(list);
		List<Interval> res = s.merge(list);
				
		System.out.println(res);
		
//		System.out.println(comparator.compare(a, b));
		
	}


}
