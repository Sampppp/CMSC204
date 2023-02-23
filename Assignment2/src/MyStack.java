import java.util.ArrayList;
import exceptions.*;
public class MyStack<T> implements StackInterface<T>{

	private T[] stack;
	private int top;
	private boolean integrity;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public MyStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public MyStack(int size) {
		integrity = false;
		checkCapacity(size);
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[size];
		stack = tempStack;
		top = -1;
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
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top + 1 == stack.length;
	}

	@Override
	public T pop() throws StackUnderflowException {
		checkIntegrity();
		if(isEmpty())
			throw new StackUnderflowException();
		T data = stack[top];
		stack[top] = null;
		top--;
		return data;
	}

	@Override
	public T top() throws StackUnderflowException {
		checkIntegrity();
		if(isEmpty())
			throw new StackUnderflowException();
		return stack[top];
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		checkIntegrity();
		if(isFull())
			throw new StackOverflowException();
		stack[++top] = e;
		return true;
	}

	@Override
	public String toString() {
		return toString("");
	}
	
	@Override
	public String toString(String delimiter) {
		String temp = "";
		for(int i = 0; i < stack.length; i++) {
			if(stack[i] != null) {
				if(i != 0)
					temp += delimiter;
				temp += stack[i];
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
                push(copy.get(i));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

	

}
