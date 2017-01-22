
/*Length of the longest valid substring

Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

Examples:

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(()))
*/


package Strings;
import java.util.*;
class LongestValidSubstring
{

	public static boolean isValid(String s)
	{
		Stack<Character> stack = new Stack<Character>();

		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='('){
				stack.push('(');
			}else{
				if(stack.isEmpty()){
					return false;
				}
				stack.pop();
			}

		}

		if(!stack.isEmpty()){
			return false;
		}

		return true;
	}

	// Generate all substrings and check for each substring if it is valid, update the max length
	public static int findMaxLen(String input)
	{
		int maxLen=0;

		for(int i=0;i<input.length();i++)
		{
			for(int j=i;j<input.length();j++)
			{
				String substr = input.substring(i,j+1);
				
				if(isValid(substr)){
					System.out.println(substr);
					maxLen = Math.max(maxLen, substr.length());
				}	
			}
		}

		return maxLen;
	}

	//O(n) solution
	public static int findMaxLenEfficent(String input)
	{
		Stack<Integer> stack = new Stack<Integer>();
		int maxLen=0;

		stack.push(-1);	// initialize stack
		for(int i=0; i<input.length();i++)
		{
			if(input.charAt(i)=='('){
				stack.push(i);		// push the index
			}
			else{
				stack.pop();

				if(!stack.isEmpty()){
					maxLen = Math.max(maxLen, i-stack.peek());
				}else{
					stack.push(i);	// if stack is empty put current index as base for the next valid substring
				}
			}
		}
		return maxLen;

	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//int len = findMaxLen(input);
		int len = findMaxLenEfficent(input);
		System.out.println("Max Length of valid substring: "+len);
	}
}