package stackAndQueuePractice;

public abstract class Q6_animal {
	public int order;
	public String animal_name;
	
	public Q6_animal(String name)
	{
		animal_name = name;
	}
	
	public abstract String animal_name();
	
	public void setOrder(int order)
	{
		this.order = order;
	}
	
	public int getOrder()
	{
		return order;
	}
	
	public boolean isOlderThan(Q6_animal a)
	{
		return this.order < a.order;
	}
}
