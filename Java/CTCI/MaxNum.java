/* CTCI 16.7: To find maximum of two numbers without using if-else or any other comparison operator */

package CTCI;
import java.util.*;
public class MaxNum
{


	public static int sign(int a)
	{
		/*returns 1 for positive and 0 for negative */
		return flip((a>>31) & 0x1);		
	}

	public static int flip(int bit)
	{
		return 1^bit;			// 1 xor 1 will give 0 and 1 xor 0 will give 1
	}

	public static int findMax(int a, int b)
	{
		// calculate sign of a,b, a-b
		int c = a-b;
		int signa = sign(a);
		int signb = sign(b);
		int signc = sign(c);
		//System.out.println(signa);	

		int use_sign_a = signa^signb;
		int use_sign_c = flip(signa^signb);

		int k = use_sign_a*signa + use_sign_c*signc;	
		int q = flip(k);	

		// k and q are opposite so result ak+bq will always be either a or b.
		return a*k+b*q;

	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();	
		int b = s.nextInt();
		int max = findMax(a,b);
		System.out.println("Max of two numbers is: "+max);
		s.close();
	}
	

}