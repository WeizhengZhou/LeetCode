import java.util.*;


public class MaxPointsOnALine {
	public class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	      public String toString(){
	    	  return "["+ x + ", " + y + "]";
	      }
	}
	public class Line {
		double slope = 0.;
		double intercept = 0.;
		public Line(double s, double i){
			this.slope = s;
			this.intercept = i;
		}
		@Override
		public boolean equals(Object otherObject){
			if(otherObject == null) return false;
			if(this == otherObject) return true;
			if(!(otherObject instanceof Line)) return false;
			Line other = (Line) otherObject;
			return (this.slope == other.slope) && (this.intercept == other.intercept);
		}
		@Override 
		public int 	hashCode(){
			return Objects.hash(slope,intercept);
		}
		public String toString(){
			String s = String.format("%.2f", slope); 
			String i = String.format("%.2f", intercept); 
			return "[" + s + ", " + i + "]";
		}
	}
	
    public int maxPoints(Point[] points) {
    	if(points == null) return 0;
    	if(points.length <= 2) return points.length; 	
    	Map<Line,Integer> map = new HashMap<>();
    	for(int i=0;i<points.length;i++){
    		for(int j=i+1;j<points.length;j++){
    			double slope = slope(points[i],points[j]);
    			double intercept = intercept(points[i],points[j]);
    			Line line = new Line(slope,intercept);
    			if(!map.containsKey(line))
    				map.put(line, 1);
    			else{
//    				System.out.println("Update");
    				map.put(line, map.get(line) + 1 );
    			}  
    			System.out.println("i = " + i + ", j = " + j + ": " + map);
    		}
    	}    	
    	return findMaxPoints(map, points);        
    }
    private int findMaxPoints(Map<Line,Integer> map, Point[] points){
    	int max = 0;
    	Line maxLine = null;
    	Set<Line> list = map.keySet();
    	for(Line l:list){
    		if(map.get(l) > max){
    			max = map.get(l);
    			maxLine = l;
    		}  		
    	}
    	System.out.println("line = " + maxLine);
    	int count = 0;
    	double slope = maxLine.slope;
    	double intercept = maxLine.intercept;
    	if(Double.isInfinite(slope)){
    		for(Point p:points){
        		if(p.x == intercept)
        			count++;    
    		}
    	}
    	else{
    		for(Point p:points){
        		if(Math.abs((slope * p.x + intercept - p.y)) < 1E-10){//1E-20 does not pass OJ
        			count++;  
        			System.out.println(p);
        		}   		
    		}
    	}	
    	return count;
    }
    private double slope(Point a, Point b){
    	if(a.x == b.x) return Double.POSITIVE_INFINITY;
    	else{
    		double x = (b.x - a.x);
    		double y = (b.y - a.y);
    		return y/x;
    		
    	}
    }
    private double intercept(Point a, Point b){
    	if(a.x == b.x) return a.x;
    	else{
    		double x = (b.x - a.x);
    		double y = (b.x * a.y - a.x * b.y);
    		return y/x;
    	}
    }
    public void test(){
//    	Point[] points = new Point[3];
//    	for(int i=0;i<points.length;i++){
//			points[i] = new Point(i,i);
//		}
    	
//    	Point[] points = new Point[4];
//    	points[0] = new Point(1,1);
//    	points[1] = new Point(1,1);
//    	points[2] = new Point(2,2);
//    	points[3] = new Point(2,2);
    	
//    	Point[] points = new Point[3];
//    	points[0] = new Point(1,0);
//    	points[1] = new Point(1,-1);
//    	points[2] = new Point(1,1);
    	
    	Point[] points = makePoints();

		System.out.println(maxPoints(points));
    }
  
     
	public static void main(String[] args){
		MaxPointsOnALine s = new MaxPointsOnALine();	
		s.test();		
	}
	//how to determine doubles are equal
	private Point[] makePoints(){
		Point[] points = new Point[21];
		points[0] = new Point(0,9);
		points[1] = new Point(138,429);
		points[2] = new Point(115,359);
		points[3] = new Point (115,359);
		points[4] = new Point (-30,-102);
		points[5] = new Point (230,709);
		points[6] = new Point (-150,-686);
		points[7] = new Point (-135,-613);
		points[8] = new Point (-60,-248);
		points[9] = new Point (-161,-481);
		points[10] = new Point (207,639);
		points[11] = new Point (23,79);
		points[12] = new Point(-230,-691);
		points[13] = new Point (-115,-341);
		points[14] = new Point (92,289);
		points[15] = new Point(60,336);
		points[16] = new Point(-105,-467);
		points[17] = new Point(135,701);
		points[18] = new Point(-90,-394);
		points[19] = new Point(-184,-551);
		points[20] = new Point(150,774);
		return points;		
	}
}
