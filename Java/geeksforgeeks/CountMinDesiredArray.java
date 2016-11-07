
/*Count minimum steps to get the given desired array

Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.

    Incremental operations:Choose 1 element from the array and increment its value by 1.
    Doubling operation: Double the values of all the elements of array.
*/
package geeksforgeeks;
import java.util.*;
class CountMinDesiredArray
{

	public static int countMinOperations(int[] target)
	{
		int len = target.length;
		int result = 0;
		while(true)
		{
			int zeros = 0;
			int i=0;	
			for(;i<len;i++)
			{
				if(target[i]==0){
					zeros++;
				}

				if(target[i]%2!=0)
				{
					break;
				}	
			}	

			/*All numbers are zero*/	
			if(zeros==len)
			{
				return result;
			}

			/*All are even*/
			if(i==len)
			{
				for(int j=0;j<len;j++)
				{
					target[j]/=2;
				}
				result++;	
			}

			/*Make all odd numbers as even*/
			for (int j=i; j<len; j++)
        	{
           		if ((target[j] & 1)==1)
           		{
              		target[j]--;
              		result++;
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

		int count = countMinOperations(a);
		System.out.println("Min num of operations: "+count);
		sc.close();
	}



}