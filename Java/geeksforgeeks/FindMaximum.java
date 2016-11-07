/*

Given an array arr[], find the maximum j – i such that arr[j] > arr[i]

Given an array arr[], find the maximum j – i such that arr[j] > arr[i].

Examples:

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
*/

package geeksforgeeks;
import java.util.*;

class FindMaximum
{
	// O(n^2) is just using two for loops, below is O(n) solution with O(n) space complexity.
	// Use two auxillary arrays and compare to get the max of two indices
	public static void findMaximum(int[] a)
	{
		int maxDiff=0;
		int[] LMin = new int[a.length];
		int[] RMax = new int[a.length];

		LMin[0]=a[0];
		for(int i=1;i<a.length;i++)
		{
			LMin[i] = Math.min(LMin[i-1],a[i]);
		}
		
		RMax[a.length-1] = a[a.length-1];
		for(int i=a.length-2;i>=0;i--)	
		{
			RMax[i] = Math.max(RMax[i+1],a[i]);
		}

		int i=0;
		int j=0;
		int max_diff = -1;
		System.out.println(Arrays.toString(LMin));
		System.out.println(Arrays.toString(RMax));
		while(i<a.length && j <a.length)
		{
			if(LMin[i]<RMax[j])
			{
				max_diff = Math.max(max_diff,j-i);
				//System.out.println(i+","+j+" max diff : "+max_diff +" Left "+LMin[i]+" Right "+RMax[j]);
				j++;
			}else{
				i++;
			}	
		}	

		System.out.println(max_diff);
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
		findMaximum(a);			
	}
}