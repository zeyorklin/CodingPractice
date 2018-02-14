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
		s.push(2);
		s.push(25);
		s.push(18);
		System.out.println(s.peek());
		Stack<Integer> sorted = new Stack<Integer>();
		sorted = mergeSort(s);
		System.out.println(sorted.peek());
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
	
	public static Stack<Integer> mergeSort(Stack<Integer> s)
	{
		if(s.size() <= 1)
			return s;
		
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while(s.size() != 0)
		{
			count ++;
			if(count % 2 == 0)
			{
				left.push(s.pop());
			}
			else {
				right.push(s.pop());
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		while(left.size() > 0 || right.size() > 0)
		{
			if(right.size() == 0)
			{
				s.push(left.pop());
			}
			else if(left.size() == 0)
			{
				s.push(right.pop());
			}
			else if(right.peek().compareTo(left.peek()) >= 0)
			{
				s.push(left.pop());
			}
			else {
				s.push(right.pop());
			}
		}
		
		Stack<Integer> reverse = new Stack<Integer>();
		while(s.size() != 0)
		{
			reverse.push(s.pop());
		}
		return reverse;
		
	}
}
