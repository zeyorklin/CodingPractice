package treesAndGraphs;
import DataStructuresHelpers.TreeNode;

public class FirstCommonAncestor1 {
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = BST_MinHeight.createMinHeightBST(array);
		TreeNode first = root.find(10);
		TreeNode second = root.find(7);
		if(findCommonAncestor2(root, first, second) == null)
		{
			System.out.println("the two nodes have no common ancestor");
		}
		else
		{
			System.out.println("The commong ancestor for " + first.data + " and " + second.data + " is " + findCommonAncestor2(root, first, second).data);
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
	
	public static TreeNode findCommonAncestor2(TreeNode root, TreeNode first, TreeNode second)
	{
		if(!searchSubTree(root, first) || !searchSubTree(root, second))
			return null;
		else if(searchSubTree(second, first))
			return second;
		else if(searchSubTree(first, second))
			return first;
		
		TreeNode sibling = findSibling(first);
		TreeNode parent = first.parent;
		while(!searchSubTree(sibling, second))
		{
			sibling = findSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}
	
	public static TreeNode findSibling(TreeNode node)
	{
		if(node == null || node.parent == null)
			return null;
		return node.parent.left == node ? node.parent.right : node.parent.left;
	}
	
	public static boolean searchSubTree(TreeNode root, TreeNode node)
	{
		if(root == null)
			return false;
		if(root == node)
			return true;
		return searchSubTree(root.left, node) || searchSubTree(root.right, node);
	}
}
