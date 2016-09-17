
/*Maximize number of 0s by flipping a subarray

Given a binary array, find the maximum number zeros in an array with one flip of a subarray allowed. A flip operation switches all 0s to 1s and 1s to 0s.

Examples:

Input :  arr[] = {0, 1, 0, 0, 1, 1, 0}
Output : 6
We can get 6 zeros by flipping the subarray {1, 1}

Input :  arr[] = {0, 0, 0, 1, 0, 1}
Output : 5
*/

package geeksforgeeks;
import java.util.*;
class MaxZerosByFlipping
{
	
	public static int maxZerosByFlip(int[] a )
	{
		//approach similar to kandane algorithm. Time complexity O(n)
		int originalZeros = 0;
		int maxDiff  = 0;
		int currMax = 0;
		for(int i=0; i<a.length;i++)
		{
			if(a[i]==0){
				originalZeros++;
			}

			int val = a[i]==1?1:-1;

			currMax = Math.max(val,currMax+val);
			maxDiff = Math.max(maxDiff,currMax);
		}

		return originalZeros+maxDiff;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements for array");
		int n  = sc.nextInt();
		System.out.println("Enter elements for array");
		int[] a = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		int numZeros = maxZerosByFlip(a);
		System.out.println("Max Zeros after flipping one subarray: "+numZeros);
		sc.close();
	}


}