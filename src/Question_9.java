
public class Question_9 {
	public static void main(String[] args)
	{
		String original = "waterbottle";
		String rotated = "erbottlewat";
		System.out.println(original + " , " + rotated  + " : " + isRotation(original, rotated));
	}
	
	public static boolean isRotation(String original, String rotated)
	{
		if(original.length() != rotated.length())
			return false;
		String combined = original + original;
		return isSubstring(combined, rotated);
	}
	
	public static boolean isSubstring(String combined, String rotated)
	{
		if(combined.indexOf(rotated) >= 0)
			return true;
		else
			return false;
	}
}
