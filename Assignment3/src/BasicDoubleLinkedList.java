import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{

	
	
	protected Node head, tail;
	protected int size;
	
	BasicDoubleLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	protected void addToEnd(T data) {
		if(size == 0) {
			tail = new Node(data);
			head = tail;
		}
		else {
			tail.next = new Node(data);
			tail.next.prev = tail;
			tail = tail.next;
		}
		size++;
	}
	
	protected void addToFront(T data) {
		if(size == 0) {
			head = new Node(data);
			tail = head;
		}
		else {
			head.prev = new Node(data);
			head.prev.next = head;
			head = head.prev;
		}
		size++;
	}
	
	protected T getFirst() {
		return head.data;
	}
	
	protected T getLast() {
		return tail.data;
	}
	
	protected int getSize() {
		return size;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	protected Node remove(T targetData, Comparator<T> comparator){
		Node select = head;
		
		for(int i = 0; i < size; i++) {
			if(comparator.compare(select.data, targetData) == 0) {			
				//if selected node is at the head of the list
				if(i == 0){
					head = select.next;
					select.next.prev = null;
				}
				//if selected node is that the tail of the list
				else if(i == size - 1) {
					tail = select.prev;
					select.prev.next = null;
				}
				//for all other cases
				else {
					//disconnect prev and next from surrounding nodes
					select.next.prev = select.prev;
					select.prev.next = select.next;
				}
				//decrease the size	
				size--;
				//return the selected node
				return select;
			}
			
			select = select.next;
		}
		return null;
	}
	
	public T retrieveFirstElement() {
		T temp = null;
		if(size > 0) {
			temp = head.data;
			if(size != 1) {
				head.next.prev = null;
				head = head.next;
				
			}
			else {
				head = null;
				tail = null;
			}
				
		}
		return temp;
	}
	
	public T retrieveLastElement() {
		T temp = null;
		if(size > 0) {
			temp = tail.data;
			if(size != 1) {
				tail.prev.next = null;
				tail = tail.prev;				
			}
			else {
				head = null;
				tail = null;
			}
		}
		return temp;
	}
	
	protected ArrayList<T> toArrayList(){
		return null;
	}
	
	
	
	
	
	
	protected class Node{
		private T data;
		private Node prev, next;
		
		//constructors
		Node(){
			data = null;
			prev = null;
			next = null;
		}
		
		Node(T a){
			data = a;
			prev = null;
			next = null;
		}
		
		Node(T a, Node b, Node c){
			data = a;
			prev = b;
			next = c;
		}
	}
	
	protected class DoubleLinkedListIterator implements ListIterator<T>{
		Node select;
		
		DoubleLinkedListIterator(){
			select = head;
		}
		
		@Override
		public boolean hasNext() {
			return (next() != null);
		}

		@Override
		public T next() throws NoSuchElementException{
			if(select.next == null)
				throw new NoSuchElementException();
			
			select = select.next;
			return select.prev.data;
		}

		@Override
		public boolean hasPrevious() {
			return (previous() != null);
		}

		@Override
		public T previous() throws NoSuchElementException{
			if(select.prev == null)
				throw new NoSuchElementException();
			
			select = select.prev;
			return select.next.data;
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