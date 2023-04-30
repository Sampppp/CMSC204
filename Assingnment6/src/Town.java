public class Town implements Comparable<Town>{

	private String name;
	
	Town(String a){//constructor
		name = a;
	}
	
	Town(Town a){//copy constructor
		name = a.getName();
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Town o) {//if names are equal
		return name.compareTo(o.getName());
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object a) {//if all fields are equal
		Town b = (Town)a;
		return name.equals(b.getName()); 
	}
}
