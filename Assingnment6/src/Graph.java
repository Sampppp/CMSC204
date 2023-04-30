import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{
	//Override class for indexOf method
	public class MyArrayList<T> extends ArrayList<T>{
		@Override
		public int indexOf(Object o) {
			for(int i = 0; i < size(); i++) {
				if(get(i).equals(o))
					return i;
			}
			return -1;
		}
	}	
	
	private MyArrayList<Town> towns = new MyArrayList<>();
	private MyArrayList<Road> roads = new MyArrayList<>();
	private Road[][] adjMatrix;
	private final int DEFAULT_SIZE = 20;
	private int size;
	
	private int maxWeight = 0;
	Graph(){
		adjMatrix = new Road[DEFAULT_SIZE][DEFAULT_SIZE];
		size = DEFAULT_SIZE;
	}
	
	Graph(int a){
		adjMatrix = new Road[a][a];
		size = a;
	}
	
	public void regenerateGraph() {
		int x, y;
		
		for(int i = 0; i < roads.size(); i ++) {
			x = towns.indexOf(roads.get(i).getEnd2());
			y = towns.indexOf(roads.get(i).getEnd1());
			adjMatrix[x][y] = roads.get(i);
			adjMatrix[y][x] = roads.get(i);
		}
	}
	
	public Town getVertex(Town a) {
		if(containsVertex(a))
			return(towns.get(towns.indexOf(a)));
		return null;
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(towns.indexOf(sourceVertex) == -1 || towns.indexOf(destinationVertex) == -1)//checks if inputed towns are in towns list
			return null;
		return adjMatrix[towns.indexOf(sourceVertex)][towns.indexOf(destinationVertex)];
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		roads.add(new Road(sourceVertex, destinationVertex, weight, description));
		regenerateGraph();
		return roads.get(roads.size() - 1);//returns the last added road
	}

	@Override
	public boolean addVertex(Town v) {
		towns.add(v);//potential bug with needing larger matrix
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		return (getEdge(sourceVertex, destinationVertex) != null);
	}

	@Override
	public boolean containsVertex(Town v) {
		return (towns.indexOf(v) != -1);
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

		for(int i = 0; i < size; i++) {
			if(adjMatrix[towns.indexOf(vertex)][i] != null)
				set.add(adjMatrix[towns.indexOf(vertex)][i]);
		}
		return set;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(containsEdge(sourceVertex, destinationVertex)) {
			roads.remove(roads.indexOf(getEdge(sourceVertex, destinationVertex)));//finds edge from ends, finds index of edge in list, removes
			regenerateGraph();
			return new Road(sourceVertex, destinationVertex, weight, description);//idk why it asks for a Road return
		}		
		return null;//does not contain edge
	}

	@Override
	public boolean removeVertex(Town v) {
		if(containsVertex(v)) {
			towns.remove(towns.indexOf(v));//town gets removed from list
			
			Set<Road> set = new HashSet<>(edgesOf(v));//gets edge set of town
			Iterator<Road> it = set.iterator();
			
			while(it.hasNext()) {//iterates through set
				roads.remove(roads.indexOf(it.next()));//removes the connected roads
			}
			regenerateGraph();
			return true;
		}
		return false;//does not contain vertex		
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

	@Override//fix me @ !!!!mjtyfghjuyyughjktyfcvgrtyfdgfrtydgrtydfgrtyudftyufrgtyufgh
	public void dijkstraShortestPath(Town sourceVertex) {
		int[] distance = new int[towns.size()];
		boolean[] pathSet = new boolean[towns.size()];
		
		for(int i = 0; i < roads.size(); i++) {//finds max weight
			if(i == 0) {
				maxWeight = roads.get(i).getDistance();
				continue;
			}
			if(roads.get(i).getDistance() > maxWeight)
				maxWeight = roads.get(i).getDistance();
		}
		for(int i = 0; i < distance.length; i++) {
			distance[i] = maxWeight;
		}
		
		distance[towns.indexOf(sourceVertex)] = 0;//where path starts
		
		for(int i = 0; i < towns.size() - 1; i++) {
			int u = minDistance(distance, pathSet);
			pathSet[u] = true;
			
			for(int j = 0; j < towns.size(); j++) {
				if(pathSet[j] && adjMatrix[u][j] != null && distance[u] != maxWeight && distance[u] + adjMatrix[u][j].getDistance() < distance[j])
					distance[j] = distance[u] + adjMatrix[u][j].getDistance();
			}
		}
	}
	
	int minDistance(int[] distance, boolean[] pathSet) {
		int min = maxWeight;
		int min_index = -1;
		
		for(int i = 0; i < towns.size(); i++) {
			if(pathSet[i] == false && distance[i] <= min) {
				min = distance[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
	
}
