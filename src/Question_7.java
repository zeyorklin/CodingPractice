

public class Question_7 {
	
	
	public static void main(String[] args)
	{
		int[][] matrix = randomMatrix(6, 6, 0, 9);
		printMatrix(matrix);
		System.out.println();
		rotate(matrix);
		printMatrix(matrix);
	}
	
	public static void rotate(int[][] matrix)
	{
		int n = matrix.length;
		for(int layer = 0; layer < n/2; layer++)
		{
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++)
			{
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
	
	public static int[][] randomMatrix(int M, int N, int min, int max)
	{
		int[][] matrix = new int[M][N];
		for(int i=0; i < M; i++)
		{
			for(int j=0; j<N; j++)
				matrix[i][j] = (int) (Math.random() * ((max - min) + 1));
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[i].length; j++)
			{
				System.out.print("  " + matrix[i][j]);
			}
			System.out.println();
		}
	}
}
