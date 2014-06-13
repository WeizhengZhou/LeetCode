import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


public class MaxPointsOnALine {
	
    public int maxPoints(Point[] points) {
    	if(points == null || points.length <2) return 0;
    	
    	HashMap<Line,Integer> map = new HashMap<>();
    	for(int i=0;i<points.length;i++){
    		for(int j=i+1;j<points.length;j++){
    			double slope = slope(points[i],points[j]);
    			double intercept = intercept(points[i],points[j]);
    			Line line = new Line(slope,intercept);
    			if(!map.containsKey(line))
    				map.put(line, 1);
    			else{
    				System.out.println("Update");
    				map.put(line, map.get(line) +1 );
    			}  
    			System.out.println("i = " + i + ", j = " + j + ": " + map);
    		}
    	}
    	Collection<Integer> lineCounts = map.values();
    	return Collections.max(lineCounts);
        
    }
    private double slope(Point a, Point b){
    	if(a.x == b.x) return Double.POSITIVE_INFINITY;
    	else
    		return (b.y - a.y)/(b.x - a.x);
    }
    private double intercept(Point a, Point b){
    	if(a.x == b.x) return a.x;
    	else
    		return (b.x * a.y - a.x * b.y) / (b.x - a.x);
    }
    

    
	public static void main(String[] args){
		MaxPointsOnALine s = new MaxPointsOnALine();	
		Point[] points = new Point[5];
		for(int i=0;i<points.length;i++){
			points[i] = new Point(i,i);
		}
		System.out.println(s.maxPoints(points));
		
	}
}
