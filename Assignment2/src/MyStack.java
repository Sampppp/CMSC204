import java.util.ArrayList;
import exceptions.*;
public class MyStack<T> implements StackInterface{

	private ArrayList<T> stack;
	private int top = -1;
	private int size = 1;


	
	
	
	public MyStack(int size) {
		if (size < 1)
			throw new IllegalArgumentException("Stack size must be positive");
		this.size = size;
		stack = new ArrayList<>(size);
	}
	
	public MyStack() {
		stack = new ArrayList<>(size);
	}
	
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top + 1 == size;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(top == -1)
			throw new StackUnderflowException();
		T data = stack.get(top);
		stack.set(top, null);
		top--;
		return data;
	}

	@Override
	public T top() throws StackUnderflowException {
		if(top == -1)
			throw new StackUnderflowException();
		return stack.get(top);
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean push(Object e) throws StackOverflowException {
		if(isFull())
			throw new StackOverflowException();
		stack.add((T) e);
		top++;
		return true;
	}

	@Override
	public String toString() {
		return toString("");
	}
	
	@Override
	public String toString(String delimiter) {
		String temp = "";
		for(int i = 0; i < stack.size(); i++) {
			if(stack.get(i) != null) {
				temp += stack.get(i);
				if(i != stack.size() - 1)
					temp += delimiter;
			}	
		}
		return temp;
	}

	@Override
	public void fill(ArrayList list){
        ArrayList<T> copy = new ArrayList<>();
    	for(int i = 0; i < list.size(); i++)
    		copy.add((T) list.get(i));
    	
    	for(int i = 0; i < copy.size(); i++){
            try {
                push(copy.get(i));
            }
            catch(StackOverflowException e){
                e.printStackTrace();
            }
        }
    }

	

}
