import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{

	private ArrayList<Town> towns = new ArrayList<>();
	private ArrayList<Road> roads = new ArrayList<>();
	private Road[][] adjMatrix;
	private final int DEFAULT_SIZE = 20;
	
	Graph(){
		adjMatrix = new Road[DEFAULT_SIZE][DEFAULT_SIZE];
	}
	
	Graph(Town[] a, Road[] b){
		adjMatrix = new Road[a.length + 10][a.length + 10];
		for(int i = 0; i < a.length; i++) {
			towns.add(a[i]);
		}
		for(int i = 0; i < b.length; i++) {
			roads.add(b[i]);
		}
		
		regenerateGraph();
	}
	
	public void regenerateGraph() {
		for(int i = 0; i < roads.size(); i++) {
			for(int j = 0; j < towns.size(); j++) {
				if(roads.get(i).getEnd1().compareTo(towns.get(j)) == 1) {//looks for end1 match
					for(int k = 0; k < towns.size(); k++) {
						if(roads.get(i).getEnd2().compareTo(towns.get(k)) == 1) {//looks for end2 match
							adjMatrix[j][k] = roads.get(i);//end1 and end2 match
							break;
						}
					}
					break;
				}
			}
		}
	}
	
	public void enlargeMatrix() {
		Road[][] temp = new Road[adjMatrix.length + 10][adjMatrix.length + 10];
		
		for(int i = 0; i < adjMatrix.length; i++) {
			for(int j = 0; j < adjMatrix.length; j++) {
				temp[i][j] = new Road(adjMatrix[i][j]);
			}
		}
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for(int i = 0; i < towns.size(); i++) {
			if(sourceVertex.compareTo(towns.get(i)) == 1) {
				for(int j = 0; j < towns.size(); j++) {
					if(destinationVertex.compareTo(towns.get(j)) == 1) {
						return adjMatrix[i][j];
					}
				}
			}
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		roads.add(new Road(sourceVertex, destinationVertex, weight, description));
		regenerateGraph();
		return roads.get(roads.size());
	}

	@Override
	public boolean addVertex(Town v) {
		towns.add(v);
		if(towns.size() > adjMatrix.length) {
			enlargeMatrix();
		}
		regenerateGraph();
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(int i = 0; i < roads.size(); i ++) {
			if(roads.get(i).getEnd1().compareTo(sourceVertex) == 1 || roads.get(i).getEnd2().compareTo(sourceVertex) == 1) {
				for(int j = 0; j < roads.size(); j ++) {
					if(roads.get(j).getEnd1().compareTo(destinationVertex) == 1 || roads.get(j).getEnd2().compareTo(destinationVertex) == 1) {
						return true;
					}
				}
				break;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		for(int i = 0; i < towns.size(); i++) {
			if(towns.get(i).compareTo(v) == 1)
				return true;
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		Set<Road> set = new HashSet<>();
		for(int i = 0; i < roads.size(); i++) {
			set.add(roads.get(i));
		}
		return set;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> set = new HashSet<>();
		for(int i = 0; i < towns.size(); i++){
			if(towns.get(i).compareTo(vertex) == 1) {
				for(int j = 0; j < adjMatrix.length; j++) {
					if(adjMatrix[i][j] != null)
						set.add(adjMatrix[i][j]);
				}
				return set;
			}
		}
		return null;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		for(int i = 0; i < roads.size(); i++) {
			if(roads.get(i).compareTo(temp) == 1) {
				roads.remove(i);
				regenerateGraph();
			}
			return temp;
		}
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		for(int i = 0; i < towns.size(); i++) {//searches for town
			if(towns.get(i).compareTo(v) == 1) {//town found
				towns.remove(i);//town gets removed from list
				
				Set<Road> set = new HashSet<>(edgesOf(v));//gets edge set of town
				Iterator<Road> it = set.iterator();
				int j = 0;
				while(it.hasNext()) {//iterates through set
					if(roads.get(j).compareTo(it.next()) == 1) {
						roads.remove(j);//removes roads from list
						continue;
					}
					i++;
				}
				regenerateGraph();
				return true;
			}
		}
		return false;		
	}

	@Override
	public Set<Town> vertexSet() {
		Set<Town> set = new HashSet<>();
		for(int i = 0; i < towns.size(); i++) {
			set.add(towns.get(i));
		}
		return set;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}	
}
