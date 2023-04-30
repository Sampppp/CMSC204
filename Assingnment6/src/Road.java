
public class Road implements Comparable<Road>{

	private String name;
	private int distance;
	
	private Town end1;
	private Town end2;
	
	public Road(Town a, Town b, int d, String c){
		name = c;
		distance = d; 
		
		//add the endpoints
		end1 = new Town(a);
		end2 = new Town(b);
	}
	
	public Road(Town a, Town b, String c) {
		this(a, b, 1, c);
	}
	
	public Road(Road a) {//copy constructor
		this(a.getEnd1(), a.getEnd2(), a.getDistance(), a.getName());
	}

	public boolean contains(Town a) {
		if(end1.equals(a) || end2.equals(a))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %d, %s", end1.getName(), end2.getName(), distance, name);
	}
	
	public String getName() {
		return name;
	}
	
	public Town getEnd1() {
		return end1;
	}
	
	public Town getEnd2() {
		return end2;
	}
	
	@Override
	public int compareTo(Road o) {//if names are equal
		return name.compareTo(o.getName());
	}
	
	public int getDistance() {
		return distance;
	}
	
	@Override
	public boolean equals(Object a) {//if all fields are equal
		Road b = (Road)a;
		return (compareTo(b) == 0 && contains(b.getEnd1()) && contains(b.getEnd2()));
	}
}
