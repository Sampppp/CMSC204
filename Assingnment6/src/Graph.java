import java.util.ArrayList;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{

	private Town[] towns;
	private int[][] adjMatrix;
	private int size;
	
	Graph(Town[] a){
		size = a.length;
		towns = new Town[size];
		for(int i = 0; i < size; i++) {
			towns[i] = a[i];
		}
		
		adjMatrix = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			Town selected = towns[i]; //selected town
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < selected.getArrayList().size(); j++) {
					//selected town's adjacent towns compared to origional town array
					if(selected.getArrayList().get(k).compareTo(towns[j]) == 1)
						adjMatrix[i][j] = 1;
					else 
						adjMatrix[i][j] = 0;
				}
			}
		}
	}
	
	
	
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return null;
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
