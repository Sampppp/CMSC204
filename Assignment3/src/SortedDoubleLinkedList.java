import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator<T> comparator;
	
	SortedDoubleLinkedList(Comparator<T> comparableObject){
		comparator = comparableObject;
	}
	
	
	public void add(T data) {
		Node select = head;
		Node newNode;
		
		for(int i = 0; i < size; i++) {
			if(comparator.compare(select.data, data) >= 0) {
				if(i == 0) {
					newNode = new Node(data, null, select);
					head = newNode;
				}
				else {
					newNode = new Node(data, select.prev, select); //data is added into new node
					select.prev.next = newNode;
				}
				select.prev = newNode;
				size++;
				return;
			}
			select = select.next;
		}
		super.addToEnd(data);
	}
	
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");	}
	
	@Override
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");	}
	
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	@Override
	public Node remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
}
