
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
		//set the connected towns to be adj
		a.addAdj(b);
		b.addAdj(b);
	}
	
	public Road(Town a, Town b, String c) {
		this(a, b, 1, c);
	}
	
	public Road(Road a) {
		name = a.getName();
		distance = a.getDistance(); 
		
		//add the endpoints
		end1 = new Town(a.getEnd1());
		end2 = new Town(a.getEnd2());
	}
	
	public void setName(String a) {
		name = a;
	}
	public String getName() {
		return name;
	}
	public void setDistance(int a) {
		distance = a;
	}
	public int getDistance() {
		return distance;
	}
	
	public void setEnd1(Town a) {
		end1 = a;
	}
	public Town getEnd1() {
		return end1;
	}
	public void setEnd2(Town a) {
		end2 = a;
	}
	public Town getEnd2() {
		return end2;
	}
	
	@Override
	public int compareTo(Road o) {
		if(name == o.getName())
			return 1;
		else
			return 0;
	}

}
