/*

Diameter of a Binary Tree

The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes). 
*/
import java.util.*;
class Node
{
	int value;
	Node left;
	Node right;

	Node(int value)
	{
		this.value = value;
		this.left = null;
		this.right = null;	
	}
}



class DiameterBinary
{

	static class Height
	{
		int h;
	}

	public static int height(Node root)
	{
		if(root==null){
			return 0;
		}

		return Math.max(height(root.left),height(root.right))+1;
	}

	//O(n^2) 
	public static int calculateDiameter(Node root)
	{
		
		if(root==null){
			return 0;
		}

		int leftHeight = height(root.left);					
		int rightHeight = height(root.right);

		int leftDiameter = calculateDiameter(root.left);		// recursively calculate diameter of left subtree
		int rightDiameter = calculateDiameter(root.right);		// recursively calculate diameter of right subtree

		int diameter = Math.max(leftDiameter,rightDiameter);	// take the maximum of two diameters
		return Math.max(leftHeight+rightHeight+1,diameter);		// take the max of height or the diameters
	}

	//O(n) 
	public static int calculateDiameterEfficent(Node root,Height height)
	{
		
		if(root==null){
			height.h=0;
			return 0;
		}

		Height lh = new Height();
		Height rh = new Height();

		lh.h++;
		rh.h++;
		System.out.println("lh.h"+lh.h);
		System.out.println("rh.h"+rh.h);
		 /* ldiameter  --> diameter of left subtree
           rdiameter  --> Diameter of right subtree */ 
        /* Get the heights of left and right subtrees in lh and rh
         And store the returned values in ldiameter and ldiameter */
		int leftDiameter = calculateDiameterEfficent(root.left,lh);		// recursively calculate diameter of left subtree
		int rightDiameter = calculateDiameterEfficent(root.right,rh);		// recursively calculate diameter of right subtree

		//current height is equal to maximum of two subtree heights+1
		height.h = Math.max(lh.h,rh.h)+1;
		System.out.println("lh.h"+lh.h);
		System.out.println("rh.h"+rh.h);
		int diameter = Math.max(leftDiameter,rightDiameter);	// take the maximum of two diameters
		return Math.max(lh.h+rh.h+1,diameter);		// take the max of height or the diameters
	}

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left  = new Node(4);
		root.left.right = new Node(5);
		
		//System.out.println("Diameter of binary tree: "+calculateDiameter(root));
		System.out.println("Diameter of binary tree: "+calculateDiameterEfficent(root,new Height()));
	}

}