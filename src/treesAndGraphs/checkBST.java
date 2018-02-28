package treesAndGraphs;

import DataStructuresHelpers.TreeNode;

public class checkBST {
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = BST_MinHeight.createMinHeightBST(array);
		//root.right.data = 3;
		System.out.println("Is the tree a BST: " + inOrderValidation(root));
		System.out.println("Is the tree a BST: " + minAndMaxValidation(root, null, null));
	}
	
	static Integer previous_value = null;
	
	public static boolean inOrderValidation(TreeNode root)
	{
		if(root == null)
			return true;
					
		if(!inOrderValidation(root.left))
			return false;
		
		if(previous_value != null && root.data < previous_value)
			return false;
		
		previous_value = root.data;
		
		if(!inOrderValidation(root.right))
			return false;
		
		return true;
	}
	
	public static boolean minAndMaxValidation(TreeNode root, Integer min, Integer max)
	{
		if(root == null)
			return true;
		
		if((min!= null && root.data <= min) || (max != null && root.data > max))
			return false;
		
		if(!minAndMaxValidation(root.left, min, root.data) || !minAndMaxValidation(root.right, root.data, max))
			return false;
		
		return true;
	}
}
