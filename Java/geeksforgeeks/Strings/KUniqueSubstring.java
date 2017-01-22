/*

Find the longest substring with k unique characters in a given string

Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.

Examples:

"aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.

"aaabbb", k = 3
There are only two unique characters, thus show error message. 
*/
package Strings;
import java.util.*;
class KUniqueSubstring
{

	// This function calculates number of unique characters
	// using a associative array count[]. Returns true if
	// no. of characters are less than required else returns
	// false.
	public static boolean isValid(int[] count,int k)
	{
		int val=0;
		for(int i=0;i<count.length;i++)
		{
			if(count[i]>0){
				val++;
			}
		}
		return k>=val;	// returns true if k is greater or equal to number of unique chars
	}

	//O(n) time complexity, sliding window approach
	public static String printKUniqueLongestSubstring(String input,int k)
	{
		int currLeft = 0;
		int currEnd = -1;
		int maxWindowSize=0;
		int maxWindowStart=0;
		
		int[] count = new int[26];
		int uniqueChars = 0;

		String result = "";
		for(int i=0;i<input.length();i++)
		{
			if(count[input.charAt(i)-'a']==0){
				uniqueChars++;
			}
			count[input.charAt(i)-'a']++;
		}

		// if there are less than k unique characters return a string
		if(uniqueChars < k){
			result =  "No String possible";
			return result;
		}

		Arrays.fill(count,0);

		for(int i=0; i<input.length();i++)
		{
			char current = input.charAt(i);
			count[current-'a']++;	
			currEnd++;
			
			// when there are more than k unique chars, remove chars from left end
			while(!isValid(count,k))
			{
				count[input.charAt(currLeft)-'a']--;
				currLeft++;
			}	

			System.out.println("currLeft: "+currLeft+" currEnd: "+currEnd);
			if(currEnd-currLeft+1 > maxWindowSize)
			{
				maxWindowSize=currEnd-currLeft+1;
				maxWindowStart = currLeft;
			}
			System.out.println("maxWindowStart: "+maxWindowStart+" maxWindowSize: "+maxWindowSize);
			result = input.substring(maxWindowStart,maxWindowStart+maxWindowSize);
		}

		return result;
	}

	//O(n^2) time complexity O(n) space complexity
	public static String printKUniqueLongestSubs(String input,int k)
	{
		Set<Character> charSet;
		String result = "";

		for(int i=0;i<input.length();i++)
		{
			String temp="";
			charSet = new HashSet<Character>();
			for(int j=i;j<input.length();j++)
			{
				char current = input.charAt(j);
				charSet.add(current);
				if(charSet.size()<=k){
					temp+=current;	
					}
				if(charSet.size()==k){
					if(temp.length() > result.length()){
						result = temp;	
				}		
				}
				
			}
			
		}

		return result;
	} 

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input String");
		String input = sc.nextLine();
		System.out.println("Enter k");
		int k = sc.nextInt();
		//String result = printKUniqueLongestSubs(input,k);	// O(n^2) approach
		String result = printKUniqueLongestSubstring(input,k); // O(n) approach
		System.out.println(result);
	}

}