package stackAndQueuePractice;

public class Q6_question {
	public static void main(String[] args)
	{
		Q6_animalQueue animals = new Q6_animalQueue();
		animals.add(new Q6_dog("d1"));
		animals.add(new Q6_cat("c1"));
		animals.add(new Q6_cat("c2"));
		animals.add(new Q6_cat("c3"));
		animals.add(new Q6_dog("d2"));
		animals.add(new Q6_cat("c4"));
		animals.add(new Q6_dog("d3"));
		System.out.println(animals.removeAnimal().animal_name);
		System.out.println(animals.removeCat().animal_name);
		System.out.println(animals.removeDog().animal_name);
		System.out.println(animals.removeAnimal().animal_name);
	}
}
