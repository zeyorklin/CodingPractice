
public class Question_1 {
	public static boolean isUnique(String str)
	{
		if(str.length() > 128)
			return false;
		boolean[] char_set = new boolean[128];
		
		for(int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i);
			System.out.println(val);
			if(char_set[val])
			{
				System.out.println("duplicate word at " + val);
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	public static boolean isUniqueReduced(String str)
	{
		
		return true;
	}
	
	public static void main (String[] args)
	{
		String[] words = {"abcde", "asdasdsa", "123"};
		for(String word: words)
		{
			System.out.println(word + ": " + isUnique(word));
		}
		
	}
}
