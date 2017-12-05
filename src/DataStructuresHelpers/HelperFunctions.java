package DataStructuresHelpers;

public class HelperFunctions {
	
	public static LinkedList generateRandomLinkedList(int length, int max, int min)
	{
		LinkedList first = new LinkedList((int)(Math.random()*9 + 0), null, null);
		LinkedList head = first;
		LinkedList next = first;
		for(int i=1; i<length; i++)
		{
			next = new LinkedList((int)(Math.random()*9 + 0), null, null);
			first.nextNode(next);
			next.previousNode(first);
			first = next;
		}
		return head;
	}
}
