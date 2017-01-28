/*

Rearrange a string so that all same characters become d distance away

Given a string and a positive integer d. Some characters may be repeated in the given string. Rearrange characters of the given string such that the same characters become d distance away from each other. Note that there can be many possible rearrangements, the output should be one of the possible rearrangements. If no such arrangement is possible, that should also be reported.
Expected time complexity is O(n) where n is length of input string.

Examples:
Input:  "abb", d = 2
Output: "bab"

Input:  "aacbbc", d = 3
Output: "abcabc"

Input: "geeksforgeeks", d = 3
Output: egkegkesfesor

Input:  "aaa",  d = 2
Output: Cannot be rearranged
*/
package Strings;
import java.util.*;
class RearrangeAtExactD
{

	public static void printString(String s,int d)
	{
		Map<Character,Integer> map = new HashMap<Character,Integer>();

		for(Character c : s.toCharArray()){
			int count = map.containsKey(c)?map.get(c)+1:1;
			map.put(c,count);
		}

		PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<Map.Entry<Character,Integer>>(new Comparator<Map.Entry<Character,Integer>>(){
			public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2)
			{
				return o2.getValue() - o1.getValue();
			}
		});

		for(Map.Entry<Character,Integer> me : map.entrySet())
		{
			queue.offer(me);
		}

		char[] result = new char[s.length()];
		//System.out.println(result);
		while(!queue.isEmpty())
		{
			Map.Entry<Character,Integer> me = queue.poll();
			char current = me.getKey();
			int freq = me.getValue();
			int i=0;

			while(i<result.length && result[i]!=0)	// default value for character is /u0000 and can be written as 0
			{	// find the next position to insert character
				i++;
			}
			//System.out.println("i: "+i);
			for(int k=0;k<freq;k++)
			{
				if(i+d*k >= result.length){
					System.out.println("Cannot be arranged");
					return;
				}
				result[i+d*k]=current;				
			}
		
		}

		System.out.println("After rearrange: "+String.valueOf(result));

	}


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int d = sc.nextInt();
		printString(input,d);
		sc.close();
	}
}