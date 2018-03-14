package bitManipulation;

import DataStructuresHelpers.HelperFunctions;

public class Q6_flipToNumber {
	public static void main(String[] args)
	{
		int n = 29;
		int m = 15;
		System.out.println(HelperFunctions.numToBitString(n));
		System.out.println(HelperFunctions.numToBitString(m));
		System.out.println(HelperFunctions.numToBitString(n^m));
		System.out.println(bitsToFlip(n, m));
		System.out.println(bitsToFlip2(n, m));
	}
	
	public static int bitsToFlip(int n, int m)
	{
		int xorValue = n^m;
		int counter = 0;
		while(xorValue != 0)
		{
			if((xorValue & 1) == 1)
			{
				counter ++;
			}
			xorValue >>>= 1;
		}
		return counter;
	}
	
	public static int bitsToFlip2(int n, int m)
	{
		int counter = 0;
		for(int c = n^m; c!= 0; c &= (c-1))
		{
			counter ++;
		}
		return counter;
	}
}
