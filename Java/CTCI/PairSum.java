/*	16.24 : Design an algorithm to find all pairs of integers witihin an array which sum to specified value */
package CTCI;
import java.util.*;
class PairSum
{
	
	public static List<int[]> findPairs(int[] nums,int target)
	{
		List<int[]> result = new ArrayList<int[]>();	

		if(nums==null){
			return result;
		}

		Set<Integer> set = new HashSet<Integer>();

		for(int x:nums)
		{
			int value = target-x;	
			if(set.contains(value) && !set.contains(x))
			{
				int[] temp = {x,value};
				result.add(temp);
			}
			set.add(x);
		}

		return result;	
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i]=s.nextInt();
		}
		System.out.println("Enter the target sum");
		int target = s.nextInt();
		List<int[]> result = findPairs(nums,target);
		System.out.println("Pairs are: ");
		for(int i=0;i<result.size();i++)
		{
			int[] temp = result.get(i);
			System.out.println(temp[0]+","+temp[1]);
		}

		s.close();
	}
	


}