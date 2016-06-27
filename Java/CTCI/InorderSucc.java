/* CTCI 4.6 Algorithm to find inorder successor for a binary search tree */
package CTCI;
class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;

	TreeNode(int x)
	{
		this.data = x;
		this.left=null;
		this.right=null;
		this.parent=null;
	}
}

public class InorderSucc
{

	public static TreeNode getInorderSucc(TreeNode p)
	{

		TreeNode result = null;
		if(p==null){
			return result;
		}

		if(p.right!=null){
			p=p.right;
			result = getLeftmost(p);
			return result;
		}

		TreeNode parent = p.parent;
		while(parent!=null && parent.right==p) 
		{
			p=parent;
			parent=parent.parent;
		}
		result=parent;
		return result;

	}

	public static TreeNode getLeftmost(TreeNode p)
	{
		TreeNode temp = p;
		while(temp.left!=null)
		{
			temp=temp.left;
		}
		return temp;
	}

	public static void main(String[] args)
	{


		TreeNode root = new TreeNode(10);	
		TreeNode firstleft = new TreeNode(5);
		firstleft.parent = root;
		root.left = firstleft;

		TreeNode firstright = new TreeNode(12);
		firstright.parent = root;
		root.right = firstright;

		TreeNode p1 = new TreeNode(3);
		p1.parent = firstleft;
		firstleft.left = p1;

		TreeNode p2 = new TreeNode(7);
		p2.parent = firstleft;
		firstleft.right = p2;

		TreeNode r1 = new TreeNode(6);
		r1.parent=p2;
		p2.left=r1;

		TreeNode r2 = new TreeNode(9);
		r2.parent=p2;
		p2.right=r2;


		TreeNode successor = getInorderSucc(root);
		if(successor!=null){
			System.out.println("Inorder successor is "+successor.data);
		}else{
			System.out.println("No inorder successor");
		}
	}

}


