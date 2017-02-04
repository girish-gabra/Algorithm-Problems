/*
Remove duplicates from an unsorted linked list

Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.

For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43. */
import java.util.*;
class Node
{
	int data;
	Node next;

	Node(int data)
	{
		this.data = data;
		next = null;
	}
}

class LinkedList
{
	Node head;


	LinkedList(Node head)
	{
		this.head = head;
	}

	public void insert(int data)
	{
		if(head==null){
			head = new Node(data);
			return;
		}

		Node p = new Node(data);
		p.next = head;	// insert at the beginning
		head = p;

		// insert at the end;
/*
		Node temp = head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next = p;*/
	}


	public void print()
	{
		Node curr = this.head;

		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.println();
	}

	public void removeDuplicates()
	{
		// if empty or 1 node then no duplicates
		if(head == null || head.next == null){
			return;
		}

		//O(n^2) solution
		/*Node ptr1 = this.head;
		Node ptr2 = null;

		while(ptr1!=null && ptr1.next!=null)
		{
			ptr2 = ptr1;
			while(ptr2.next!=null)
			{
				if(ptr1.data == ptr2.next.data)
				{
					//System.out.println("inside if: "+ptr2.next.data+"| prev: "+prev.data+" | ptr1: "+ptr1.data);	
					ptr2.next=ptr2.next.next;
				}else{
					//prev = ptr2;
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}*/

		//O(n) solution
		Set<Integer> set = new HashSet<Integer>();
		set.add(this.head.data);	// add head data
		Node temp = this.head;

		while(temp.next!=null)
		{
			if(!set.contains(temp.next.data)){
				set.add(temp.next.data);
				temp = temp.next;
			}
			else{
				temp.next = temp.next.next;
			}
		}

	}

}

class RemoveDuplicatesUnsorted
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Node head = new Node(5);
		LinkedList list = new LinkedList(head);
		list.insert(10);
		list.insert(20);
		list.insert(5);
		list.insert(20);
		list.insert(30);

		//Print the original list
		list.print();

		list.removeDuplicates();

		 System.out.println("Removing Duplicates: ");
		//Print the original list
		list.print();		
		sc.close();
	}

}