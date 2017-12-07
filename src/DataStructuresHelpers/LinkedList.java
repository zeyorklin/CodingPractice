package DataStructuresHelpers;

public class LinkedList {
	public LinkedList next;
	public LinkedList prev;
	public LinkedList last;
	public int data;
	
	public LinkedList(int d, LinkedList n, LinkedList p)
	{
		data = d;
		nextNode(n);
		previousNode(p);
	}
	
	public LinkedList(int d)
	{
		data = d;
	}
	
	public LinkedList() {}
	
	public void nextNode(LinkedList n)
	{
		next = n;
		if(this == last)
		{
			last = n;
		}
		if(n != null && n.prev != this)
		{
			n.previousNode(this);
		}
	}
	
	public void previousNode(LinkedList p)
	{
		prev = p;
		if(p != null && p.next != this)
		{
			p.nextNode(this);
		}
	}
	
	public String printLoopLinkedList(int count)
	{
		if(next != null && count != 0)
		{
			return data + "->" + next.printLoopLinkedList(count - 1);
		}
		else 
		{
			return ((Integer) data).toString();
		}
	}
	
	public String printLinkedList()
	{
		if(next != null)
		{
			return data + "->" + next.printLinkedList();
		}
		else 
		{
			return ((Integer) data).toString();
		}
	}
	
}
