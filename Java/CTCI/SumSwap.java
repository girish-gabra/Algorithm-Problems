/*16.21: Given two arrays, find a pair of values(one from each array) such that you swap to give the two arrays the same sum*/

package CTCI;
import java.util.*;
class SumSwap
{
	public static int getSum(int[] nums)
	{
		int sum=0;

		for(int x: nums)
		{
			sum+=x;
		}

		return sum;
	}

	public static Integer getTarget(int[] a, int[] b)
	{
		int sum1 = getSum(a);
		int sum2 = getSum(b);

		if((sum1-sum2)%2!=0) return null;

		return (sum1-sum2)/2;
	}

	public static int[] findPair(int[] a, int[] b)
	{
		// basic idea is to find two values a,b such that (a-b) = (sumA-sumB)/2 (original equation is sumA-a+b == sumB-b+a).

		// can sort elements and then search the difference. Complexity will be O(nlogn). No external memory needed

		// In following approach we use HashSet and reduce time complexity to O(A+B)

		Integer target = getTarget(a,b);
		if(target==null) return null;
		//System.out.println("target: "+target);
		Set<Integer> set = new HashSet<Integer>();
		for(int x : b){ 
			 	set.add(x);
			}

		for(int i=0;i<a.length;i++)
		{
			int x = a[i]-target;		// we want to know if a-b == target combination exists
			//System.out.println("x: "+x);
			if(set.contains(x))
			{
				int[] result = {a[i],x};
				return result;
			}
		}

		return null;	
	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int[] a = new int[m];
		for(int i=0;i<m;i++){
			a[i]=s.nextInt();
		}
		int n = s.nextInt();
		int[] b = new int[n];
		for(int i=0;i<n;i++){
			b[i]=s.nextInt();
		}

		int[] pair = findPair(a,b);

		if(pair==null){
			System.out.println("No such pair exist");
		}else{
			System.out.println("Pair is {"+pair[0]+","+pair[1]+"}");
		}

		s.close();
		
	}

}