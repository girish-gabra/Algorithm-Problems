/* CTCI Problem 4.3 */
package CTCI;
import java.util.*;
class BTNode
{
	int data;
	BTNode left;
	BTNode right;
}

public class ListOfDepths
{
	/*Similar to BFS*/
	public static ArrayList<ArrayList<BTNode>> createLists(BTNode root)
	{
		ArrayList<ArrayList<BTNode>> list = new ArrayList<ArrayList<BTNode>>();

		Queue<BTNode> queue = new LinkedList<BTNode>();

		queue.offer(root);
		queue.offer(null);

		ArrayList<BTNode> levelList = new ArrayList<BTNode>();
		while(!queue.isEmpty())
		{
			BTNode temp = queue.poll();
			
			if(temp!=null)
			{
				levelList.add(temp);

				if(temp.left!=null){
					queue.offer(temp.left);
				}

				if(temp.right!=null)
				{
					queue.offer(temp.right);
				}
				
			}else{
				list.add(levelList);
				levelList=new ArrayList<BTNode>();	
				if(!queue.isEmpty())
				{
					queue.offer(null);
				}	
			}

		}	

		return list;
	}




	public static void main(String[] args)
	{

		//Scanner s = new Scanner();
		
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

		ArrayList<ArrayList<BTNode>> result = createLists(root);
		
		for(int i=0;i<result.size();i++)
		{
			ArrayList<BTNode> list =  result.get(i); 	
			for(int j=0; j<list.size();j++)
			{
				BTNode p = list.get(j);
				System.out.print(p.data+" ");
			}
			System.out.println();
		}	
	}


}