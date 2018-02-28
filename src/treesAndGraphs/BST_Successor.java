package treesAndGraphs;

import DataStructuresHelpers.TreeNode;

public class BST_Successor {
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = BST_MinHeight.createMinHeightBST(array);
		root = root.left;
		TreeNode successor = findSuccessor(root);
		if(successor != null)
			System.out.println("Successor for " + root.data + " is " + successor.data);
		else
			System.out.println("No Successor for " + root.data);
	}
	
	public static TreeNode findSuccessor(TreeNode node)
	{
		if(node == null)
			return null;
		
		TreeNode successor = node;
		
		if(node.right != null)
		{
			successor = node.right;
			while(successor.left != null)
				successor = successor.left;
			
			return successor;
		}
		else 
		{
			TreeNode current = node;
			successor = current.parent;
			while(successor != null && successor.left != current)
			{
				current = successor;
				successor = current.parent;
			}
			return successor;
		}
	}
}
