package bitManipulation;

import DataStructuresHelpers.HelperFunctions;

public class Q4_NextNumber {
	public static void main(String[] args)
	{
		printSolutionLarge(13948);
		printSolutionSmall(13948);
	}
	
	public static void printSolutionLarge(int value)
	{
		System.out.println("Find next largest for " + value);
		System.out.println(HelperFunctions.numToBitString(value));
		System.out.println(getNext(value));
		System.out.println(HelperFunctions.numToBitString(getNext(value)));
		System.out.println(HelperFunctions.numToBitString(getNext2(value)));
	}
	
	public static void printSolutionSmall(int value)
	{
		System.out.println("Find next smallest for " + value);
		System.out.println(HelperFunctions.numToBitString(value));
		System.out.println(getPrev(value));
		System.out.println(HelperFunctions.numToBitString(getPrev(value)));
		System.out.println(HelperFunctions.numToBitString(getPrev2(value)));
	}
	
	public static int getNext(int value)
	{
		int n = value;
		int bitZero = 0;
		int bitOne = 0;
		
		while((n & 1) == 0 && n != 0)
		{
			bitZero ++;
			n >>>= 1;
		}
		
		while((n & 1) == 1 && n != 0)
		{
			bitOne ++;
			n >>>= 1;
		}
		
		int flippedBit = 1 << (bitOne + bitZero);
		//System.out.println(HelperFunctions.numToBitString(value | flippedBit));
		value &= ~(flippedBit - 1);
		//System.out.println(HelperFunctions.numToBitString(value));
		int newOne = (1 << (bitOne-1)) - 1;
		return value | (flippedBit | newOne);
	}
	
	public static int getNext2(int value)
	{
		int n = value;
		int bitZero = 0;
		int bitOne = 0;
		
		while((n & 1) == 0 && n != 0)
		{
			bitZero ++;
			n >>>= 1;
		}
		
		while((n & 1) == 1 && n != 0)
		{
			bitOne ++;
			n >>>= 1;
		}
		
		return value + (1 << bitZero) + (1 << (bitOne - 1)) - 1;
	}
	
	public static int getPrev(int value)
	{
		int n = value;
		int bitZero = 0;
		int bitOne = 0;
		
		while((n & 1) == 1 && n!= 0)
		{
			bitOne ++;
			n >>>= 1;
		}
		
		while((n & 1) == 0 && n!= 0)
		{
			bitZero ++;
			n >>>= 1;
		}
		int flippedBit = ~((1 << (bitOne + bitZero + 1)) - 1);
		value &= value & flippedBit;
		//System.out.println(HelperFunctions.numToBitString(flippedBit));
		//System.out.println(HelperFunctions.numToBitString(value));
		int newOne = (1 << (bitOne + 1)) - 1;
		newOne = newOne << (bitZero - 1);
		//System.out.println(HelperFunctions.numToBitString(newOne));
		return value | newOne;
	}
	
	public static int getPrev2(int value)
	{
		int n = value;
		int bitZero = 0;
		int bitOne = 0;
		
		while((n & 1) == 1 && n!= 0)
		{
			bitOne ++;
			n >>>= 1;
		}
		
		while((n & 1) == 0 && n!= 0)
		{
			bitZero ++;
			n >>>= 1;
		}
		
		return value - (1 << (bitZero-1)) - (1<<bitOne) + 1;
	}
}
