/* Write a program to print all permutations of a given string
A permutation, also called an arrangement number or order, is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself. A string of length n has n! permutation.
Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB */
package geeksforgeeks;
import java.util.*;
class Permutations    // Duplicates included
{
	public static void printAllPermutations(String input)
	{
		String prefix="";
		printAllPermutations(prefix,input);

	}

	public static void printAllPermutations(String prefix,String input)
	{
		if(input.length() == 0){
			System.out.println(prefix);
		}

		for(int i=0; i<input.length();i++)
		{
			String newPrefix = prefix+input.charAt(i);
			printAllPermutations(newPrefix, input.substring(0,i)+input.substring(i+1,input.length()));
		}

	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String input = s.next();
		printAllPermutations(input);
	}


}