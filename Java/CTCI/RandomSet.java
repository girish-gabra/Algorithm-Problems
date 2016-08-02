/* CTCI 17.3 Random set : Write a method to randomly generate a set of m integers from an array of size n. Each element must have equal probability of being chosen*/

package CTCI;
import java.util.*;
public class RandomSet
{
	public static int[] generateRandomSet(int[] a, int m)
	{
		int[] subset = new int[m];

		for(int i=0;i<m;i++)
		{
			subset[i]=a[i];
		}

		for(int i=m;i<a.length;i++)
		{
			int k = rand(0,i);	// generate a random number 

			if(k<m){
				subset[k]=a[i];
			}

		}


		return subset;
	}

	/* function to return a random value between the lower and higher inclusive */
	public static int rand(int lower, int higher)
	{

		return (lower +  (int)(Math.random()*(higher - lower + 1))  );
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n;i++)
		{
			a[i]=s.nextInt();
		}

		int m = s.nextInt();
		int[] subset = generateRandomSet(a,m);

		System.out.println("Random generated set: ");
		for(int i=0;i<m;i++)
		{
			System.out.print(subset[i]+" ");
		}
		System.out.println();
		s.close();

	}

}