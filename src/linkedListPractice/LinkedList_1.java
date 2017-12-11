package linkedListPractice;

import java.util.HashSet;

import DataStructuresHelpers.LinkedList;

public class LinkedList_1 {
	public static void main(String[] args)
	{
		LinkedList first = new LinkedList(0, null, null);
		LinkedList head = first;
		LinkedList second = first;
		for(int i=6; i<20; i++)
		{
			second = new LinkedList(i%4, null, null);
			first.nextNode(second);
			second.previousNode(first);
			first = second;
		}
		System.out.println(head.printLinkedList());
		//removeDuplicates(head);
		removeDuplicatesNoHash(head);
		System.out.println(head.printLinkedList());
	}
	
	public static void removeDuplicates(LinkedList n)
	{
		HashSet<Integer> listHash = new HashSet<Integer>();
		LinkedList previous = null;
		while(n != null)
		{
			if(listHash.contains(n.data))
			{
				previous.next = n.next;
			}
			else
			{
				listHash.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	public static void removeDuplicatesNoHash (LinkedList n)
	{
		LinkedList current = n;
		while(current != null)
		{
			LinkedList runner = current;
			while(runner.next != null)
			{
				if(runner.next.data == current.data)
				{
					runner.next = runner.next.next;
				}
				else
				{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}
