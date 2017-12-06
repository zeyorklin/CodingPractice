package LinkedListPractice;

import javax.naming.spi.DirStateFactory.Result;
import javax.xml.crypto.Data;

import DataStructuresHelpers.LinkedList;

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
	
	public static int LinkedListLenth(LinkedList list)
	{
		int length = 0;
		while(list != null)
		{
			length ++;
			list = list.next;
		}
		return length;
	}
	
	public static boolean isPalindrome(LinkedList list)
	{
		int length = LinkedListLenth(list);
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
