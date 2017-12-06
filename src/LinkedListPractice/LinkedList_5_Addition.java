package LinkedListPractice;

import DataStructuresHelpers.*;


//Linked List addition, add two linked list as number together, 1->2->3 + 4->5->6->7 = 4690
public class LinkedList_5_Addition {
	
	public static void main(String[] args)
	{
		LinkedList firstNumber = HelperFunctions.generateRandomLinkedList(4, 9, 0);
		System.out.println(firstNumber.printLinkedList());
		LinkedList secondNumber = HelperFunctions.generateRandomLinkedList(4, 9, 0);
		System.out.println(secondNumber.printLinkedList());
		LinkedList result = addition(firstNumber, secondNumber);
		System.out.println(result.printLinkedList());
	}
	
	public static DataClass additionLinkedList(LinkedList firstNum, LinkedList secondNum)
	{
		if(firstNum == null && secondNum == null)
		{
			DataClass sum = new DataClass();
			return sum;
		}
		DataClass sum = additionLinkedList(firstNum.next, secondNum.next);
		int val = sum.carry + firstNum.data + secondNum.data;
		LinkedList listResult = insertFront(sum.sum, val % 10);
		sum.sum = listResult;
		sum.carry = val/10;
		
		return sum;
	}
	
	public static LinkedList addition(LinkedList firstNum, LinkedList secondNum)
	{
		LinkedList result = null;
		int length1 = linkedListLength(firstNum);
		int length2 = linkedListLength(secondNum);
		if(length1 > length2)
		{
			secondNum = padList(secondNum, length1 - length2);
		}
		else if(length2 > length1)
		{
			firstNum = padList(firstNum, length2 - length1);
		}
		
		DataClass sum = additionLinkedList(firstNum, secondNum);
		if(sum.carry == 0)
			return sum.sum;
		else
			return insertFront(sum.sum, sum.carry);
	}
	
	public static LinkedList padList(LinkedList list, int padding)
	{
		LinkedList head = list;
		for(int i=0; i < padding; i++)
		{
			head = insertFront(list, 0);
		}
		return head;
	}
	
	public static LinkedList insertFront(LinkedList list, int value)
	{
		LinkedList node = new LinkedList(value);
		if(list != null)
			node.next = list;
		return node;
	}
	
	public static int linkedListLength(LinkedList list)
	{
		int length = 0;
		while(list != null)
		{
			length ++;
			list = list.next;
		}
		return length;
	}
}
