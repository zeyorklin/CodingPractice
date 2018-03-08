package treesAndGraphs;

import java.util.*;

import DataStructuresHelpers.TreeNode;

public class CountPathWithSum {
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.right.left = new TreeNode(0);
		System.out.println(countPath(root, 0));
		System.out.println(countPathFromNode2(root, 0, 0, new HashMap<Integer, Integer>()));
	}
	
	//brute force approach
	public static int countPath(TreeNode root, int targetSum)
	{
		if(root == null)
			return 0;
		
		int paths = countPathFromNode(root, targetSum, 0);
		int leftPaths = countPath(root.left, targetSum);
		int rightPaths = countPath(root.right, targetSum);
		
		return paths + leftPaths + rightPaths;
		
	}
	
	public static int countPathFromNode(TreeNode root, int targetSum, int currentSum)
	{
		if(root == null)
			return 0;
		
		currentSum += root.data;
		int totalPath = 0;
		if(currentSum == targetSum)
		{
			totalPath ++;
		}
		
		totalPath += countPathFromNode(root.left, targetSum, currentSum);
		totalPath += countPathFromNode(root.right, targetSum, currentSum);
		
		return totalPath;
	}
	
	//optimized method
	public static int countPathFromNode2(TreeNode root, int targetSum, Integer runningSum, HashMap<Integer, Integer> hash)
	{		
		if(root == null)
			return 0;
		
		runningSum += root.data;
		int sumDiff = runningSum - targetSum;
		int totalPaths = hash.getOrDefault(sumDiff, 0);
		if(runningSum == targetSum)
		{
			totalPaths ++;
		}
		modifyHashMap(hash, runningSum, 1);
		totalPaths += countPathFromNode2(root.left, targetSum, runningSum, hash);
		totalPaths += countPathFromNode2(root.right, targetSum, runningSum, hash);
		modifyHashMap(hash, runningSum, -1);
		return totalPaths;
	}
	
	public static void modifyHashMap(HashMap<Integer, Integer> hash, int key, int index)
	{
		int value = hash.getOrDefault(key, 0) + index;
		if(value == 0)
		{
			hash.remove(key);
		}
		else 
		{
			hash.put(key, value);
		}
	}
}
