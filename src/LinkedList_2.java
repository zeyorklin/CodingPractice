import DataStructuresHelpers.LinkedList;

public class LinkedList_2 {
	public static void main(String[] args)
	{
		LinkedList first = new LinkedList(0, null, null);
		LinkedList head = first;
		LinkedList second = first;
		for(int i=1; i<10; i++)
		{
			second = new LinkedList(i, null, null);
			first.nextNode(second);
			second.previousNode(first);
			first = second;
		}
		System.out.println(head.printLinkedList());
		System.out.println("7th element to last node is " + findKElementOptimal(head, 7).data);
	}
	
	public static int findKElement(LinkedList n, int k)
	{
		if(n == null)
		{
			return 0;
		}
		int index = findKElement(n.next, k) + 1;
		//System.out.println(index + " " + n.data);
		if(index == k)
		{
			System.out.println(k+"th element to last node is "+n.data);
		}
		return index;
	}
	
	public static LinkedList findKElementOptimal(LinkedList n, int k)
	{
		LinkedList n1 = n;
		LinkedList n2 = n;
		
		for(int i=0; i<k; i++)
		{
			if(n1 == null)
				return null;
			else
				n1 = n1.next;
		}
		
		while(n1 != null)
		{
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return n2;
	}
}
