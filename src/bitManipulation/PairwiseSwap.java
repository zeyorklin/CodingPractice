package bitManipulation;

import DataStructuresHelpers.HelperFunctions;

public class PairwiseSwap {
	public static void main(String[] args)
	{
		numSwap(12373);
	}
	
	public static int numSwap(int value)
	{
		int evenSwap = (value & 0xaaaaaaaa) >>> 1;
		
		int oddSwap = (value & 0x55555555) << 1;
		System.out.println(HelperFunctions.numToBitString(value));
		System.out.println(HelperFunctions.numToBitString(evenSwap | oddSwap));
		return evenSwap | oddSwap;
	}
}
