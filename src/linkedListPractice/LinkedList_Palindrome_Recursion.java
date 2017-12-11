package linkedListPractice;

import DataStructuresHelpers.*;

public class LinkedList_Palindrome_Recursion {
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
		
		System.out.println("Is " + head.printLinkedList() + " a palindrome: " + isPalindrome(head));
				
	}
	
	public static boolean isPalindrome(LinkedList list)
	{
		int length = HelperFunctions.LinkedListLength(list);
		DataClass check = checkPalindromeRecursion(list, length);
		return check.result;
	}
	
	public static DataClass checkPalindromeRecursion(LinkedList list, int length)
	{
		if(list == null || length <= 0)
		{
			return new DataClass(list, true);
		}
		else if(length == 1)
		{
			return new DataClass(list.next, true);
		}
		
		DataClass result = checkPalindromeRecursion(list.next, length - 2);
		
		if(!result.result || result.sum == null)
			return result;
		
		result.result = (list.data == result.sum.data);
		
		result.sum = result.sum.next;
		
		return result;
	}
}
