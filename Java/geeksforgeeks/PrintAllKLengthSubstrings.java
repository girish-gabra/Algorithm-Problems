/*Print all possible strings of length k that can be formed from a set of n characters
Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.

Examples:

Input: 
set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb


Input: 
set[] = {'a', 'b', 'c', 'd'}, k = 1
Output:
a
b
c
d*/
package geeksforgeeks;
import java.util.*;
class PrintAllKLengthSubstrings
{
	public static void findSubstrings(char[] set, String prefix, int k)
	{
		if(k==0){
			System.out.println(prefix);
			return;
		}

			for(int i =0; i<set.length;i++)
			{
				prefix = prefix+set[i];
				findSubstrings(set,prefix,k-1);
				prefix=prefix.substring(0,prefix.length()-1);
			}	


	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		char[] set = new char[n];
		for(int i=0; i<n;i++){
			set[i] = s.next().charAt(0);
		}
		int k = s.nextInt();
		String prefix="";
		//System.out.println("Calling findSubstrings");
		findSubstrings(set,prefix,k);
	}


}