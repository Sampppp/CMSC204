import java.io.IOException;
import java.util.ArrayList;

public class CourseDBStructure implements CourseDBStructureInterface{

	private Node[] array;
	private int size;
	private final double LOAD_FACTOR = 1.5;
	
	public Node[] getArray() {
		return array;
	}
	
	CourseDBStructure(int a){//specified array size
		//int num = (int) (a / LOAD_FACTOR);
		int num = a;
		num = fkpt(num);
		array = new Node[fkptp(num)];
		size = array.length;
	}
	
	CourseDBStructure(String b, int a){//testing
		array = new Node[a];
		size = array.length;
	}
	
	
	public int fkpt(int num) {//finds closest last 4k+3 number
		int k = (num - 3) / 4;
		return (4 * k) + 3;
	}
	
	public int fkptp(int num) {//finds closest next 4k+3 prime from a 4k+3
		for (int i = 2; i <= num / 2; ++i) {
		      if (num % i == 0) {
		    	  return fkptp(num + 4);
		      }
		}
		return num;
	}
	
	
	@Override
	public void add(CourseDBElement element) {
		int hash = element.getCRN() % size;//finds index for array
		Node select = array[hash];
		
		if(select == null) {//adds if space is empty
			array[hash] = new Node(element);
			return;
		}

		while(select.next != null) {
			if(select.data.compareTo(element) == 0)//if element is already there
				return;
			select = select.next;
		}
		select.next = new Node(select, element, null);//appends if node exists
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		int hash = crn % size;
		Node select = array[hash];
		while(select.data.getCRN() != crn) {
			if(select.next == null)
				throw new IOException();
			
			select = select.next;
		} 
		return select.data;
	}

	@Override 
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<>();
		Node select;
		for(int i = 0; i < size; i++) {
			select = array[i];
			while(select != null) {
				list.add(String.format("Course:%s CRN:%d Credits:%d Instructor:%s Room:%s", 
						select.data.getID(),
						select.data.getCRN(),
						select.data.getCredits(),
						select.data.getInstructor(),
						select.data.getRoomNum()));
				select = select.next;
			}
		}
		return list;
	}

	@Override
	public int getTableSize() {
		return size;
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
		
		Node(Node a, CourseDBElement b, Node c){
			prev = a;
			data = b;
			next = c;
		}
	}
}
