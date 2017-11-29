import java.text.Bidi;

import DataStructuresHelpers.LinkedList;

public class LinkedList_4 {
	public static void main(String[] args)
	{
		LinkedList first = new LinkedList((int)(Math.random()*20 + 1), null, null);
		LinkedList head = first;
		LinkedList second = first;
		for(int i=1; i<10; i++)
		{
			second = new LinkedList((int)(Math.random()*20 + 1), null, null);
			first.nextNode(second);
			second.previousNode(first);
			first = second;
		}
		System.out.println(head.printLinkedList());
		System.out.println("Partition at 10: " + partitionList(head, 10).printLinkedList());
	}
	
	public static LinkedList partitionList(LinkedList n, int x)
	{
		LinkedList smallerList = null;
		LinkedList smallerListNext = null;
		LinkedList biggerList = null;
		LinkedList biggerListNext = null;
		while(n != null)
		{
			LinkedList next = n.next;
			n.next = null;
			if(n.data < x)
			{
				if(smallerList == null)
				{
					smallerList = n;
					smallerListNext = smallerList;
				}
				else 
				{
					System.out.println(smallerList.printLinkedList());
					System.out.println(smallerListNext.printLinkedList());
					smallerListNext.next = n;
					smallerListNext = n;
				}
			}
			else
			{
				if(biggerList == null)
				{
					biggerList = n;
					biggerListNext = biggerList;
				}
				else
				{
					biggerListNext.next = n;
					biggerListNext = n;
				}
			}
			n = next;
		}
		
		if(smallerList == null)
			return biggerList;
		
		smallerListNext.next = biggerList;
		return smallerList;
	}
}
