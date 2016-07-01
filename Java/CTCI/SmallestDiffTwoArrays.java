/*CTCI 16.6 Given two arrays, compute the pair of values(one from each array) with the smallest non-negative difference. Return the difference */

package CTCI;
import java.util.*;

class SmallestDiffTwoArrays
{

	public static int calculateDiff(int[] a, int[] b)
	{
		Arrays.sort(a);
		Arrays.sort(b);

		int minDiff = Integer.MAX_VALUE;

		int i=0; 
		int j=0;

		while(i<a.length && j<b.length)
		{
			//System.out.println("inside while i: "+i+" j: "+j);
			if(Math.abs(a[i]-b[j])<minDiff){
				minDiff = Math.abs(a[i]-b[j]);
			}
				
				if(a[i]<b[j]){
					i++;
				}else{
					j++;
				}
			

		}
		return minDiff;
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();

		int[] a = new int[n];
		int[] b = new int[m];

		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}

		for(int i=0;i<m;i++){
			b[i]=s.nextInt();
		}

		int min = calculateDiff(a,b);
		System.out.println("Min Difference:"+min);
		s.close();


	}	


}