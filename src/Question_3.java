
public class Question_3 {

	public static String replaceSpace(String x, int length)
	{
		char s[] = x.toCharArray();
		String result = null;
		int spacecount = 0;
		for(int i =0; i < length; i++)
		{
			if(s[i] == ' ')
				spacecount ++;
		}
		int new_length = length + spacecount*2;
		char[] newline = new char[new_length];
		
		for(int i =  length -1; i >= 0; i--)
		{
			if(s[i] == ' ')
			{
				newline[new_length -1] = '0';
				newline[new_length -2] = '2';
				newline[new_length -3] = '%';
				new_length = new_length - 3;
			}
			else
			{
				newline[new_length - 1] = s[i];
				new_length = new_length - 1;
			}
		}
		result = new String(newline);
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(replaceSpace("Mr John Smith   ", 13));
	}
	
}
