/*10.8 : Find duplicates. Numbers in array will be from 1 to N. N can be maximum of 32,0000. 
With only 4Kilobytes of memory, how would you print all the duplocates */

package CTCI;
import java.util.*;
class BitSet
{
	int[] bitset;

	BitSet(int size)
	{
		bitset = new int[size>>5+1];		// divide by 32 as each integer is 4*8 bits=32 bits
	}

	void set(int pos)
	{
		int wordNum = pos>>5;		// divide by 32
		int bitNum = pos & 0x1F;	//mod 32. 0x1F means 31 in decimal and 11111 in binary
		bitset[wordNum] |= 1<<bitNum;
	}

	boolean get(int pos)
	{
		int wordNum = pos>>5;
		int bitNum = pos & 0x1F;
		return (bitset[wordNum]& (1<<bitNum))!=0;
	}

}

 class FindDuplicates
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n+1];	// since numbers are from 1 to n
		for(int i=1;i<nums.length;i++)
		{
			nums[i]=s.nextInt();
		}
		System.out.println("Duplicate elements are");
		printDuplicates(nums);
	}

	public static void printDuplicates(int[] nums)
	{
		// 4KB of memory means 4*2^10 bytes = 4*8*2^10 bits. We create vector of 32000 as it is less than 4*8*2^10
		BitSet bitset = new BitSet(32000);

		for(int x : nums)
		{
			if(bitset.get(x))
			{
				System.out.println(x);
			}else{
				bitset.set(x);
			}
		}
	}
}