package linkedListPractice;

import DataStructuresHelpers.*;

public class LinkedList_intersection {
	public static void main(String[] args)
	{
		LinkedList list1 = HelperFunctions.generateRandomLinkedList(6, 15, 1);
		LinkedList list2 = HelperFunctions.generateRandomLinkedList(6, 15, 1);
		LinkedList intersection = HelperFunctions.generateRandomLinkedList(4, 15, 1);
		HelperFunctions.EndOfList(list1).next = intersection;
		HelperFunctions.EndOfList(list2).next = intersection;
		System.out.println(list1.printLinkedList());
		System.out.println(list2.printLinkedList());
		System.out.println("Two linked list intersect at: " + findIntersection(list1, list2).data);
	}
	
	public static LinkedList findIntersection(LinkedList list1, LinkedList list2)
	{
		if(list1 == null || list2 == null)
			return null;
		int length1 = HelperFunctions.LinkedListLength(list1);
		int length2 = HelperFunctions.LinkedListLength(list2);
		LinkedList end1 = HelperFunctions.EndOfList(list1);
		LinkedList end2 = HelperFunctions.EndOfList(list2);
		
		if(end1 != end2)
			return null;
		
		if(length1 > length2)
		{
			for(int i=0; i<length1 - length2; i++)
				list1 = list1.next;
		}
		else if(length2 > length1)
		{
			for(int i=0; i<length2-length1; i++)
				list2 = list2.next;
		}
		
		while(list1 != list2)
		{
			list1 = list1.next;
			list2 = list2.next;
		}
		
		
		return list1;
	}
}
