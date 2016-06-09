/* Problem 4.1 -- Using BFS to determine if route is possible or not*/
package CTCI;
import java.util.*;
class Node
{
	String vertex;
	boolean visited;

	Node(String v)
	{
		this.vertex=v;
		visited=false;
	}
}

class Graph
{
	Node[] vertices;
	HashMap<String,List<Node>> edges = new HashMap<String,List<Node>>();

	Graph(int n)
	{
		vertices = new Node[n];
	}

	void addVertex(String vertex,int index)
	{
		Node node=new Node(vertex);

		vertices[index] = node;
	}

	void addEdge(String start, String dest)
	{
		List<Node> adjList;
		if(!edges.containsKey(start)){
			adjList = new ArrayList<Node>();
			Node destination = new Node(dest);
			adjList.add(destination);
			
		}else{
			adjList = edges.get(start);
			adjList.add(new Node(dest));	
		}

		edges.put(start,adjList);
	}

	void printGraph()
	{

		for(Map.Entry<String,List<Node>> me : edges.entrySet())
		{

			String vertex = me.getKey();
			List<Node> nodes = me.getValue();

			for(int i=0; i<nodes.size();i++){
				Node node = nodes.get(i);
				String neighbour = node.vertex;
				System.out.println(vertex+"-->"+neighbour);
			}

		}


	}

	boolean search(String source, String destination)
	{

		if(source.equals(destination)){
			return true;
		}	

		if(!edges.containsKey(source)){
				return false;
		}

		Queue<Node> list = new LinkedList<Node>();

		Node src = new Node(source);
		list.add(src);
		while(!list.isEmpty())
		{

			Node node = list.remove();
			node.visited=true;
			String vertex = node.vertex;
			System.out.println("started: "+vertex);
			if(edges.containsKey(vertex))
			{
				List<Node> nodes = edges.get(vertex);

				for(Node u : nodes){
					String name = u.vertex;
					System.out.println("name: "+name);
					if(name.equals(destination)){
						return true;
					}

					if(!u.visited){			// Add to list only if node is not visited
						list.add(u);
					}
				}

				
			}


		}

		return false;
	}

}


public class RouteBetweenNodes
{
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int vertices = s.nextInt();
		Graph g = new Graph(vertices);

		for(int i=0; i<vertices;i++){
			String vertex=s.next();
			g.addVertex(vertex,i);
		}
		int edges = s.nextInt();
		for(int i=0;i<edges;i++)
		{
			String start = s.next();
			String end = s.next();
			g.addEdge(start,end);
		}

		g.printGraph();
		char ch = 'y';
		do
		{
		System.out.println("Enter source and destination to find the route");
		String source = s.next();
		String destination = s.next();
			if(g.search(source,destination)){
				System.out.println("Route present");
			}else{
				System.out.println("Route not present");
			}
			System.out.println("Do you want to search another route? Press Y for yes. Any other key to exit");
			ch=s.next().charAt(0);
		}while(ch=='y'||ch=='Y');	
	}

}