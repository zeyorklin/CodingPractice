package treesAndGraphs;
import java.util.ArrayList;
import java.util.*;

import DataStructuresHelpers.TreeNode;

public class CreateLinkedListFromTree {
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		TreeNode node = BST_MinHeight.createMinHeightBST(array);
		System.out.println(node.height());
		ArrayList<LinkedList<TreeNode>> result = createLLFromTreeBFS(node);
		printTreeNodeLL(result);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLLFromTreeDFS(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		createLLFromTreeDFS(root, result, 0);
		return result;
	}
	
	public static void createLLFromTreeDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level)
	{
		if(root == null)
			return;
		
		LinkedList<TreeNode> layer = null;
		if(lists.size() == level)
		{
			layer = new LinkedList<TreeNode>();
			lists.add(layer);
		}
		else {
			layer = lists.get(level);
		}
		layer.add(root);
		createLLFromTreeDFS(root.left, lists, level + 1);
		createLLFromTreeDFS(root.right, lists, level + 1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLLFromTreeBFS(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> currentNode = new LinkedList<TreeNode>();
		if(root != null)
			currentNode.add(root);
		while(currentNode.size() > 0)
		{
			result.add(currentNode);
			LinkedList<TreeNode> parents = currentNode;
			currentNode = new LinkedList<TreeNode>();
			for(TreeNode parent : parents)
			{
				if(parent.left != null)
					currentNode.add(parent.left);
				if(parent.right != null)
					currentNode.add(parent.right);
			}
		}
		
		return result;
	}
	
	public static void printTreeNodeLL(ArrayList<LinkedList<TreeNode>> result)
	{
		int depth = 0;
		for(LinkedList<TreeNode> layer : result)
		{
			Iterator<TreeNode> node = layer.listIterator();
			System.out.print("Linked list at depth " + depth + ": ");
			while(node.hasNext())
			{
				System.out.print(" " + ((TreeNode)node.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
}
