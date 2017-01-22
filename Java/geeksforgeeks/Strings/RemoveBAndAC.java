/*
Remove b and ac from a given string

Given a string, eliminate all b and ac in the string, you have to replace them in-place, and you are only allowed to iterate over the string once. (Source Google Interview Question)

Examples:

acbac   ==>  ""
aaac    ==>  aa
ababac  ==>   aa
bbbbd   ==>   d
*/
package Strings;
import java.util.*;
class RemoveBAndAC
{

	public static void removeBandAC(String input)
	{
		int state=1;		// state has two values 1 and 2. 2 means previous character is a. Initialized as 1 i.e prev char not a
		char[] arr = input.toCharArray();
		int j=0;
		for(int i=0;i<arr.length;i++)
		{
			if(state==1 && arr[i]!='b' && arr[i]!='a'){
				arr[j]=arr[i];
				j++;
			}
			System.out.println(j);
			if(state==2 && arr[i]!='c'){
				arr[j]='a'; // copy previous a
				j++;

				if(arr[j]!='a' && arr[j]!='b'){
					arr[j]=arr[i];
					j++;
				}	

			}

			state = arr[i]=='a'?2:1;
		}

		if(state==2)
		{
			arr[j]='a';
			j++;
		}

		for(int k=0;k<j;k++){
			System.out.print(arr[k]);
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		removeBandAC(input);
	}
}