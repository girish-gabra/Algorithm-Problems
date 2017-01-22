
/*Find if a given string can be represented from a substring by iterating the substring "n" times

Given a string 'str', check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Examples:

Input: str = "abcabcabc"
Output: true
The given string is 3 times repetition of "abc"

Input: str = "abadabad"
Output: true
The given string is 2 times repetition of "abad"

Input: str = "aabaabaabaab"
Output: true
The given string is 4 times repetition of "aab"

Input: str = "abcdabc"
Output: false
*/
package Strings;
import java.util.*;
class CheckStringFromSubstring
{
	
	// O(n) solution
	/*Let the given string be 'str' and length of given string be 'n'.

1) Find length of the longest proper prefix of 'str' which is also a suffix. Let the length of the longest proper prefix suffix be 'len'. 
This can be computed in O(n) time using pre-processing step of KMP string matching algorithm.

2) If value of 'n – len' divides n (or 'n % (n-len)'' is 0), then return true, else return false.

In case of 'true' , the substring 'str[0..n-len-1]' is the substring that repeats n%(n-len) times.
	*/
	
	// A utility function to fill lps[] or compute prefix funcrion
	// used in KMP string matching algorithm. Refer
	// http://www.geeksforgeeks.org/archives/11902 for details
	public static void computeLPSArray(String str, int[] lps)
	{
		int len=0;	//len of prev longest prefix suffix
		int i=1;

		while(i<str.length())
		{
			if(str.charAt(i)==str.charAt(len))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else
			{
				if(len!=0)
				{
					lps[i]=lps[len-1];	// tricky, consider example AAACAAAA and i=7, do not increment i
				}
				else
				{
					lps[i]=0;
					i++;
				}
			}
		}
	}
	// O(n) method
	public static boolean isPossibleUsingLPS(String str)
	{
		int  n = str.length();
		int[] lps = new int[n];

		computeLPSArray(str,lps);

		int len = lps[n-1];		// as index starts from 0

		if(n%(n-len)==0){
			System.out.println("Substring is: "+str.substring(0,n-len));
			return true;
		}
		return false;		// if n-len does not divide n	

	}

	// O(n^2) solution
	public static boolean isPossibleFromSubstring(String str)
	{
		if(str==null || str.length()==0){
			return false;
		}
		String substring=null;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length()/2;i++)
		{
			sb.append(str.charAt(i));
			int j=0;
			int k=i+1;
			substring=sb.toString();
			System.out.println("formed substr: "+substring);
			while(k<str.length())
			{
				if(substring.charAt(j)!=str.charAt(k)){
					break;
				}
				j++;
				k++;
				if(j==substring.length()){
					j=0;
				}
			}

			if(k==str.length()){
				System.out.println("Substring: "+substring);
				return true;
			}

		}
		return false;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//boolean result = isPossibleFromSubstring(input); 	// O(n^2)
		boolean result = isPossibleUsingLPS(input);
		System.out.println(result);
	}
	
}