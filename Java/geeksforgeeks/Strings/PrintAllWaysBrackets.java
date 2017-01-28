/*

Print all ways to break a string in bracket form

Given a string, find all ways to to break the given string in bracket form. Enclose each substring within a parenthesis.

Examples:

Input : abc
Output: (a)(b)(c)
        (a)(bc)
        (ab)(c)
        (abc)

Input : abcd
Output : (a)(b)(c)(d)
         (a)(b)(cd)
         (a)(bc)(d)
         (a)(bcd)
         (ab)(c)(d)
         (ab)(cd)
         (abc)(d)
         (abcd)
*/
package Strings;
import java.util.*;
class PrintAllWaysBrackets
{
	public static void helper(String output, String input, int index)
	{
		if(index == input.length())
		{
			System.out.println(output);
			return;
		}

		for(int i=index;i<input.length();i++)
		{
			String temp = output;
			output += "("+input.substring(index,i+1)+")";
			helper(output,input,i+1);
			output = temp;
		}
	}

	public static void printAllWays(String input)
	{
		String output = "";
		int index = 0;
		helper(output,input,index);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		printAllWays(input);
		sc.close();
	}

}