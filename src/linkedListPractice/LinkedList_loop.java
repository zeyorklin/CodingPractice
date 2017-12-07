package linkedListPractice;

import DataStructuresHelpers.*;

public class LinkedList_loop {
	public static void main(String[] args)
	{
		int listLength = 11;
		int loopLength = 7;
		LinkedList loop = HelperFunctions.generateRandomLinkedList(listLength, 10, 0);
		LinkedList end = HelperFunctions.EndOfList(loop);
		
		System.out.println(loop.printLinkedList());
		end.next = loop.next.next.next.next;
		if(findLoopBeginning(loop) == null)
			System.out.println(loop.printLinkedList() + " is not a loop");
		else
			System.out.println(loop.printLoopLinkedList(listLength + loopLength - 1) + " is a loop that starts at " + findLoopBeginning(loop).data);
	}
	
	public static LinkedList findLoopBeginning(LinkedList loop)
	{
		LinkedList slowRunner = loop;
		LinkedList fastRunner = loop;
		
		while(fastRunner != null && fastRunner.next != null)
		{
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if(slowRunner == fastRunner)
				break;
		}
		
		if(fastRunner == null || fastRunner.next == null)
			return null;
		
		slowRunner = loop;
		
		while(slowRunner != fastRunner)
		{
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		
		return slowRunner;
	}
}
