package stackAndQueuePractice;

public class stackPractice_3 {
	public static void main (String[] args)
	{
		int capacity = 5;
		SetOfStacks stackSet = new SetOfStacks(capacity);
		for(int i =0; i<34; i++)
			stackSet.push(i);
		
		System.out.println(stackSet.popAt(2));
		System.out.println(stackSet.popAt(3));
	}
}
