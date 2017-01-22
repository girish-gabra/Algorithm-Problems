/*
Run Length Encoding

Given an input string, write a function that returns the Run Length Encoded string for the input string.

For example, if the input string is 'wwwwaaadexxxxxx', then the function should return 'w4a3d1e1x6'.
*/
package Strings;
import java.util.*;
class RunLengthEncoding
{
	public static String encode(String input)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length();i++)
		{
			char c = input.charAt(i);
			int count = 1;
			int j=i+1;
			while(j<input.length() && input.charAt(j)==c){
				count++;
				i++;
				j++;
			}
			sb.append(c).append(count);
		}

		return sb.toString();	

	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String result = encode(input);
		System.out.println(result);
		sc.close();				
	}


}