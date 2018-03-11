package bitManipulation;

public class doubleToBinary {
	public static void main(String[] args)
	{
		double value = 0.625;
		System.out.println(doubleBinary2(value));
	}
	
	public static String doubleBinary(double n)
	{
		if(n > 1 || n < 0)
			return "ERROR";
		StringBuilder binaryString = new StringBuilder();
		binaryString.append("0.");
		double fraction = 0.5;
		while(n > 0)
		{
			if(binaryString.length() > 32)
			{
				return "ERROR";
			}
			else if(n >= fraction)
			{
				binaryString.append(1);
				n = n-fraction;
			}
			else 
			{
				binaryString.append(0);
			}
			fraction = fraction/2;
		}
		return binaryString.toString();
	}
	
	public static String doubleBinary2(double n)
	{
		if(n>1||n<0)
			return "ERROR";
		StringBuilder binaryString = new StringBuilder();
		binaryString.append("0.");
		
		while(n>0)
		{
			if(binaryString.length()>32)
			{
				return "ERROR";
			}
			n = n*2;
			if(n >= 1)
			{
				binaryString.append(1);
				n = n-1;
			}
			else
			{
				binaryString.append(0);
			}
		}
		return binaryString.toString();
	}
}
