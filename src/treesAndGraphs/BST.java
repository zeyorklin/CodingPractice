package treesAndGraphs;
import java.util.Random;

import DataStructuresHelpers.TreeNode;

public class BST {
	BSTNode root = null;
	public int size()
	{
		return root == null ? 0 : root.size;
	}
	
	public void insert(int data)
	{
		if(root == null)
		{
			root = new BSTNode(data);
		}
		else
		{
			root.insert(data);
		}
	}
	
	public BSTNode getRandomNode()
	{
		Random random = new Random();
		int index = random.nextInt(size());
		return root.getSpecificNode(index);
	}
}
