package treesAndGraphs;

import java.util.*;

import DataStructuresHelpers.TreeNode;

public class findBSTSequence {	
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = BST_MinHeight.createMinHeightBST(array);
		ArrayList<LinkedList<Integer>> results = findSequences(root);
		for(LinkedList<Integer> combinedList : results)
		{
			System.out.println(combinedList);
		}
		System.out.println(results.size());
	}
	
	public static void combineLists(LinkedList<Integer> left, LinkedList<Integer> right, 
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix)
	{
		if(left.size() == 0 || right.size() == 0)
		{
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(left);
			result.addAll(right);
			results.add(result);
			return;
		}
		
		int firstLeft = left.removeFirst();
		prefix.addLast(firstLeft);
		combineLists(left, right, results, prefix);
		prefix.removeLast();
		left.addFirst(firstLeft);
		
		int firstRight = right.removeFirst();
		prefix.addLast(firstRight);
		combineLists(left, right, results, prefix);
		prefix.removeLast();
		right.addFirst(firstRight);
	}
	
	public static ArrayList<LinkedList<Integer>> findSequences(TreeNode root)
	{
		ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
		if(root == null)
		{
			results.add(new LinkedList<Integer>());
			return results;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(root.data);
		
		ArrayList<LinkedList<Integer>> leftResult = findSequences(root.left);
		ArrayList<LinkedList<Integer>> rightResult = findSequences(root.right);
		
		for(LinkedList<Integer> leftList : leftResult)
		{
			for(LinkedList<Integer> rightList : rightResult)
			{
				ArrayList<LinkedList<Integer>> combinedList = new ArrayList<LinkedList<Integer>>();
				combineLists(leftList, rightList, combinedList, prefix);
				results.addAll(combinedList);
			}
		}
		return results;
		
	}

}
