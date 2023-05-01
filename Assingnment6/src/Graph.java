import java.util.ArrayList;
import java.util.Collections;
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
	
	private int[] distance;
	private int[] prev;
	private boolean[] visited;
	
	Graph(){
		adjMatrix = new Road[DEFAULT_SIZE][DEFAULT_SIZE];
		size = DEFAULT_SIZE;
	}
	
	public void regenerateGraph() {
		adjMatrix = new Road[DEFAULT_SIZE][DEFAULT_SIZE];
		int x, y;
		
		for(int i = 0; i < roads.size(); i ++) {
			x = towns.indexOf(roads.get(i).getEnd2());
			y = towns.indexOf(roads.get(i).getEnd1());
			adjMatrix[x][y] = roads.get(i);
			adjMatrix[y][x] = roads.get(i);
		}
		size = adjMatrix.length;

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
		if(containsVertex(vertex)) {
			
			Set<Road> set = new HashSet<>();
			
			for(int i = 0; i < size; i++) {
				if(adjMatrix[towns.indexOf(vertex)][i] != null)
					set.add(adjMatrix[towns.indexOf(vertex)][i]);
			}
			return set;
		}
		return null;
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

			Set<Road> set = new HashSet<>(edgesOf(v));//gets edge set of town
			Iterator<Road> it = set.iterator();
			towns.remove(towns.indexOf(v));//town gets removed from list
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
		dijkstraShortestPath(sourceVertex);
		ArrayList<Integer> path = new ArrayList<>();
		
		int index = towns.indexOf(destinationVertex);
		
		while(index != towns.indexOf(sourceVertex)) {
			path.add(index);
			index = prev[index];
		}
		
		path.add(towns.indexOf(sourceVertex));
		Collections.reverse(path);
		
		ArrayList<String> realPath = new ArrayList<>();
		
		Town town1;
		Road road;
		Town town2;
		
		for(int i = 0; i < path.size() - 1; i++) {
			
			town1 = towns.get(path.get(i));
			road = adjMatrix[path.get(i)][path.get(i + 1)];
			town2 = towns.get(path.get(i + 1));

			if(road == null)
				return realPath;
	
			realPath.add(String.format("%s via %s to %s %d mi", town1.getName(), road.getName(), town2.getName(), road.getDistance()));
		}
		
		return realPath;
	}
	
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		distance = new int[towns.size()];
		visited = new boolean[towns.size()];
		prev = new int[towns.size()];
		
		for(int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		distance[towns.indexOf(sourceVertex)] = 0;//where path starts
		
		
		for(int i = 0; i < towns.size() - 1; i++) {
			int u = minDistance(distance, visited);
			visited[u] = true;
			
			for(int j = 0; j < towns.size(); j++) {
				if(!visited[j] && adjMatrix[u][j] != null && (distance[u] + adjMatrix[u][j].getDistance() < distance[j])) {
					distance[j] = distance[u] + adjMatrix[u][j].getDistance();
					prev[j] = u;
				}
					
			}
		}
	}
	
	int minDistance(int[] distance, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int i = 0; i < towns.size(); i++) {
			if(!visited[i] && distance[i] < min) {
				min = distance[i];
				min_index = i;
			}
		}
		return min_index;
	}
}
