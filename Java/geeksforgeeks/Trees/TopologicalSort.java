import java.util.*;
class Order
{
	String name;
}

class OrderDependency
{
	Order order;
	Order dependency;

	OrderDependency(Order order, Order dependent)
	{
		this.order = order;
		this.dependency = dependent;
	}
}

class TopologicalSort
{

	static Map<String,Order> nameMap;

	public static List<Order> findCorrectOrder(List<OrderDependency> packageDependencies)
	{
		List<Order> result = new ArrayList<Order>();
		Map<String,ArrayList<Order>> map = new HashMap<String,ArrayList<Order>>();
		Map<String,Boolean> visited = new HashMap<String,Boolean>();


		for(OrderDependency orderDependency : packageDependencies )
		{
			String orderName = orderDependency.order.name;
			Order dependent = orderDependency.dependency;
			String dependentName = dependent.name;
			ArrayList<Order> dependents;
			//System.out.println(orderName+"-->"+dependent.name);
			if(!map.containsKey(orderName))
			{
				dependents=new ArrayList<Order>();
			}else{
				dependents = map.get(orderName);
			}
			dependents.add(dependent);
			map.put(orderName,dependents);	// Add all dependents for this order
			
			if(!map.containsKey(dependent.name)){	// Add dependent if not present
				map.put(dependentName, new ArrayList<Order>());
			}

			visited.put(orderName,false);
			visited.put(dependentName,false);
		}

		// print the Map
		for(Map.Entry<String,ArrayList<Order>> me : map.entrySet())
		{
			String orderName = me.getKey();
			ArrayList<Order> dependents = me.getValue();
			System.out.print(orderName+": ");
			for(Order dependent : dependents)
			{
				System.out.print(dependent.name+" ");
			}
			System.out.println();
		}

		// call recursive dfs helper
		dfs(packageDependencies.get(0).order.name,  map, result,visited);
		return result;
	}

	public static void dfs(String current, Map<String,ArrayList<Order>> map, List<Order> result, Map<String,Boolean> visited)
	{
		ArrayList<Order> temp = map.get(current);
	/*	if(temp.size()==0 && !visited.get(current)){
			Order order = new Order();
			order.name = current;
			result.add(order);
			visited.put(current,true);
			return;
		}*/

		for(Order order : temp)
		{
			String dependent = order.name;
			dfs(dependent,map,result,visited);
		}

		
		if(!visited.get(current)){
			Order currentOrder = new Order();
			currentOrder.name = current;	
			result.add(currentOrder);
			visited.put(current,true);
		}
		
	}


	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of packageDependencies");
		int n = Integer.parseInt(sc.next());
		// Enter order names like "A", "B", "C"
		System.out.println("Enter order and dependency separated by Space");
		List<OrderDependency> packageDependencies = new ArrayList<OrderDependency>();
		for(int i=0;i<n;i++)
		{
			
			Order order = new Order();
			Order dependent = new Order();
			order.name = sc.next();
			dependent.name = sc.next();
			OrderDependency orderDependency = new OrderDependency(order,dependent);
			packageDependencies.add(orderDependency);
		}
		List<Order> orders = findCorrectOrder(packageDependencies);
		System.out.println("Order to be executed: ");
		for(int i=0;i<orders.size();i++)
		{
			System.out.print(orders.get(i).name+" ");
		}
		sc.close();
	}
}
