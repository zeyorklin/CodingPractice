package stackAndQueuePractice;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity)
	{
		this.capacity = capacity;
	}
	
	public Stack lastStack()
	{
		if(stacks.size() == 0)
			return null;
		
		return stacks.get(stacks.size() - 1);
	}
	
}
