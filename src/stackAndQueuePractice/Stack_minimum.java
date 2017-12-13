package stackAndQueuePractice;

public class Stack_minimum {
	public static void main(String[] args)
	{
		StackMinimum stackWithMinimum = new StackMinimum();
		stackWithMinimum.push(10);
		stackWithMinimum.push(4);
		stackWithMinimum.push(6);
		stackWithMinimum.push(2);
		
		System.out.println(stackWithMinimum.min() + " then pop " + stackWithMinimum.pop() + " then min " + stackWithMinimum.min());
	}
}
