package LinkedListPractice;

import DataStructuresHelpers.LinkedList;

public class LinkedList_5 {
	
	public static LinkedList linkedListAddition(LinkedList firstNum, LinkedList secondNum, int carry)
	{
		if(firstNum == null && secondNum == null && carry == 0)
		{
			return null;
		}
		
		LinkedList result = new LinkedList();
		
		int value = carry;
		
		if(firstNum != null)
			value += firstNum.data;
		
		if(secondNum != null)
			value += secondNum.data;
		
		result.data = value % 10;
		
		if(firstNum != null || secondNum != null)
		{
			LinkedList nextNum = linkedListAddition(firstNum == null ? null : firstNum.next, 
													secondNum == null ? null : secondNum.next, 
													value >= 10 ? 1 : 0);
			result.nextNode(nextNum);
		}
		
		return result;
	}
	
	public static int linkedListToInt(LinkedList result)
	{
		int resultInt = 0;
		if(result.next != null)
		{
			resultInt = 10 * linkedListToInt(result.next);
		}
		return resultInt + result.data;
	}
	
	public static void main(String[] args)
	{
		LinkedList first = new LinkedList((int)(Math.random()*9 + 0), null, null);
		LinkedList firstNum = first;
		LinkedList second = first;
		for(int i=1; i<3; i++)
		{
			second = new LinkedList((int)(Math.random()*9 + 0), null, null);
			first.nextNode(second);
			second.previousNode(first);
			first = second;
		}

		
		first = new LinkedList((int)(Math.random()*9 + 0), null, null);
		LinkedList secondNum = first;
		second = first;
		for(int i=1; i<4; i++)
		{
			second = new LinkedList((int)(Math.random()*9 + 0), null, null);
			first.nextNode(second);
			second.previousNode(first);
			first = second;
		}
		System.out.println(firstNum.printLinkedList() + " + " + secondNum.printLinkedList() + " = " + linkedListToInt(linkedListAddition(firstNum, secondNum, 0)));
		
		System.out.println(linkedListAddition(firstNum, secondNum, 0).printLinkedList());
		
	}
	
	
}
