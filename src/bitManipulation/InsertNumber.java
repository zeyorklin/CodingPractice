package bitManipulation;
import DataStructuresHelpers.*;

public class InsertNumber {
	public static void main(String[] args)
	{
		int n = 2049;
		int m = 19;
		int result = insertNumber(n, m, 2, 6);
		System.out.println(HelperFunctions.numToBitString(n, 16));
		System.out.println(HelperFunctions.numToBitString(m, 16));
		System.out.println(HelperFunctions.numToBitString(result, 16));
	}
	
	public static int insertNumber(int n, int m, int i, int j)
	{
		if(j<i || i > 32)
			return 0;
		
		int allOnes = ~0;
		int leftSide = allOnes << (j + 1);
		int rightSide = ((1<<i) - 1);
		int mask = leftSide | rightSide;
		
		int n_cleared = n & mask;
		int m_shifted = m << i;
		
		return n_cleared | m_shifted;
	}
	
}
