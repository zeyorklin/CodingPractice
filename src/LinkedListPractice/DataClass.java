package linkedListPractice;


import DataStructuresHelpers.LinkedList;

public class DataClass {
	public LinkedList sum = null;
	public int carry = 0;
	public boolean result;
	public DataClass() {
	}
	public DataClass(LinkedList list, boolean res)
	{
		sum = list;
		result = res;
	}
}
