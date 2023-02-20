import java.util.ArrayList;
import exceptions.*;

public class MyQueue<T> implements QueueInterface{
	
	private ArrayList<T> queue;
	private int front;
	private int back;
	private int size = 1;
	
	public MyQueue(int size) {
		if (size < 1)
			throw new IllegalArgumentException("Stack size must be positive");
		this.size = size;
		queue = new ArrayList<>(size);
		front = 0;
		back = 0;
	}
	
	public MyQueue() {
		queue = new ArrayList<>(size);
	}
			
	
	@Override
	public boolean isEmpty() {
		return front == back;
	}

	@Override
	public boolean isFull() {
		return size == back;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty())
			throw new QueueUnderflowException();
		T temp = queue.get(front);
		queue.remove(front);
		back--;
		return temp;
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if(isFull())
			throw new QueueOverflowException();
		queue.add(back, (T) e);
		back++;
		return true;
	}

	@Override
	public String toString() {
		return toString("");
	}
	
	@Override
	public String toString(String delimiter) {
		String temp = "";
		for(int i = 0; i < size; i++) {
			temp += queue.get(i) + delimiter;
		}
		return temp;
	}

	@Override
	public void fill(ArrayList list) {
		for(int i = 0; i < list.size(); i++) {
			queue.add((T) list.get(i));
			back++;
		}
	}
	
}
