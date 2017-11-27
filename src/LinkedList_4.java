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
	}
	
	public static LinkedList partitionList(LinkedList n, int x)
	{
		LinkedList smallerList = null;
		LinkedList smallerListNext = null;
		LinkedList biggerList = null;
		while(n != null)
		{
			if(smallerList == null)
			{
				smallerList.data = n.data;
				smallerListNext = smallerList;
			}
			else 
			{
				smallerListNext.next.data = n.data;
			}
		}
		
		return smallerList;
	}
}
