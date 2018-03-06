package treesAndGraphs;
import DataStructuresHelpers.TreeNode;

public class BST_MinHeight {
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = createMinHeightBST(array);
		TreeNode node = root.find(5);
		System.out.println(node.data + " is at depth " + node.getDepth());
		System.out.println("Root of the tree is: " + root.data);
		System.out.println("Height of the tree is: " + root.height());
	}
	
	public static TreeNode createMinHeightBST(int array[])
	{
		return createMinHeightBST(array, 0, array.length - 1);
	}
	
	public static TreeNode createMinHeightBST(int array[], int start, int end)
	{
		if(end < start)
			return null;
		
		int mid = (end + start)/2;
		TreeNode node = new TreeNode(array[mid]);
		node.setLeftChild(createMinHeightBST(array, start, mid -1));
		node.setRightChild(createMinHeightBST(array, mid + 1, end));
		return node;
	}
}
