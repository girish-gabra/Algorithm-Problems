/* 
Given an unsorted array of integers, find a subarray which adds to a given number. If there are more than one subarrays with sum as the given number, print any of them.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Ouptut: Sum found between indexes 0 to 3

Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
Ouptut: No subarray with given sum exists

Should handle negative numbers. 
*/

package geeksforgeeks;
import java.util.*;
class SubArraySum
{

	public static void subArraysum(int[] a, int sum)
	{
		// O(n^2) solution
		/*int curr_sum=0;
		for(int i=0;i<a.length;i++)
		{
			curr_sum = a[i];
			for(int j=i+1;j<a.length;j++)
			{
				if(curr_sum == sum)
				{
					System.out.println("Sum found between index "+i+" and "+(j-1));
					return;
				}
				curr_sum+=a[j];
			}
		}	
		System.out.println("No subarray found");*/
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int curr_sum=0;

		for(int i=0;i<a.length;i++)
		{
			curr_sum+=a[i];

			if(curr_sum == sum){
				System.out.println("Sum found between index 0 and "+i);
				return;
			}

			if(map.containsKey(curr_sum-sum)){
				System.out.println("Sum found between "+(map.get(curr_sum-sum)+1)+" and "+i);
				return;
			}

			map.put(curr_sum,i);
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
			System.out.println("Enter the sum ");
			int sum = sc.nextInt();
			subArraysum(a,sum);
			sc.close();
		}

}