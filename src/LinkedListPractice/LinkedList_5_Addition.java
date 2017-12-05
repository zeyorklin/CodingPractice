package LinkedListPractice;

import DataStructuresHelpers.*;


//Linked List addition, add two linked list as number together, 1->2->3 + 4->5->6->7 = 4690
public class LinkedList_5_Addition {
	
	public static void main(String[] args)
	{
		LinkedList firstNumber = HelperFunctions.generateRandomLinkedList(3, 9, 0);
		firstNumber.printLinkedList();
	}
}
