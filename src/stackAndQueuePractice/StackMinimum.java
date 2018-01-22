package stackAndQueuePractice;

import java.util.Stack;

public class StackMinimum extends Stack<Integer>{
	Stack<Integer> minStack;
	
	public StackMinimum()
	{
		minStack = new Stack<Integer>();
	}
	
	public void push(int value)
	{
		if(value <= min())
		{
			minStack.push(value);
		}
		super.push(value);  //super calls parent constructor (Stack<Integer>)
	}
	
	public Integer pop()
	{
		int value = super.pop();
		if(value == min())
		{
			minStack.pop();
		}
		return value;
	}
	
	public int min()
	{
		if(minStack.isEmpty())
		{
			return Integer.MAX_VALUE;
		}
		else {
			return minStack.peek();
		}
	}
	
}
