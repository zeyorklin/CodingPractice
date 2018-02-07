package stackAndQueuePractice;
import java.util.Stack;

public class MyQueue<T> { //T means generic types
	Stack<T> newStack, oldStack;
	
	public MyQueue() {
		newStack = new Stack<T>();
		oldStack = new Stack<T>();
	}
	
	public void add (T value)
	{
		newStack.push(value);
	}
	
	public void shiftStack()
	{
		if(oldStack.isEmpty())
		{
			while(!newStack.isEmpty())
			{
				oldStack.push(newStack.pop());
			}
		}
	}
	
	public T peek()
	{
		shiftStack();
		return oldStack.pop();
	}
	
	public void remove()
	{
		shiftStack();
		oldStack.pop();
	}
}
