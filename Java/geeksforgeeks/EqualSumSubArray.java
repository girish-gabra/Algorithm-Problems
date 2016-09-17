
/*Find if array can be divided into two subarrays of equal sum

Given an array of integers, find if it’s possible to remove exactly one integer from the array that divides the array into two subarrays with the same sum.

Examples:

Input:  arr = [6, 2, 3, 2, 1]
Output:  true
Explanation:  On removing element 2 at index 1,
the array gets divided into two subarrays [6]
 and [3, 2, 1] having equal sum

Input:  arr = [6, 1, 3, 2, 5]
Output:  true
Explanation:  On removing element 3 at index 2,
the array gets divided into two subarrays [6, 1]
and [2, 5] having equal sum.

Input:  arr = [6, -2, -3, 2, 3]
Output: true
Explanation:  On removing element 6 at index 0, 
the array gets divided into two sets [] 
and [-2, -3, 2, 3] having equal sum

Input:  arr = [6, -2, 3, 2, 3]
Output: false
*/
package geeksforgeeks;
import java.util.*;
class EqualSumSubArray
{

	public static void printArray(int[] a, int from, int to)
	{
		for(int i=from;i<=to;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static boolean isExistEqualSubArray(int[] a)
	{
		int left = 0;
		int right = 0;

		for(int i=0;i<a.length;i++)
		{
			right+=a[i];
		}

		// other formula is if 2 * sum_so_far + arr[i] == sum  return true
		for(int i=0;i<a.length;i++)
		{
			if(i!=0)	left+=a[i-1];
			right-=a[i];

			if(left == right){
				System.out.print("Left subarray:");
				printArray(a,0,i-1);
				System.out.print("Right subarray:");
				printArray(a,i+1,a.length-1);
				return true;
			}
		}

		return false;

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
			if(isExistEqualSubArray(a)){
				System.out.println("True");
			}else{
				System.out.println("Subarray with equal sum does not exist");
			}
			
			sc.close();
		}	
}