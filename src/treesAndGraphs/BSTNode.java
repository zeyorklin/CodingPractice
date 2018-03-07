package treesAndGraphs;
import java.util.Random;

public class BSTNode {
	public int data;
	private BSTNode left;
	private BSTNode right;
	public int size = 0;
	
	public BSTNode(int data)
	{
		this.data = data;
		size=1;
	}
	
	public BSTNode getRandomNode()
	{
		int leftSize = left==null ? 0 : left.size;
		Random random = new Random();
		int index = random.nextInt(size);
		if(index == leftSize)
		{
			return this;
		}
		else if(index < leftSize)
		{
			return left.getRandomNode();
		}
		else 
		{
			return right.getRandomNode();
		}
		
	}
	
	public BSTNode getSpecificNode(int index)
	{
		int leftsize = left==null ? 0 : left.size;
		
		if(index < leftsize)
		{
			return getSpecificNode(index);
		}
		else if(index == leftsize)
		{
			return this;
		}
		else {
			return getSpecificNode(index - leftsize - 1);
		}
	}
	
	public void insert(int data)
	{
		if(data <= this.data)
		{
			if(left == null)
			{
				this.left = new BSTNode(data);
			}
			else
			{
				left.insert(data);
			}
		}
		else {
			if(right == null)
			{
				this.right = new BSTNode(data);
			}
			else
			{
				right.insert(data);
			}
		}
		size++;
	}
	
	public BSTNode find(int data)
	{
		if(this.data == data)
		{
			return this;
		}
		else if(data <= this.data)
		{
			return left != null ? left.find(data) : null;
		}
		else if(data >= this.data)
		{
			return right != null ? right.find(data) : null;
		}
		return null;
	}
	
	public int size() {return size;}
	public int data() {return data;}
	
	
}
