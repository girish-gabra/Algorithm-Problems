// CTCI 1.7 Rotate Matrix --- 90 degrees
package CTCI;
import java.util.*;
public class RotateMatrix
{

	public static void rotateInPlace(int[][] matrix)
	{
		int n = matrix.length;

		for(int count=0; count<n/2; count++)
		{
			int first = count;
			int last = n-1-count;

			for(int i=first; i<last;i++)
			{
				int offset = i-first;

				int top = matrix[first][i];
				
				// left --> top
				matrix[first][i] = matrix[last-offset][first];

				//bottom -->left
				matrix[last-offset][first] = matrix[last][last-offset];

				// right -->bottom
				matrix[last][last-offset] = matrix[i][last];

			    // top->right
				matrix[i][last] = top;				

			}

		}

		System.out.println("Matrix after rotation ");

		for(int i=0; i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

	}

	
	public static void rotate(int[][] matrix)
	{
		int n = matrix.length;
		int[][] result = new int[n][n];

		int k = n-1;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				result[j][k] = matrix[i][j] ;
			}
			k--;
		}

		System.out.println("Matrix after rotation is: ");
		for(int i=0;i<n;i++)
		{
			for(int j=0; j<n;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}

	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int[][] matrix;

		int n = s.nextInt();
		matrix = new int[n][n];

		for(int i=0;i<n;i++)
		{
			for(int j=0; j<n;j++)
			{
				matrix[i][j] = s.nextInt();
			}
		}

		// This uses additional space
		rotate(matrix);

		// This is in-place rotation
		rotateInPlace(matrix);
		s.close();
	}


}