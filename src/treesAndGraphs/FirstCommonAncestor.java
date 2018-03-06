package treesAndGraphs;
import DataStructuresHelpers.TreeNode;

public class FirstCommonAncestor {
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = BST_MinHeight.createMinHeightBST(array);
		TreeNode first = root.find(10);
		TreeNode second = root.find(1);
		if(findCommonAncestor(root, first, second) == null)
		{
			System.out.println("the two nodes have no common ancestor");
		}
		else
		{
			System.out.println("The commong ancestor for " + first.data + " and " + second.data + " is " + findCommonAncestor(root, first, second).data);
		}
	}
	
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode first, TreeNode second)
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
	
	public static TreeNode findCommonAncestor3(TreeNode root, TreeNode first, TreeNode second)
	{
		if(!searchSubTree(root, first) || !searchSubTree(root, second))
			return null;
		
		return findAncestor(root, first, second);
	}
	
	public static TreeNode findCommonAncestor4(TreeNode root, TreeNode first, TreeNode second)
	{
		nodeResult result = findAncestor2(root, first, second);
		if(result.isAncestor)
			return result.node;
		else
			return null;
	}
	
	//for findCommonAncestor
		public static TreeNode goUp(TreeNode node, int level)
		{
			while(level > 0 && node != null)
			{
				node = node.parent;
				level--;
			}
			return node;
		}
	
	//for findCommonAncestor4
	public static class nodeResult { 
		public TreeNode node;
		public boolean isAncestor;
		public nodeResult(TreeNode n, boolean isAncestor)
		{
			node = n;
			this.isAncestor = isAncestor;
		}
	}
	
	//for findCommonAncestor4
	public static nodeResult findAncestor2(TreeNode root, TreeNode first, TreeNode second)
	{
		if(root == null)
		{
			return new nodeResult(null, false);
		}
		
		if(root == first && root == second)
		{
			return new nodeResult(root, true);
		}
		
		nodeResult leftResult = findAncestor2(root.left, first, second);
		if(leftResult.isAncestor == true)
		{
			return leftResult;
		}
		
		nodeResult rightResult = findAncestor2(root.right, first, second);
		if(rightResult.isAncestor == true)
		{
			return rightResult;
		}
		
		if(leftResult.node != null && rightResult.node != null)
		{
			return new nodeResult(root, true);
		}
		else if(root == first || root == second)
		{
			boolean isAncestor = leftResult.node != null || rightResult.node != null;
			return new nodeResult(root, isAncestor);
		}
		else 
		{
			return new nodeResult(leftResult.node != null ? leftResult.node : rightResult.node, false);
		}
	}
	
	//for findCommonAncestor3
	public static TreeNode findAncestor(TreeNode root, TreeNode first, TreeNode second)
	{
		if(root == null || first == root || second == root)
			return root;
		
		boolean firstLeft = searchSubTree(root.left, first);
		boolean secondLeft = searchSubTree(root.left, second);
		if(firstLeft != secondLeft)
		{
			return root;
		}
		TreeNode subTree = firstLeft ? root.left : root.right;
		
		return findAncestor(subTree, first, second);
	}
	
	//for findCommonAncestor2
	public static TreeNode findSibling(TreeNode node)
	{
		if(node == null || node.parent == null)
			return null;
		return node.parent.left == node ? node.parent.right : node.parent.left;
	}
	
	//for findCommonAncestor2 and findCommonAncestor3
	public static boolean searchSubTree(TreeNode root, TreeNode node)
	{
		if(root == null)
			return false;
		if(root == node)
			return true;
		return searchSubTree(root.left, node) || searchSubTree(root.right, node);
	}
}
