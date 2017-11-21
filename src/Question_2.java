

public class Question_2 {
	public static String sort (String s)
	{
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean PermutationCheck(String s, String t)
	{
		if(s.length() != t.length())
			return false;
		return sort(t).equals(sort(s));
	}
	
	public static boolean PermutationCheck2(String s, String t)
	{
		if(s.length() != t.length())
			return false;
		
		int[] letters = new int[128];
		
		char s_array[] = s.toCharArray();
		for (char c : s_array)
		{
			letters[c]++;
		}
		
		for(int i=0; i< t.length(); i++)
		{
			int c = t.charAt(i);
			letters[c]--;
			if(letters[c] < 0)
				return false;
		}
		
		
		return true;
	}
	
	public static void main (String[] args)
	{
		System.out.println(PermutationCheck("hello", "hello1"));
		System.out.println(PermutationCheck2("hello", "hello"));
	}

}