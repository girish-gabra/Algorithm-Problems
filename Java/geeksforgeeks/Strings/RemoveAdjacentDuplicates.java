/*
Recursively remove all adjacent duplicates

Given a string, recursively remove adjacent duplicate characters from string. 
The output string should not have any adjacent duplicates. See following examples.

Input:  azxxzy
Output: ay
First "azxxzy" is reduced to "azzy". The string "azzy" contains duplicates, 
so it is further reduced to "ay".

Input: geeksforgeeg
Output: gksfor
First "geeksforgeeg" is reduced to "gksforgg". The string "gksforgg" contains 
duplicates, so it is further reduced to "gksfor".

Input: caaabbbaacdddd
Output: Empty String

Input: acaaabbbacdddd
Output: acac
*/
package Strings;
import java.util.*;
class RemoveAdjacentDuplicates
{
	//O(n) solution
	public static String removeAdjDup(String input)
	{
		char lastRemoved=' ';
		return removeAdjDupUtil(input,lastRemoved);
	}

	public static String removeAdjDupUtil(String input, char lastRemoved)
	{
		if(input.length()==0 || input.length()==1){
			return input;
		}

		//System.out.println("input: "+input);
		// Remove leftmost duplicates and recur with remaining string
		if(input.charAt(0)==input.charAt(1)){
			lastRemoved=input.charAt(0);
			int k=1;
			while(k<input.length() && input.charAt(k)==input.charAt(0)){
				k++;
			}
			input = input.substring(k);
			return removeAdjDupUtil(input,lastRemoved);
		}

		/*At this point, the first character is definiotely different
    	from its adjacent. Ignore first character and recursively 
    	remove characters from remaining string*/
    	String rem = removeAdjDupUtil(input.substring(1),lastRemoved);
    	//System.out.println("rem: "+rem);

    	// if first character of rem string matches with the first charcter of original string
    	if(rem.length()>0 && rem.charAt(0)==input.charAt(0)){
    		lastRemoved = input.charAt(0);
    		return rem.substring(1);
    	}

    	// If remaining string becomes empty and last removed character
    	// is same as first character of original string. This is needed
    	// for a string like "acbbcddc"
    	if(rem.length()==0 && input.charAt(0)==lastRemoved ){
    		return rem;
    	}

    	return (input.charAt(0)+rem);	
	} 

	//O(n^2) solution
	public static String removeDup(String input)
	{
		int n = input.length()-1;
		return removeDupUtil(input,n);
	}

	public static String removeDupUtil(String input,int n)
	{
		StringBuilder sb = new StringBuilder();
		int k=0;
		int i=1;
		while(i<input.length())	// -1 as we are appending last character later eg case abbc
		{
			if(input.charAt(i)!=input.charAt(i-1)){
				sb.append(input.charAt(i-1));
				k++;
			}
			else
			{
				while(i<input.length() && input.charAt(i)==input.charAt(i-1)){	//skip same elements
					i++;
				}
			}
			if(i<input.length()){	// increment i only if it can be
				i++;
			}	
		}

		if((k!=0 || input.length()==1) && input.charAt(i-2)!=input.charAt(i-1)){	// to handle cases like aa	
			sb.append(input.charAt(i-1));	// append last character
			k++;
		}
		if(k!=n){
			return removeDupUtil(sb.toString(),k);
		}
		else{	// All duplicates are removed
			
			return sb.toString();
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//String output = removeDup(input);	//O(n^2) solution
		String output = removeAdjDup(input);
		System.out.println("Removing Adjacent duplicates we get: "+output);
	}
}