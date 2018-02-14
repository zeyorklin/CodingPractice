package stackAndQueuePractice;
import java.nio.file.attribute.DosFileAttributes;
import java.util.LinkedList;

public class Q6_animalQueue {
	LinkedList<Q6_cat> cats = new LinkedList<Q6_cat>();
	LinkedList<Q6_dog> dogs = new LinkedList<Q6_dog>();
	int order = 0;
	
	public void add(Q6_animal a)
	{
		a.setOrder(order);
		if(a instanceof Q6_cat)
			cats.addLast((Q6_cat)a);
		else if(a instanceof Q6_dog)
			dogs.addLast((Q6_dog)a);
		order++;
	}
	
	public Q6_animal removeAnimal()
	{
		if(dogs.size() == 0)
		{
			return cats.poll();
		}
		else if(cats.size() == 0)
		{
			return dogs.poll();
		}
		if(dogs.peek().isOlderThan(cats.peek()))
		{
			return dogs.poll();
		}
		else
		{
			return cats.poll();
		}
	}
	
	public Q6_dog removeDog()
	{
		return dogs.poll();
	}
	
	public Q6_cat removeCat()
	{
		return cats.poll();
	}
	
	public int size()
	{
		return dogs.size() + cats.size();
	}
}
