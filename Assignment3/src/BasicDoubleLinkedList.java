/*
 * Class: CMSC204 
 * Instructor: David Kuijt
 * Description: Implementation of a sorted and unsorted linked list
 * Due: 03/05/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/
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
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	protected Node remove(T targetData, Comparator<T> comparator){
		Node select = head;
		
		for(int i = 0; i < size; i++) {
			if(comparator.compare(select.data, targetData) == 0) {			
				//if selected node is the only one in the list
				if(size == 1) {
					head = null;
					tail = null;
				}
				//if selected node is at the head of the list
				else if(i == 0){
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
		size--;
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
		size--;
		return temp;
	}
	
	protected ArrayList<T> toArrayList(){
		ArrayList<T> arrayList = new ArrayList<>();
		DoubleLinkedListIterator iter = new DoubleLinkedListIterator();
		
		while(iter.hasNext()) {
			arrayList.add(iter.next());
		}
		return arrayList;
	}
	
	
	
	
	
	
	protected class Node{
		protected T data;
		protected Node prev, next;
		
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
		Node nextNode, prevNode;
		
		DoubleLinkedListIterator(){
			nextNode = head;
		}
		
		@Override
		public boolean hasNext() {
			return (nextNode != null);
		}

		@Override
		public T next() throws NoSuchElementException{
			if(!hasNext())
				throw new NoSuchElementException();
			prevNode = nextNode;
			nextNode = nextNode.next;
			return prevNode.data;
		}

		@Override
		public boolean hasPrevious() {
			return (prevNode != null);
		}

		@Override
		public T previous() throws NoSuchElementException{
			if(!hasPrevious())
				throw new NoSuchElementException();
			nextNode = prevNode;
			prevNode = prevNode.prev;
			
			return nextNode.data;
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
