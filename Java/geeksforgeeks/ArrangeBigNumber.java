/*

Arrange given numbers to form the biggest number

Given an array of numbers, arrange them in a way that yields the largest value. For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.

*/
package geeksforgeeks;
import java.util.*;
class ArrangeBigNumber
{

	static class MyComparator implements Comparator<Integer>
	{
		public int compare(Integer a, Integer b)
		{
			String str1 = a.toString()+b.toString();
			String str2 = b.toString()+a.toString();

			if(str1.compareTo(str2)>0){
				return -1;
			}else{
				return 1;
			}
		}
	}

	public static String calculateLargest(int[] a)
	{
			StringBuilder result = new StringBuilder();
			Integer[] arr = new Integer[a.length];

			for(int i=0;i<a.length;i++)
				arr[i]=a[i];

			Arrays.sort(arr, new MyComparator());

			for(Integer num : arr){
				result.append(String.valueOf(num));
			}		
			return result.toString();
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
			
			String res = calculateLargest(a);
			System.out.println("Largest Number formed: "+res);
			sc.close();
		}
}