
public class Question_5 {
	
	public static void main(String[] args)
	{
		String s1 = "pale";
		String s2 = "palee";
		System.out.println(s1 + ", " + s2 + " -> " + checkEdits2(s1, s2));
	}
	
	public static boolean checkEdits(String s1, String s2)
	{
		if(s1.length() == s2.length())
		{
			return editReplace(s1, s2);
		}
		else if(s1.length() - 1 == s2.length())
		{
			return editInsert(s2, s1);
		}
		else if(s1.length() + 1 == s2.length())
		{
			return editInsert(s1, s2);
		}
		return false;
	}
	
	public static boolean editReplace(String s1, String s2)
	{
		boolean foundDiff = false;
		for(int i=0; i< s1.length(); i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				if(foundDiff)
					return false;
				foundDiff = true;
			}
		}
		return true;
	}
	
	public static boolean editInsert(String s1, String s2)
	{
		//System.out.println(s1.length() + " " + s2.length());
		int index1 = 0;
		int index2 = 0;
		
		while(index1 < s1.length() && index2 < s2.length())
		{
			if(s1.charAt(index1) != s2.charAt(index2))
			{
				if(index1 != index2)
					return false;
				index2 ++;
			}
			else
			{
				index1 ++;
				index2 ++;
			}
		}
		
		return true;
	}
	
	public static boolean checkEdits2(String s1, String s2)
	{
		if(Math.abs(s1.length() - s2.length()) > 1)
			return false;
		
		String string1 = s1.length() < s2.length() ? s1 : s2;
		String string2 = s1.length() < s2.length() ? s2 : s1;
		int index1 = 0, index2 = 0;
		boolean foundDiff = false;
		
		while(index1 < string1.length() && index2 < string2.length())
		{
			if(string1.charAt(index1) != string2.charAt(index2))
			{
				if(foundDiff)
					return false;
				foundDiff = true;
				if(string1.length() == string2.length())
					index1++;
			}
			else
				index1 ++;
			index2 ++;
		}
		
		return true;
	}
	
}
