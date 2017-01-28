/*

All combinations of strings that can be used to dial a number

Given a number, print all possible combinations of strings that can be used to dial the given number in a phone with following specifications.

In the given phone, we can dial,
2 using A or B or C,
3 using D or E or F,
……………….
8 using T or U or V,
9 using W or X or Y or Z,
1 using only 1
0 using 0.
*/
package Strings;
import java.util.*;
class PhoneDialStrings
{
	static Map<Character,String> map;

	static 
	{
		map = new HashMap<Character,String>();
		map.put('1',"1");
		map.put('0',"0");
		map.put('2',"ABC");
		map.put('3',"DEF");
		map.put('4',"GHI");
		map.put('5',"JKL");
		map.put('6',"MNO");
		map.put('7',"PQRS");
		map.put('8',"TUV");
		map.put('9',"WXYZ");
	}

	public static void helper(String number, StringBuffer output, int index)
	{

		if(index == number.length()){
			System.out.println(output.toString());
			return;
		}

		
			char ch = number.charAt(index);
			String str = map.get(ch);
			for(int j=0; j<str.length();j++)
			{
				output.append(str.charAt(j));
				helper(number,output,index+1);
				output.deleteCharAt(output.length()-1);
			}	
		
	}

	public static void printAllWays(String number)
	{
		if(number == null || number.length()==0 ){
			return ; 
		}

		StringBuffer output = new StringBuffer();
		int index = 0;
		helper(number, output, index);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		printAllWays(num);
		sc.close();
	}
}