import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TownGraphManager implements TownGraphManagerInterface{

	Graph graph = new Graph();
	
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		addTown(town1);
		addTown(town2);
		return (graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null);
	}

	@Override
	public String getRoad(String town1, String town2) {
		if(containsTown(town1) && containsTown(town2))
			return graph.getEdge(new Town(town1), new Town(town2)).getName();
		return null;//does not contain towns thus no road
	}

	@Override
	public boolean addTown(String v) {
		if(containsTown(v))
			return true;
		return graph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
			return graph.getVertex(new Town(name));
	}

	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		if(containsTown(town1) && containsTown(town2))
			return (graph.getEdge(new Town(town1), new Town(town2)) != null);
		return false;
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> a = new ArrayList<>();
		Road[] roads = (Road[]) graph.edgeSet().toArray();
		
		for(int i = 0; i < roads.length; i++) {
			a.add(roads[i].getName());
		}
		
		//need to sort///////////////////////////////////////////////
		return a;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		if(containsTown(town1) && containsTown(town2) && graph.containsEdge(new Town(town1), new Town(town2))) {
			Road a = new Road(graph.getEdge(new Town(town1), new Town(town2)));
			return (graph.removeEdge(a.getEnd1(), a.getEnd2(), a.getDistance(), a.getName()) != null);
		}
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		if(containsTown(v))
			return graph.removeVertex(new Town(v));
		return false;
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> a = new ArrayList<>();
		Town[] towns = (Town[]) graph.vertexSet().toArray();
		
		for(int i = 0; i < towns.length; i++) {
			a.add(towns[i].getName());
		}
		
		//need to sort///////////////////////////////////////////////
		return a;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void populateTownGraph(File selectedFile) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
