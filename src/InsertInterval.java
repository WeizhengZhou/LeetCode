import java.util.ArrayList;
import java.util.List;




public class InsertInterval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		public String toString(){
			return "[" + start + ", " + end + "]";  
		}
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {				
		if(intervals == null){
			List<Interval> res = new ArrayList<Interval>();
			res.add(newInterval);
			return res;
		}		
		List<Interval> before = new ArrayList<Interval>();
		List<Interval> after = new ArrayList<Interval>();
		
		int start = newInterval.start;
		int end = newInterval.end;
		
		for(int i=0;i<intervals.size();i++){
			Interval cur = intervals.get(i);
			int curStart = cur.start;
			int curEnd = cur.end;
			if(curEnd < start){
				before.add(cur);
			}
			else if(curStart > end){
				after.add(cur);				
			}
			else{
				start = Math.min(start, curStart);
				end = Math.max(end, curEnd);				
			}			
		}
		before.add(new Interval(start,end));
		before.addAll(after);
		return before;		
	}
	public static void main(String[] args){
		InsertInterval s = new InsertInterval();

		InsertInterval.Interval a = s.new Interval(1,3) ;			
		InsertInterval.Interval b = s.new Interval(2,6);
		InsertInterval.Interval c = s.new Interval(8,10);
		InsertInterval.Interval d = s.new Interval(15,18);

		List<InsertInterval.Interval> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		
		List<Interval> res = s.insert(list, s.new Interval(19,20));
		System.out.println(res);
		
	}

}
