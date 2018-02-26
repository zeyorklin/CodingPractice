package DataStructuresHelpers;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int size = 0;
	
	public TreeNode(int d)
	{
		data = d;
		size = 1;
	}
	
	public void setLeftChild(TreeNode left)
	{
		this.left = left;
		if(left != null)
			left.parent = this;
	}
	
	public void setRightChild(TreeNode right)
	{
		this.right = right;
		if(right != null)
			right.parent = this;
	}
	
	public int size()
	{
		return size;
	}
	
	public int height()
	{
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
