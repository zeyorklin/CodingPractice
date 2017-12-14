package stackAndQueuePractice;

public class Stack {
	private int capacity;
	public Node top;
	public Node bottom;
	public int size=0;
	
	public Stack(int capacity)
	{
		this.capacity = capacity;
	}
	
	public boolean isFull()
	{
		return size == capacity;
	}
	
	public void join(Node above, Node below)
	{
		if(below != null)
			below.above = above;
		if(above != null)
			above.below = below;
	}
	
	public void push()
	{
		
	}
}	
