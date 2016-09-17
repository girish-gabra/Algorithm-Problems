
/*Find all triplets in a sorted array that forms Geometric Progression

Given a sorted array of distinct positive integers, print all triplets that forms Geometric Progression with integral common ratio.

A geometric progression is a sequence of numbers where each term after the first is found by multiplying the previous one by a fixed, non-zero number called the common ratio. For example, the sequence 2, 6, 18, 54,… is a geometric progression with common ratio 3.

Examples:

Input: 
arr = [1, 2, 6, 10, 18, 54]
Output: 
2 6 18
6 18 54

Input: 
arr = [2, 8, 10, 15, 16, 30, 32, 64]
Output: 
2 8 32
8 16 32
16 32 64

Input: 
arr = [ 1, 2, 6, 18, 36, 54]
Output: 
2 6 18
1 6 36
6 18 54
*/

package geeksforgeeks;
import java.util.*;
class TripletGP
{
	//approach works for sorted arrays
	public static void findTripletsGP(int[] a)
	{
		// consider each element as middle element.
		for(int i=1;i<a.length;i++)
		{
			int j=i-1; int k=i+1;

			while(j>=0 && k<a.length)
			{
				//System.out.println("i: "+i+"j: "+j+" k: "+k);
				//check for the triplet
				while(j>=0 && k<a.length && a[i]%a[j]==0 && a[k]%a[i]==0 && a[i]/a[j]==a[k]/a[i])
				{
					System.out.println(a[j]+" "+a[i]+" "+a[k]);
					k++;
					j--;
				}

				if(j>=0 && k<a.length && a[i]%a[j]==0 && a[k]%a[i]==0)
				{
					if(a[i]/a[j] < a[k]/a[i])
					{
						j--;
					}else{
						k++;
					}
				}
				else if(k<a.length && a[i]%a[j]==0)
				{
					k++;
				}
				else
				{
					j--;
				}	

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
			Arrays.sort(a);		// sort the array
			findTripletsGP(a);
			
			sc.close();
		}		

}