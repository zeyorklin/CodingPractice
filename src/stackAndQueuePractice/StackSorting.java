package stackAndQueuePractice;
import java.util.Stack;

public class StackSorting {
	public static void main(String[] args)
	{
		
	}
	
	void sort(Stack<Integer> s)
	{
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty())
		{
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() > temp)
			{
				s.push(r.pop());
			}
			r.push(temp);
		}
		
	}
}
