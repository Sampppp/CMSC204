import java.io.IOException;
import java.util.ArrayList;

public class CourseDBStructure implements CourseDBStructureInterface{

	private Node[] array;
	private int size = array.length;
	private final double LOAD_FACTOR = 1.5;
	
	
	
	CourseDBStructure(int a){//specified array size
		int num = (int) (a / LOAD_FACTOR);
		num = num / 4 + 3;
		array = new Node[fkptp(num)];
	}
	
	
	CourseDBStructure(int a, String b){//testing
		this(a);
	}
	
	public int fkptp(int num) {//finds next 4k+3 prime from a 4k+3
		for (int i = 2; i <= num / 2; ++i) {
		      if (num % i == 0) {
		    	  return fkptp(num + 4);
		      }
		}
		return num;
	}
	
	
	@Override
	public void add(CourseDBElement element) {
		for(int i = 0; i < size; i++) {
			
				
		}
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	//node subclass
	protected class Node{
		protected CourseDBElement data;
		protected Node prev, next;
		
		//constructors
		Node(){
			data = null;
			prev = null;
			next = null;
		}
		
		Node(CourseDBElement a){
			data = a;
			prev = null;
			next = null;
		}
		
		Node(CourseDBElement a, Node b, Node c){
			data = a;
			prev = b;
			next = c;
		}
	}
}
