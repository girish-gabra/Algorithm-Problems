/*
You are given an unsorted array with both positive and negative elements. You have to find the smallest positive number missing from the array in O(n) time using constant extra space. You can modify the original array.

Examples

 Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 Output: 1

 Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 Output: 4

 Input: {1, 1, 0, -1, -2}
 Output: 2 


A naive method to solve this problem is to search all positive integers, starting from 1 in the given array. We may have to search at most n+1 numbers in the given array. So this solution takes O(n^2) in worst case.

We can use sorting to solve it in lesser time complexity. We can sort the array in O(nLogn) time. Once the array is sorted, then all we need to do is a linear scan of the array. So this approach takes O(nLogn + n) time which is O(nLogn).

We can also use hashing. We can build a hash table of all positive elements in the given array. Once the hash table is built. We can look in the hash table for all positive integers, starting from 1. As soon as we find a number which is not there in hash table, we return it. This approach may take O(n) time on average, but it requires O(n) extra space.


*/
package geeksforgeeks;
import java.util.*;
class SmallestMissing
{

	public static int findMissingHelper(int[] a, int start)
	{
		for(int i=start;i<a.length;i++)
		{
		   if(start+Math.abs(a[i])-1<a.length &&  a[start+Math.abs(a[i])-1]>0){		//-1 as index starts with 0 and positive numbers start with 1
			a[start+Math.abs(a[i])-1] =-a[start+Math.abs(a[i])-1] ;
		   }				
		}
		System.out.println(Arrays.toString(a));
		for(int i=start;i<a.length;i++)
		{
			if(a[i]>0){
			  return i+1-start;		// -start is tricky		
			}
		}	
		return a.length+1-start;	// incase no number in between is missing		
	}

	public static void swap(int[] a, int i,int j)
	{
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public static int  shiftNegative(int[] a)
	{
		int i=0;
		int j=0;
		
		while(i<a.length)
		{
			if(a[i]<=0){		// <= is important here as we need to take care of 0 too
				swap(a,i,j);
				j++;
			}
			i++;

		}
		return j;	

	}

	public static int findMissing(int[] a)
	{
		// separate positive and negative 
		int shift = shiftNegative(a);
		System.out.println("After shifting");
		System.out.println(Arrays.toString(a));
		int missing = findMissingHelper(a,shift);
		return missing;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] a = new int[n];
		System.out.println("Enter elements");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int smallestMissing = findMissing(a);
		System.out.println("Smallest Missing Number is: "+smallestMissing);
		sc.close();
	}


}
