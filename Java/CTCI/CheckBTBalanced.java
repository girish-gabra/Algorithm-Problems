/* CTCI 4.4 -- check if binary tree is balanced */
package CTCI;
class BTNode
{
	int data;
	BTNode left;
	BTNode right;
}

public class CheckBTBalanced
{
	/*Complexity of below algorithm is O(n^2). For O(n) complexity,please refer checkBalanced(BTNode r)  method*/
	public static boolean isBalanced(BTNode root)
	{
		int leftSubtreeHeight=0;
		int rightSubtreeHeight=0;

		/* Empty node is always balanced*/
		if(root==null){
			return true;
		}

		if(root.left!=null){
			leftSubtreeHeight = calculateHeight(root.left);
		}

		if(root.right!=null){
			rightSubtreeHeight = calculateHeight(root.right);
		}

		if(Math.abs(leftSubtreeHeight-rightSubtreeHeight)>1)
		{
			return false;
		}

		/* Recursively check if subtrees are balanced*/	
		if(!isBalanced(root.left)){
			return false;
		}

		if(!isBalanced(root.right)){
			return false;
		}

		return true;
	}

	public static int calculateHeight(BTNode r)
	{
		if(r==null){
			return 0;
		}
		return max(calculateHeight(r.left),calculateHeight(r.right))+1;		// height is maximum of two subtrees

	}

	public static int max(int a, int b)
	{
		return a<b?b:a;
	}

	/*Complexity of below method is O(n)*/
	public static boolean checkBalanced(BTNode root)
	{
		return checkHeight(root) != Integer.MIN_VALUE;		//Integer.MIN_VALUE stands for erroneus condition, i.e. tree is not balanced  
	}

	public static int checkHeight(BTNode root)
	{
		int leftSubtreeHeight=0;
		int rightSubtreeHeight=0;
		if(root.left!=null)
		{
			leftSubtreeHeight=checkHeight(root.left);
			if(leftSubtreeHeight == Integer.MIN_VALUE)
			{
				return  Integer.MIN_VALUE;
			}
		}


		if(root.right!=null)
		{
			rightSubtreeHeight=checkHeight(root.right);
			if(rightSubtreeHeight == Integer.MIN_VALUE)
			{
				return  Integer.MIN_VALUE;
			}
		}

		if(Math.abs(leftSubtreeHeight-rightSubtreeHeight)>1){
			return Integer.MIN_VALUE; 
		}else{
			return Math.max(leftSubtreeHeight,rightSubtreeHeight)+1;
		}

	}


	public static void main(String[] args)
	{


		BTNode root = new BTNode();
		root.data = 10;

		BTNode r1 = new BTNode();
		r1.data=5;
		root.left=r1;

		BTNode r2 = new BTNode();
		r2.data=20;
		root.right=r2;

		BTNode r3 = new BTNode();
		r3.data=2;
		r1.left=r3;

		BTNode r4 = new BTNode();
		r4.data=7;
		r1.right=r4;

		BTNode r5 = new BTNode();
		r5.data=15;
		r2.left=r5;

		BTNode r6 = new BTNode();
		r6.data=13;
		r5.left=r6;

		boolean result = isBalanced(root);
		if(result){
			System.out.println("This Binary tree is balanced.");
		}else{
			System.out.println("This Binary tree is not balanced");
		}


		result = checkBalanced(root);
		if(result){
			System.out.println("This Binary tree is balanced.");
		}else{
			System.out.println("This Binary tree is not balanced");
		}

	}





}