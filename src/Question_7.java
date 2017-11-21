

public class Question_7 {
	
	
	public static void main(String[] args)
	{
		int[][] matrix = randomMatrix(6, 6, 0, 9);
		printMatrix(matrix);
		System.out.println();
		int[][] result = rotate(matrix);
		printMatrix(result);
	}
	
	public static int[][] rotate(int[][] matrix)
	{
		int[][] result = matrix;
		int n = matrix.length;
		for(int layer = 0; layer < n/2; layer++)
		{
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++)
			{
				int offset = i - first;
				int top = matrix[first][i];
				result[first][i] = matrix[last - offset][first];
				result[last - offset][first] = matrix[last][last - offset];
				result[last][last - offset] = matrix[i][last];
				result[i][last] = top;
			}
		}
		return result;
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
				System.out.print(" ");
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
}
