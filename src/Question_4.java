
public class Question_4 {
	
	public static void main(String args[])
	{
		String phrase = "taco cat";
		System.out.println(phrase + " is palindrome is " + checkPalindrome(phrase));
	}
	
	public static boolean checkPalindrome(String phrase)
	{
		int[] table = createPalindromeTable(phrase);
		return checkNumOfOdd(table);
	}
	
	public static boolean checkPalindrome2(String phrase)
	{
		return true;
	}
	
	public static boolean checkNumOfOdd(int[] table)
	{
		boolean singleOdd = false;
		for(int indexCount : table)
		{
			if(indexCount % 2 == 1)
			{
				if(singleOdd)
					return false;
				singleOdd = true;
			}
		}
		return true;
	}
	
	public static int createAlphabetNum (char c)
	{
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a<= val && z >= val)
		{
			return val - a;
		}
		return -1;
	}
	
	public static int[] createPalindromeTable(String phrase)
	{
		int[] table = new int[24];
		for(char c: phrase.toCharArray())
		{
			int index = createAlphabetNum(c);
			//System.out.println(index);
			if(index != -1)
				table[index] ++;
		}
		return table;
	}
	
}
