package treesAndGraphs;
import DataStructuresHelpers.*;

public class checkSubtree {
	public static void main(String[] args)
	{
		int[] arrayBig = {1,2,3,4,5,6,7};
		int[] arraySmall = {1,2,3};
		TreeNode rootBig = BST_MinHeight.createMinHeightBST(arrayBig);
		TreeNode rootSmall = BST_MinHeight.createMinHeightBST(arraySmall);
		System.out.println(checkTree2(rootBig, rootSmall));
	}
	
	public static boolean checkTree(TreeNode big, TreeNode small)
	{
		if(big == null)
			return false;
		else if(big.data == small.data && matchTree(big, small))
			return true;
		
		return checkTree(big.left, small) || checkTree(big.right, small);
	}
	
	public static boolean matchTree(TreeNode big, TreeNode small)
	{
		if(big == null && small == null)
		{
			return true;
		}
		else if(big == null || small == null)
		{
			return false;
		}
		else if(big.data != small.data)
		{
			return false;
		}
		else {
			return matchTree(big.left, small.left) && matchTree(big.right, small.right);
		}
	}
	
	public static boolean checkTree2 (TreeNode big, TreeNode small)
	{
		StringBuilder bigString = new StringBuilder();
		StringBuilder smallString = new StringBuilder();
		treeToString(big, bigString);
		treeToString(small, smallString);
		return bigString.indexOf(smallString.toString()) != -1;
	}
	
	public static void treeToString(TreeNode root, StringBuilder s)
	{
		if(root == null)
		{
			s.append("X");
			return;
		}
		s.append(root.data);
		treeToString(root.left, s);
		treeToString(root.right, s);
	}
}
