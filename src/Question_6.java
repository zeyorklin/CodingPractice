
public class Question_6 {
	
	public static void main(String[] args)
	{
		String toCompress = "aabbbcc";
		System.out.println(toCompress + " becomes " + compressString(toCompress));
	}
	
	public static String compressString(String toCompress)
	{
		StringBuilder results = new StringBuilder();
		int compressedNum = 0;
		if(countCompressed(toCompress) >= toCompress.length())
			return toCompress;
		
		for(int i=0; i< toCompress.length(); i++)
		{
			compressedNum ++;
			if(i+1>=toCompress.length() || toCompress.charAt(i) != toCompress.charAt(i+1) )
			{
				results.append(toCompress.charAt(i));
				results.append(compressedNum);
				compressedNum = 0;
			}
			
		}
		
		return results.toString();
		//return results.length() < toCompress.length() ? results.toString() : toCompress;
	}
	
	//wont have to use StringBuilder if not necessary
	public static int countCompressed(String toCompress)
	{
		int compressedResult = 0;
		int compressedNum = 0;
		
		for(int i=0; i<toCompress.length(); i++)
		{
			compressedNum++;
			if(i+1>=toCompress.length() || toCompress.charAt(i) != toCompress.charAt(i+1))
			{
				compressedResult += 1 + String.valueOf(compressedNum).length();
				compressedNum=0;
			}
		}
		System.out.println(compressedResult);
		return compressedResult;
	}
	
}
