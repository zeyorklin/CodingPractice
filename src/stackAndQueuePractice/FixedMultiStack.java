package stackAndQueuePractice;

public class FixedMultiStack {
	private int stackNum = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize)
	{
		stackCapacity = stackSize;
		values = new int[stackSize * stackNum];
		sizes = new int[stackNum];
	}
	
	public void push(int stackNum, int value) throws FullStackException{
		if(isFull(stackNum))
		{
			throw new FullStackException("stack is full");
		}
		
		sizes[stackNum] ++;
		values[stackTopIndex(stackNum)] = value;
	}
	
	public int pop(int stackNum) throws FullStackException
	{
		if(isEmpty(stackNum))
		{
			throw new FullStackException("Stack is empty");
		}
		int topIndex = stackTopIndex(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}
	
	public int peek(int stackNum) throws FullStackException
	{
		if(isEmpty(stackNum))
		{
			throw new FullStackException("stack is empty");
		}
		return values[stackTopIndex(stackNum)];
	}
	
	public boolean isEmpty(int stackNum)
	{
		return sizes[stackNum] == 0;
	}
	
	public boolean isFull(int stackNum)
	{
		return sizes[stackNum] == stackCapacity;
	}
	
	private int stackTopIndex (int stackNum)
	{
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
	
}
