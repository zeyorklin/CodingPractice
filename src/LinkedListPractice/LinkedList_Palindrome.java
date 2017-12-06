package LinkedListPractice;

import java.util.Stack;

import DataStructuresHelpers.LinkedList;

public class LinkedList_Palindrome {
	public static void main(String[] args)
	{
		LinkedList first = new LinkedList(1, null, null);
		LinkedList head = first;
		LinkedList next = first;
		for(int i=2; i < 5; i++)
		{
			next = new LinkedList(i, null, null);
			first.nextNode(next);
			next.previousNode(first);
			first = next;
		}
		
		for(int i=3; i > 0; i--)
		{
			next = new LinkedList(i, null, null);
			first.nextNode(next);
			next.previousNode(first);
			first = next;
		}
		
		System.out.println("Is " + head.printLinkedList() + " a palindrome: " + checkPalindrome2(head));
		
		System.out.print(reverseLinkedList(head).printLinkedList());
	}
	
	public static LinkedList reverseLinkedList(LinkedList list)
	{
		LinkedList head = null;
		while(list != null)
		{
			LinkedList newNode = new LinkedList(list.data);
			newNode.next = head;
			head = newNode;
			list = list.next;
		}
		return head;
	}
	
	public static boolean checkPalindrome(LinkedList list)
	{
		LinkedList reverseList = reverseLinkedList(list);
		while(list != null && reverseList != null)
		{
			if(list.data != reverseList.data)
				return false;
			list = list.next;
			reverseList = reverseList.next;
		}
		return true;
	}
	
	public static boolean checkPalindrome2(LinkedList list)
	{
		LinkedList slowRunner = list;
		LinkedList fastRunner = list;
		
		Stack<Integer> linkedListStack = new Stack<Integer>();
		while(fastRunner != null && fastRunner.next != null)
		{
			linkedListStack.push(slowRunner.data);
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}
		
		if(fastRunner != null)
			slowRunner = slowRunner.next;
		
		while(slowRunner != null)
		{
			int stackValue = linkedListStack.pop().intValue();
			if(stackValue != slowRunner.data)
				return false;
			slowRunner = slowRunner.next;
		}
		
		return true;
	}
}
