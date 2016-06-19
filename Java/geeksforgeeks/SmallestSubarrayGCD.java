/* 
Smallest Subarray with given GCD

Given an array arr[] of n numbers and an integer k, find length of the minimum sub-array with gcd equals to k.

Example:

Input: arr[] = {6, 9, 7, 10, 12, 
                24, 36, 27}, 
           K = 3
Output: 2
Explanation: GCD of subarray {6,9} is 3.
GCD of subarray {24,36,27} is also 3,
but {6,9} is the smallest */
package geeksforgeeks;
import java.util.*;
class SmallestSubarrayGCD
{
	
	public static int calculateGCD(int a, int b)
	{
		if(a<b){
			calculateGCD(b,a);
		}

		if(b==0){
			return a;
		}

		return calculateGCD(b,a%b);

	}

	public static void calcMinSubarray(int[] a, int k)
	{
		int left=0;
		int right=0;
		int minLength=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++)
		{
			int current = a[i];
			for(int j=i+1;j<a.length;j++)
			{
				int next=a[j]; 
				int gcd = calculateGCD(current,next);
				//System.out.println("GCD is: "+gcd);
				if(gcd==k){
					left=i;
					right=j;
					if((right-left)+1<minLength){
						minLength=(right-left)+1;
					}
				}else{
					current=gcd;
				}
			}

		}

		System.out.println("Minimum subarray with gcd "+k+" is of length "+minLength+" and it is having following elements");
		for(int i=left;i<=right;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();


	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = s.nextInt();
		}
		int k = s.nextInt();
		calcMinSubarray(a,k);
		s.close();
	}


}