package stackAndQueuePractice;

public class StackPractice_1 {
	public static void main(String[] args) throws Exception{
		FixedMultiStack stacks= new FixedMultiStack(4);
		stacks.push(0, 5);
		stacks.push(0, 3);
		stacks.push(0, 8);
		System.out.println(stacks.pop(0));
		System.out.println(stacks.peek(0));
	}
}
