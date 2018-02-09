package stackAndQueuePractice;
import java.util.Stack;

public class StackSorting {
	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(4);
		s.push(10);
		s.push(8);
		s.push(11);
		System.out.println(s.peek());
		sort(s);
		System.out.println(s.peek());
	}
	
	public static void sort(Stack<Integer> s)
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
		
		while (!r.empty())
			s.push(r.pop());
		
	}
}
