import java.util.ArrayList;
public class Town implements Comparable<Town>{

	private ArrayList<Town> adj = new ArrayList<>();
	private String name;
	
	Town(String a){
		name = a;
	}
	
	Town(Town a){
		name = a.getName();
		for(int i = 0; i < a.getArrayList().size(); i++) {
			adj.add(a.getArrayList().get(i));
		}
	}
	
	public void addAdj(Town b) {
		adj.add(b);
	}
	
	public void setAdj(ArrayList<Town> b) {
		for(int i = 0; i < b.size(); i++) {
			adj.add(b.get(i));
		}
	}
	public ArrayList<Town> getArrayList(){
		return adj;
	}
	
	public void setName(String a) {
		name = a;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Town o) {
		if(name == o.getName())
			return 1;
		else
			return 0;
	}

}
