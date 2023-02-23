import java.util.ArrayList;
import exceptions.*;

public class MyQueue<T> implements QueueInterface<T>{
	
	private T[] queue;
	private int front;
	private int back;
	private boolean integrity;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public MyQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public MyQueue(int size) {
		integrity = false;
		checkCapacity(size);
		
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[])new Object[size + 1];
		queue = tempQueue;
		front = 0;
		back = size;
		integrity = true;
	}
	
	private void checkIntegrity() {
		if(!integrity)
			throw new SecurityException();
	}
	
	private void checkCapacity(int size) {
		if(size > MAX_CAPACITY || size < 1)
			throw new IllegalStateException();
	}	
	
	@Override
	public boolean isEmpty() {
		return front == (back + 1) % queue.length;
	}

	@Override
	public boolean isFull() {
		return front == ( back + 2) % queue.length;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		checkIntegrity();
		if(isEmpty())
			throw new QueueUnderflowException();
		T temp = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		return temp;
	}

	@Override
	public int size() {
		return back + 1;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		checkIntegrity();
		if(isFull())
			throw new QueueOverflowException();
		back = (back + 1) % queue.length;
		queue[back] = e;
		return true;
	}

	@Override
	public String toString() {
		return toString("");
	}
	
	@Override
	public String toString(String delimiter) {
		String temp = "";
		for(int i = 0; i < queue.length; i++) {
			if(queue[i] != null) {
				if(i != 0)
					temp += delimiter;
				temp += queue[i];
			}	
		}
		return temp;
	}

	@Override
	public void fill(ArrayList<T> list){
        ArrayList<T> copy = new ArrayList<>();
    	for(int i = 0; i < list.size(); i++)
    		copy.add(list.get(i));
    	
    	for(int i = 0; i < copy.size(); i++){
            try {
            	enqueue(copy.get(i));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
