package LinkedListPractice;

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
		
		for(int i=4; i > 0; i--)
		{
			next = new LinkedList(i, null, null);
			first.nextNode(next);
			next.previousNode(first);
			first = next;
		}
		
		System.out.println("Is " + head.printLinkedList() + " a palindrome: " + checkPalindrome(head));
		
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
	
}
