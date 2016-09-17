
/*Find frequency of each element in a limited range array in less than O(n) time

Given an sorted array of positive integers, count number of occurrences for each element in the array. Assume all elements in the array are less than some constant M.

Do this without traversing the complete array. i.e. expected time complexity is less than O(n).

Examples:

Input: arr[] = [1, 1, 1, 2, 3, 3, 5,
               5, 8, 8, 8, 9, 9, 10] 
Output:
Element 1 occurs 3 times
Element 2 occurs 1 times
Element 3 occurs 2 times
Element 5 occurs 2 times
Element 8 occurs 3 times
Element 9 occurs 2 times
Element 10 occurs 1 times
*/

package geeksforgeeks;
import java.util.*;

class FindFrequency
{
	static int[] result;

	public static void findFrequency(int[] a)
	{
		int max = a[a.length-1];
		result = new int[max+1];	// +1 because range starts with 1

		findFrequencyUtil(a,0,a.length-1);

	}

	public static void findFrequencyUtil(int[] a, int low, int high)
	{
		if(a[low]==a[high])
		{
			result[a[low]]+=high-low+1;
		}
		else
		{
			int mid = (low+high)/2;
			findFrequencyUtil(a,low,mid);
			findFrequencyUtil(a,mid+1,high);
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
		findFrequency(a);
		System.out.println("Frequency is as follows");
		for(int i=1;i<result.length;i++)
		{
			System.out.println("Number: "+i+" Frequency: "+result[i]);
		}
		sc.close();
	}


}