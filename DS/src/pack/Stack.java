package pack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
List<T> stack= new ArrayList<T>();  	
	public boolean isEmpty(){
		return stack.size()==0;
	}
	
	public void push(T t)
	{
		stack.add(t);
	}
	
	public T pop()
	{
		return stack.remove(stack.size()-1);
	}
	
}
