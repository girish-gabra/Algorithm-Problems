
/* Print all distinct permutations of a given string with duplicates

Given a string that may contain duplicates, write a function to print all permutations of given string such that no permutation is repeated in output.

Examples:

Input:  str[] = "AB"
Output: AB BA

Input:  str[] = "AA"
Output: AA

Input:  str[] = "ABC"
Output: ABC ACB BAC BCA CBA CAB

Input:  str[] = "ABA"
Output: ABA AAB BAA

Input:  str[] = "ABCA"
Output: AABC AACB ABAC ABCA ACBA ACAB BAAC BACA 
        BCAA CABA CAAB CBAA*/
package Strings;
import java.util.*;
class DistinctPermutations
{
	public static void swap(char[] arr, int i, int ceil)
	{
		char temp = arr[i];
		arr[i] = arr[ceil];
		arr[ceil]=temp;
	}

	//Find the index for the ceiling character.
	public static int findCeil(char[] arr,char curr,int low,int high)
	{
		int result = low;

		for(int i=low;i<=high;i++)		
		{
			if(arr[i] > curr && arr[i]<arr[result]){
				result = i;
			}
		}	

		return result;
	}

	public static void distinctPermute(char[] str)
	{
		boolean isFinished = false;
		Arrays.sort(str);	// sort alphabetically
		while(!isFinished)
		{
			//Find the rightmost character smaller than its next character.
			System.out.println(str);
			int i=str.length-2;
			for(;i>=0;i--)
			{
				if(str[i]<str[i+1]){
					break;
				}
			}

			//if there is no such character, all are sorted in decreasing order,
			//means we just printed the last permutation and we are done.	
			if(i==-1)	// all characters are sorted in descending order
			{
				isFinished = true;
			}
			else
			{
				int ceil = findCeil(str,str[i],i+1,str.length-1);
				//swap current and ceil index
				swap(str,i,ceil);	
				// Sort the string on right of 'first char'
				Arrays.sort(str,i+1,str.length);
			}	
				
		}	
		

	}

	public static void permute(String input)
	{
		String result = "";
		permute(input,result);
		System.out.println("Distinct Permutations:");
		char[] arr = input.toCharArray();
		distinctPermute(arr);
	}

	public static void permute(String input,String result)
	{
		if(input.length()==0)
		{
			System.out.println(result);
			return;
		}	

		for(int i=0;i<input.length();i++)
		{
			String newInput = input.substring(0,i)+input.substring(i+1);
			String newResult=result+input.charAt(i);
			permute(newInput,newResult);
		}		

	}

	public static void main(String[] args)
	{
		System.out.println("Enter input string:");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.println("Permutations are: ");
		permute(input);
		sc.close();
	}

}        