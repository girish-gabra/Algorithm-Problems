
/*Reverse an array in groups of given size

Given an array, reverse every sub-array formed by consecutive k elements.

Input: 
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
k = 3
Output:  
[3, 2, 1, 6, 5, 4, 9, 8, 7]

Input: 
arr = [1, 2, 3, 4, 5, 6, 7, 8]
k = 5
Output:  
[5, 4, 3, 2, 1, 8, 7, 6]

Input: 
arr = [1, 2, 3, 4, 5, 6]
k = 1
Output:  
[1, 2, 3, 4, 5, 6]

Input: 
arr = [1, 2, 3, 4, 5, 6, 7, 8]
k = 10
Output:  
[8, 7, 6, 5, 4, 3, 2, 1]
*/
// O(n) solution with O(1) space
package geeksforgeeks;
import java.util.*;
class ReverseKGroup
{
	public static int min(int a, int b)
	{
		return a<b?a:b;
	}

	public static void reverseKGroup(int[] a , int k)
	{

		for(int i=0;i<a.length;i=i+k)
		{
			int left = i;
			int right = min(i+k-1,a.length-1);		// to handle case where k is not multuple of n;

			while(left < right)
			{
				int temp = a[left];
				a[left]=a[right];
				a[right]=temp;
				left++;
				right--;
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
		System.out.println("Enter k ");
		int k = sc.nextInt();
		reverseKGroup(a,k);
		System.out.println("Array after reversal");
		System.out.println(Arrays.toString(a));
		sc.close();
	}


}