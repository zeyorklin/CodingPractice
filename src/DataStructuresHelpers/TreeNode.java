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
	
	public int getDepth()
	{
		int depth = 0;
		TreeNode node = this;
		while(node != null)
		{
			node = node.parent;
			depth ++;
		}
		return depth;
	}
	
	public TreeNode find(int data)
	{
		if(this.data == data)
		{
			return this;
		}
		else if(data <= this.data){
			return left != null ? left.find(data) : null;
		}
		else if(data > this.data)
		{
			return right != null ? right.find(data) : null;
		}
		
		return null;
	}
	
	public void insert (int d)
	{
		if(d <= data)
		{
			if(left == null)
				setLeftChild(new TreeNode(d));
			else
				left.insert(d);
		}
		else 
		{
			if(right == null)
				setRightChild(new TreeNode(d));
			else
				right.insert(d);
		}
		size++;
	}
}
