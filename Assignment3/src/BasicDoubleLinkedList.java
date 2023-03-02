import java.util.Iterator;
import java.util.ListIterator;

public class BasicDoubleLinkedList<T> implements Iterable<T>{

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	public class Node{
		T data;
		Node prev, next;
	}
	public class DoubleLinkedListIterator  implements ListIterator<T>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		
		
		
		
		
		
		
		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		public void remove()  throws UnsupportedOperationException{
			throw new UnsupportedOperationException();			
		}

		public void set(Object e)  throws UnsupportedOperationException{
			throw new UnsupportedOperationException();			
		}

		public void add(Object e)  throws UnsupportedOperationException{
			throw new UnsupportedOperationException();			
		}		
	}
	
	
	
	
	
	
	
}
