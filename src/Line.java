import java.util.HashMap;
import java.util.Objects;



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
		return "[" + slope + ", " + intercept + "]";
	}
	public static void main(String[] args){
		HashMap<Line,Integer> map = new HashMap<>();
		Line line = new Line(1,1);
		
		map.put(line, 1);
		System.out.println(map);
		
		map.put(line,map.get(line) + 1);
		System.out.println(map);
		
		System.out.println(map.containsKey(line));
		
	}
}
