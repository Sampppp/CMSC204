/*
 * Class: CMSC204 
 * Instructor: David Kuijt
 * Description: Graph of a town
 * Due: 04/30/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
			return (graph.containsEdge(new Town(town1), new Town(town2)));
		return false;
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> a = new ArrayList<>();
		Road[] roads = (Road[]) graph.edgeSet().toArray(new Road[0]);
		
		for(int i = 0; i < roads.length; i++) {
			a.add(roads[i].getName());
		}
		
		Collections.sort(a);
		return a;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		if(graph.containsEdge(new Town(town1), new Town(town2))) {
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
		Town[] towns = (Town[]) graph.vertexSet().toArray(new Town[0]);
		
		for(int i = 0; i < towns.length; i++) {
			a.add(towns[i].getName());
		}
		
		Collections.sort(a);
		return a;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		if(containsTown(town1) && containsTown(town2))
			return graph.shortestPath(getTown(town1), getTown(town2));
		return null;
	}

	public void populateTownGraph(File selectedFile) throws IOException, FileNotFoundException {
		Scanner a = new Scanner(selectedFile);
		String temp;
		String town1;
		String town2;
		int weight;
		String roadName;
		while(a.hasNextLine()) {
			temp = a.nextLine();//I-94,282;Chicago;Detroit
			roadName = temp.split(",")[0];//[I-94][282;Chicago;Detroit]
			weight = Integer.parseInt(temp.split(",")[1].split(";")[0]);//[I-94][282][Chicago][Detroit]
			town1 = temp.split(",")[1].split(";")[1];
			town2 = temp.split(",")[1].split(";")[2];
			
			addRoad(town1, town2, weight, roadName);
		}
		a.close();
	}

}
