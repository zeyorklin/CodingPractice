package treesAndGraphs;

import DataStructuresHelpers.TreeNode;

public class CheckTreeBalance {
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = BST_MinHeight.createMinHeightBST(array);
		root.insert(4);
		if(checkHeight(root) != Integer.MIN_VALUE)
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is unbalanced");
	}
	
	public static int checkHeight(TreeNode root)
	{
		if(root == null)
			return -1;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		if(Math.abs(leftHeight - rightHeight) > 1)
		{
			System.out.println("Unbalanced occuring at node: " + root.data 
					+ " and height difference is " + Math.abs(leftHeight - rightHeight));
			return Integer.MIN_VALUE;
		}
		else
			return 1+ Math.max(leftHeight, rightHeight);
	}
}
