/*

Count all possible groups of size 2 or 3 that have sum as multiple of 3

Given an unsorted integer (positive values only) array of size ‘n’, we can form a group of two or three, the group should be such that the sum of all elements in that group is a multiple of 3. Count all possible number of groups that can be generated in this way.

Input: arr[] = {3, 6, 7, 2, 9}
Output: 8
// Groups are {3,6}, {3,9}, {9,6}, {7,2}, {3,6,9},
//            {3,7,2}, {7,2,6}, {7,2,9}


Input: arr[] = {2, 1, 3, 4}
Output: 4
// Groups are {2,1}, {2,4}, {2,1,3}, {2,4,3}

*/

package geeksforgeeks;
import java.util.*;

class CountGroups
{
	//O(n) solution
	public static int getCount(int[] a)
	{
		int count = 0;

		//remainder[i] would store count of elements with remainder i
		int[] remainder = new int[3];

		for(int i=0;i<a.length;i++){
			remainder[a[i]%3]++;
		}

		//calculate groups of size 2, 2 possible cases
		count+=remainder[0]*(remainder[0]-1)/2;	// case when the the number is divisible by 3

		count+=remainder[1]*remainder[2];	// case when one element is of remainder 1 and one of remainder 2

		// calculate groups of 3, 4 possible cases

		count+=remainder[0]*(remainder[0]-1)*(remainder[0]-2)/6; // case when all three numbers have remainder 0

		count+=remainder[1]*(remainder[1]-1)*(remainder[1]-2)/6; // case when all three numbers have remainder 1

		count+=remainder[2]*(remainder[2]-1)*(remainder[2]-2)/6; // case when all three numbers have remainder 3

		count+=remainder[0]*remainder[1]*remainder[2];	// case when all three have different remainders 			

		return count;
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
			int count = getCount(a);
			System.out.println("Number of groups: "+count);
			sc.close();
		}
}