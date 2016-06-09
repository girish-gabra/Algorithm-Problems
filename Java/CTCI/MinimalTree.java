/* Excercise Question 4.2 */
package CTCI;
import java.util.Scanner;
class BSTNode
{
	int data;
	BSTNode left;
	BSTNode right;
}

class MinimalTree
{

	public static BSTNode createMinimalBST(int[] a)
	{
		return createMinimalBST(a,0,a.length-1);
	}

	public static BSTNode createMinimalBST(int[] a,int low, int high)
	{
		if(low<=high)
			{
				int mid = (low+high)/2;	
				BSTNode r = new BSTNode();
				r.data = a[mid];	
				r.left = createMinimalBST(a,low,mid-1);
				r.right = createMinimalBST(a,mid+1,high);
				return r;
			}	
		
			return null;

	}

	public static void displayPreOrder(BSTNode root)
	{
		if(root!=null)
		{
			System.out.println(root.data);
			displayPreOrder(root.left);		
			displayPreOrder(root.right);	
		}
		
	}

	public static void displayInOrder(BSTNode root)
	{
		if(root!=null)
		{
			displayInOrder(root.left);		
			System.out.println(root.data);
			displayInOrder(root.right);	
		}
		
	}

	public static int calculateHeight(BSTNode root)
	{
		if(root==null){
			return 0;
		}

		return (max(calculateHeight(root.left),calculateHeight(root.right))+1);

	}

	public static int max(int a, int b)
	{
		return a<b?b:a;
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];	
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}

		BSTNode root = createMinimalBST(a);
		System.out.println("root.data: "+root.data);
		System.out.println("PreOrder Traversal ");
		displayPreOrder(root);
		System.out.println("InOrder Traversal ");
		displayInOrder(root);
		int minheight = calculateHeight(root);
		System.out.println("Min height of BST is "+minheight);
	}



	
}