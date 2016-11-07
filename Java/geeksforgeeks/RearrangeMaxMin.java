/*

Rearrange an array in maximum minimum form

Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value, second minimum value, third second max, fourth second min and so on.

Examples:

Input  : arr[] = {1, 2, 3, 4, 5, 6, 7} 
Output : arr[] = {7, 1, 6, 2, 5, 3, 4}

Input  : arr[] = {1, 2, 3, 4, 5, 6} 
Output : arr[] = {6, 1, 5, 2, 4, 3}

Expected time complexity is O(n)
*/

package geeksforgeeks;
import java.util.*;
class RearrangeMaxMin
{
	

	public static void rearrange(int[] a)
	{
		int n = a.length;

		for(int i=0;i<a.length;i++)
		{
			int temp = a[i];
			//System.out.println("i: "+i+" temp:"+temp);
			// If number is negative then we have already
        	// processed it. Else process all numbers which
        	// are to be replaced by each other in cyclic way	
			while(temp>0)
			{
				int j = (i < n/2) ? 2*i+1 : 2*(n-1-i);

				if(j==i)
				{
					a[j]=-a[j];
					break;
				}
				// Swap the number with the temp
					int p = temp;
					temp = a[j];
					a[j]=p;	

				 // Mark the number as processed
				if(a[j]>0){
					a[j]=-a[j];
				}

				// Next process the previous number at target position
				i=j;	
			}	

		}

		//Make all numbers positive
		for(int i=0;i<n;i++)
		{
			if(a[i]<0){
				a[i]=-a[i];
			}
		}	
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
			rearrange(a);
			System.out.println("After rearranging elements are: ");
			for(int i=0;i<n;i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();

			sc.close();
		}
}			