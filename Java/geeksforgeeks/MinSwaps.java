/*

Minimum number of swaps required for arranging pairs adjacent to each other

There are n-pairs and therefore 2n people. everyone has one unique number ranging from 1 to 2n. All these 2n persons are arranged in random fashion in an Array of size 2n. We are also given who is partner of whom. Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.

Example:

Input:
n = 3  
pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
arr[] = {3, 5, 6, 4, 1, 2}

Output: 2
We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1
*/
package geeksforgeeks;
import java.util.*;
class MinSwaps
{

	public static void updateIndex(int[] index, int a, int ai, int b, int bi)
	{
		index[a]=ai;
		index[b]=bi;
	}

	public static void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}


	public static int calcMinSwapsUtil(int[] arr, int[] pairs,int[] index,int i)
	{
		// If all pairs procesed so no swapping needed return 0
		if(i>=arr.length){
			return 0;
		}

		// If current pair is valid so DO NOT DISTURB this pair
    	// and move ahead.
		if(pairs[arr[i]]==arr[i+1]){
			return calcMinSwapsUtil(arr,pairs,index,i+2);		
		}

		// If we reach here, then arr[i] and arr[i+1] don't form a pair
 
    	// Swap pair of arr[i] with arr[i+1] and recursively compute
    	// minimum swap required if this move is made.

    	int one = arr[i+1];
    	int indexOne = index[pairs[arr[i]]] ;
    	int two = arr[index[pairs[arr[i]]]];
    	int indexTwo =  i+1 ;
    	swap(arr,i+1,indexOne);
    	updateIndex(index,one,indexOne,two,indexTwo);
    	int a = calcMinSwapsUtil(arr,pairs,index,i+2);

    	// Backtrack to previous configuration. Also restore the
    	// previous indices, of one and two
    	swap(arr,i+1,indexOne);
    	updateIndex(index,one,indexTwo,two,indexOne);


    	 // Now swap arr[i] with pair of arr[i+1] and recursively
    	// compute minimum swaps required for the subproblem
    	// after this move

    	one = arr[i];
    	indexOne = index[pairs[arr[i+1]]];
    	two = arr[index[pairs[arr[i+1]]]];
    	indexTwo=i;
    	swap(arr,i,indexOne);
    	updateIndex(index,one,indexOne,two,indexTwo);
    	int b = calcMinSwapsUtil(arr,pairs,index,i+2);

    	// Backtrack to previous configuration.  Also restore
    	// the previous indices, of one and two
    	swap(arr,i,indexOne);
    	updateIndex(index,one,indexTwo,two,indexOne);

    	int min = a<b?a:b;

    	return 1+min;

	}	


	public static int calcMinSwaps(int[] arr, int[] pairs)
	{
		//stores index of each elements
		int[] index = new int[arr.length];

		for(int i=0;i<arr.length;i++)
		{
			index[arr[i]]=i;
		}

		return calcMinSwapsUtil(arr,pairs,index,1);		

	}


	public static void main(String[] args)
		{
			// For simplicity, it is assumed that 0 index is not used
			int[] arr = {0, 3, 5, 6, 4, 1, 2};
			int pairs[] = {0, 2, 1, 5,6,3,4};

 			int minSwaps = calcMinSwaps(arr,pairs);
 			System.out.println("Min Swaps is: "+minSwaps);
		}
}