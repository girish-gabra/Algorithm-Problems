// CTCI 4.5			Implement a function to check if binary tree is binary search tree or not
package CTCI;
class Node
{
	int data;
	Node left;
	Node right;

	Node(int d)
	{
		this.data = d;
		this.left = this.right=null;
	}
}



class ValidateBST
{

	Node root;
	/* TIme complexity is O(n) where n is number of nodes in tree*/
	public boolean checkBST()
	{
		return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}



	public boolean checkBST(Node p, int min, int max)
	{

		if(p==null){
			return true;
		}

		if(p.data < min || p.data > max){
			return false;
		}	

		if(!checkBST(p.left,min,p.data) || !checkBST(p.right,p.data,max)){
			return false;
		}				

		return true;
	}

	public static void main(String[] args)
	{
		ValidateBST tree = new ValidateBST();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(8);				// should come as not bst as 8 < 10
        tree.root.right.left = new Node(16);

        if(tree.checkBST()){
        	System.out.println("It is a BST");
        }else{
        	System.out.println("Not a BST");
        }
	}
		


}