/*

Find if an array of strings can be chained to form a circle | Set 1

Given an array of strings, find if the given strings can be chained to form a circle. A string X can be put before another string Y in circle if the last character of X is same as first character of Y.

Examples:

Input: arr[] = {'geek', 'king'}
Output: Yes, the given strings can be chained.
Note that the last character of first string is same
as first character of second string and vice versa is
also true.

Input: arr[] = {'for', 'geek', 'rig', 'kaf'}
Output: Yes, the given strings can be chained.
The strings can be chained as 'for', 'rig', 'geek' 
and 'kaf'

Input: arr[] = {'aab', 'bac', 'aaa', 'cda'}
Output: Yes, the given strings can be chained.
The strings can be chained as 'aaa', 'aab', 'bac' 
and 'cda'

Input: arr[] = {'aaa', 'bbb', 'baa', 'aab'};
Output: Yes, the given strings can be chained.
The strings can be chained as 'aaa', 'aab', 'bbb' 
and 'baa'

Input: arr[] = {'aaa'};
Output: Yes

Input: arr[] = {'aaa', 'bbb'};
Output: No

Input : arr[] = ['ijk', 'kji', 'abc', 'cba']
Output : No
*/
package Strings;
import java.util.*;
class FindChain
{

	public static boolean isChainPossible(String[] arr)
	{
		boolean[] visited ;
		for(int i=0;i<arr.length;i++)
		{
			visited = new boolean[arr.length];
			visited[i]=true;
			if(dfs (arr,arr[i],arr[i],visited,1)){
				return true;
			}
		}

		return false;
	}

	public static boolean dfs(String[] arr, String source,String current, boolean[] visited,int count)
	{
		if(count == arr.length){		// all strings traversed
			//
			System.out.println("inside base condition");
			System.out.println("Source: "+source+" current: "+current);
			if(source.charAt(0)==current.charAt(current.length()-1)){
				return true;
			}
			else{
				return false;
			}
		}

		char lastChar = current.charAt(current.length()-1);
		System.out.println("Source: "+source+" current: "+current);
		for(int i=0;i<arr.length;i++)
		{
			if(current.equals(arr[i]) || visited[i]){	// ignore same string as current and also check if it is already visited	
				continue;
			}

			char firstChar = arr[i].charAt(0);
			if(lastChar==firstChar){
				visited[i]=true;
				return dfs(arr,source,arr[i],visited,++count);
			}
			//visited[i]=false;
		}
		return false;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n]; 
		//String arr = {"abc","cde","efg","ghi","ija"};
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.next();
		}

		if(isChainPossible(arr)){
			System.out.println("Can be Chained");
		}
		else
		{
			System.out.println("Cannot be chained");
		}
	}
}