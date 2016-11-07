/*

Find zeroes to be flipped so that number of consecutive 1’s is maximized

Given a binary array and an integer m, find the position of zeroes flipping which creates maximum number of consecutive 1s in array.

Examples:

Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 2
Output:  5 7
We are allowed to flip maximum 2 zeroes. If we flip
arr[5] and arr[7], we get 8 consecutive 1's which is
maximum possible under given constraints 

Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 1
Output:  7
We are allowed to flip maximum 1 zero. If we flip 
arr[7], we get 5 consecutive 1's which is maximum 
possible under given constraints.

Input:   arr[] = {0, 0, 0, 1}
         m = 4
Output:  0 1 2
Since m is more than number of zeroes, we can flip
all zeroes.

*/

package geeksforgeeks;
import java.util.*;
class FlipZeros
{


	public static void getMax1s(int[] a, int m)
	{
		int countZeros=0;

		// Left and right indexes of current window
		int currLeft=0;
		int currRight=0;

		 // Left index and size of the widest window 
		int bestLeft=0;
		int bestWindow=0;


		while(currRight < a.length)
		{
			// If zero count of current window is less than m,
       		 // widen the window toward right
			if(countZeros <=m)
			{
				if(a[currRight]==0){
					countZeros++;
				}
				currRight++;
			}

			// If zero count of current window is more than m,
        	// reduce the window from left
			if( countZeros > m)
			{
				if(a[currLeft]==0){
					countZeros--;
				}
				currLeft++;
			}	

			if( (currRight - currLeft) > bestWindow )
			{
				bestWindow = (currRight - currLeft);
				bestLeft = currLeft;
			}
		}

		//print positions of zeros in best window 
		for(int i=0;i<bestWindow;i++)
		{
			if(a[bestLeft+i]==0){
				System.out.print((bestLeft+i)+" ");
			}
		}
		System.out.println();	
	}

	// O(n^2) solution
	/*public static void getMax1s(int[] a,int m)
	{
		int maxLen=0;

		for(int i=0;i<a.length;i++)
		{
			int countZeros=0;
			int len = 0;
			for(int j=i;j<a.length;j++)
			{

				if(a[j]==0){
					countZeros++;
				}

				if(countZeros > m ){
					break;
				}
				len++;
				if(len > maxLen){
					maxLen = len;
				}	
			}
			
		}
		System.out.println("MaxLen :"+maxLen);
	}*/

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
			System.out.println("Enter m");
			int m = sc.nextInt();
			getMax1s(a,m);
			sc.close();
		}

}	