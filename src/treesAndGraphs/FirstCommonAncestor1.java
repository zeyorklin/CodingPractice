package treesAndGraphs;
import DataStructuresHelpers.TreeNode;

public class FirstCommonAncestor1 {
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = BST_MinHeight.createMinHeightBST(array);
		TreeNode first = root.find(10);
		TreeNode second = root.find(4);
		if(findCommonAncestor(first, second) == null)
		{
			System.out.println("the two nodes have no common ancestor");
		}
		else
		{
			System.out.println("The commong ancestor for " + first.data + " and " + second.data + " is " + findCommonAncestor(first, second).data);
		}
	}
	
	public static TreeNode findCommonAncestor(TreeNode first, TreeNode second)
	{
		int diff = first.getDepth() - second.getDepth();
		TreeNode higher = diff > 0 ? second : first;
		TreeNode lower = diff > 0? first : second;
		lower = goUp(lower, Math.abs(diff));
		
		while(higher != lower && higher != null && lower != null)
		{
			higher = higher.parent;
			lower = lower.parent;
		}
		
		return higher == null || lower == null ? null : higher;
		
	}
	
	public static TreeNode goUp(TreeNode node, int level)
	{
		while(level > 0 && node != null)
		{
			node = node.parent;
			level--;
		}
		return node;
	}
}
