package LinkedListPractice;

import DataStructuresHelpers.LinkedList;

public class LinkedList_3 {
	public static void main(String[] args)
	{
		LinkedList first = new LinkedList(0, null, null);
		LinkedList head = first;
		LinkedList second = first;
		for(int i=1; i<8; i++)
		{
			second = new LinkedList(i, null, null);
			first.nextNode(second);
			second.previousNode(first);
			first = second;
		}
		System.out.println(head.printLinkedList());
		deleteNode(head.next.next.next.next);
		System.out.println(head.printLinkedList());
	}
	
	public static boolean deleteNode(LinkedList n)
	{
		if(n == null || n.next == null)
			return false;
		System.out.println("deleting node with value " + n.data);
		LinkedList next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}


