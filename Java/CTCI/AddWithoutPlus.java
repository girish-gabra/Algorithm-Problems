/*17.1 Add Without Plus*/
package CTCI;
import java.util.*;
public class AddWithoutPlus
{
	public static int add(int a, int b)
	{
		// Add two numbers without carry. Add two numbers using only carry. Repeat the same operations
		if(b==0){
			return a;
		}

		int sum = a^b;
		int carry = (a&b)<<1;

		return add(sum,carry);

	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter two numbers");
		int a = s.nextInt();
		int b = s.nextInt();
		int sum = add(a,b);

		System.out.println("Addtion: "+sum);
	}

}