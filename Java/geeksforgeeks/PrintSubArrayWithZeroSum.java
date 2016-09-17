
/*Print all subarrays with 0 sum

Given an array, print all subarrays in the array which has sum 0.

Examples:

Input:  arr = [6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7]
Output:  
Subarray found from Index 2 to 4
Subarray found from Index 2 to 6          
Subarray found from Index 5 to 6
Subarray found from Index 6 to 9
Subarray found from Index 0 to 10

Naive approach is to find all subarrays and check if their sum is 0. Time complexity is O(n^2)*/

package geeksforgeeks;
import java.util.*;

class PrintSubArrayWithZeroSum
{
	static class Range
	{
		int from;
		int to;

		Range(int from, int to)
		{
			this.from=from;
			this.to=to;
		}
	}
	public static void printSubArray(int[] a)
	{
		int currentSum=0;
		List<Range> list = new ArrayList<Range>();

		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();

		for(int i=0;i<a.length;i++)
		{
			currentSum +=a[i];

			if(currentSum==0){
				Range range  = new Range(0,i);
				list.add(range);
			}

			if(map.containsKey(currentSum))
			{
				List<Integer> newList = map.get(currentSum);

				for(Integer index : newList)
				{
					Range range = new Range(index+1,i);
					list.add(range);
				}
				map.get(currentSum).add(i);	

			}else{
				List<Integer> newlist = new ArrayList<Integer>();
				newlist.add(i);
				map.put(currentSum,newlist);
			}

			
		}	

		// print the range list
		for(Range range : list)
		{
			System.out.println("["+range.from+","+range.to+"]");
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
		printSubArray(a);
		
		sc.close();
	}


}