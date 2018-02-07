package stackAndQueuePractice;

public class QeueuPractice_1 {
	public static void main(String[] args)
	{
		MyQueue<Integer> queue = new MyQueue<Integer>();
		for(int i=0; i<10; i++)
			queue.add(i);
		queue.remove();
		System.out.println(queue.peek());
	}
}
