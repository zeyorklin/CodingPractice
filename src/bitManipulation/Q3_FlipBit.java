package bitManipulation;

import DataStructuresHelpers.HelperFunctions;

public class Q3_FlipBit {
	public static void main(String[] args)
	{
		int input = 1465;
		System.out.println(HelperFunctions.numToBitString(input));
		System.out.println(bitFlip(input));
	}
	
	public static int bitFlip(int input)
	{
		int currenLength = 0;
		int previousLength = 0;
		int maxLength = 1;
		while(input != 0)
		{
			if((input & 1) == 1 )
			{
				currenLength ++;
			}
			else if((input & 1) == 0)
			{
				previousLength = (input & 2) == 0 ? 0:currenLength;
				currenLength = 0;
			}
			
			maxLength = Math.max(currenLength + previousLength + 1, maxLength);
			
			input >>>= 1;
		}
		return maxLength;
	}
	
	
}
