package DataStructuresHelpers;

public class HelperFunctions {
	
	public static LinkedList generateRandomLinkedList(int length, int max, int min)
	{
		LinkedList first = new LinkedList((int)(Math.random()*(max - min) + 1), null, null);
		LinkedList head = first;
		LinkedList next = first;
		for(int i=1; i<length; i++)
		{
			next = new LinkedList((int)(Math.random()*(max - min) + 1), null, null);
			first.nextNode(next);
			next.previousNode(first);
			first = next;
		}
		return head;
	}
	
	public static String numToBitString(int n, int limit)
	{
		String bitString = "";
		for(int i=0; i < limit; i++)
		{
			Integer lsb = new Integer(n & 1);
			bitString = lsb.toString() + bitString;
			n = n >> 1;
		}
		return bitString;
	}
	
	public static int LinkedListLength(LinkedList list)
	{
		int length = 0;
		while(list != null)
		{
			length ++;
			list = list.next;
		}
		return length;
	}
	
	public static LinkedList EndOfList(LinkedList list)
	{
		LinkedList end = list;
		while(end.next != null)
			end = end.next;
		return end;
	}
}
