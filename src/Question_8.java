
public class Question_8 {
	public static void main(String[] args)
	{
		int[][] matrix = randomMatrix(6, 6, 9, 0);
		printMatrix(matrix);
		setZeroMatrix(matrix);
		System.out.println();
		printMatrix(matrix);
	}
	
	public static void setZeroMatrix(int[][] matrix)
	{
		boolean firstRowZero = false;
		boolean firstColZero = false;
		for(int i=0; i<matrix[0].length; i++)
		{
			if(matrix[0][i] == 0)
			{
				firstRowZero = true;
				break;
			}
		}
		
		for(int i=0; i<matrix.length; i++)
		{
			if(matrix[i][0] == 0)
			{
				firstColZero = true;
				break;
			}
		}
		
		for(int i=1; i<matrix.length; i++)
		{
			for(int j=1; j<matrix[0].length; j++)
			{
				if(matrix[i][j] == 0)
				{
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i=1; i<matrix.length; i++)
		{
			if(matrix[0][i] == 0)
			{
				nullifyColumn(matrix, i);
			}
		}
		
		for(int i=1; i<matrix[0].length; i++)
		{
			if(matrix[i][0] == 0)
			{
				nullifyRow(matrix, i);
			}
		}
		
		if(firstColZero)
		{
			nullifyColumn(matrix, 0);
		}
		
		if(firstRowZero)
		{
			nullifyRow(matrix, 0);
		}
		
		
	}
	
	public static void nullifyRow(int[][] matrix, int row)
	{
		for(int i=0; i<matrix[0].length; i++)
		{
			matrix[row][i] = 0;
		}
	}
	
	public static void nullifyColumn(int[][] matrix, int column)
	{
		for(int j=0; j<matrix.length; j++)
		{
			matrix[j][column] = 0;
		}
	}
	
	public static int[][] randomMatrix(int M, int N, int max, int min)
	{
		int[][] matrix = new int[M][N];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				matrix[i][j] = (int)(Math.random() * (max - min + 1));
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				System.out.print("  " + matrix[i][j]);
			}
			System.out.println();
		}
	}
}
