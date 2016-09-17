
/*Find Surpasser Count of each element in array

A surpasser of an element of an array is a greater element to its right, therefore x[j] is a surpasser of x[i] if i < j and x[i] < x[j]. The surpasser count of an element is the number of surpassers. Given an array of distinct integers, for each element of the array find its surpasser count i.e. count the number of elements to the right that are greater than that element.

Examples:

Input:  [2, 7, 5, 3, 0, 8, 1]
Output: [4, 1, 1, 1, 2, 0, 0]
*/
package geeksforgeeks;
import java.util.*;
class Surpasser
{
	//naive approach is to use two for loops. Here we use the mergesort technique to count the number of inversions. 
	//Then number of elements to the right that are greater than current element will be n-i-number of inversions for ith element

	public static void merge(int[] a, int low, int mid, int high, Map<Integer,Integer> map)
	{
		
		int[] temp = new int[high-low+1];

		int i=low;
		int j= mid+1;
		int k=0;
		int count = 0;
		while(i<=mid && j<=high)
		{
			if(a[i]<a[j]){
				map.put(a[i],map.get(a[i])+count);
				temp[k++]=a[i++];
			}
			else
			{
				temp[k++]=a[j++];
				count++;
			}	
		}

		while(i<=mid){
			map.put(a[i],map.get(a[i])+count);
			temp[k++]=a[i++];
		}

		while(j<=high){
			temp[k++]=a[j++];
		}
		k=0;
		//System.out.println("low: "+low+"high: "+high+" temp.length: "+temp.length);
		for(int m=low;m<=high;m++){
			a[m] = temp[k++];
		}
	}

	public static void mergesort(int[] a,int low,int high,Map<Integer,Integer> map)
	{
		if(low < high)
		{
			int mid = low+(high-low)/2;
			mergesort(a,low,mid,map);
			mergesort(a,mid+1,high,map);
			merge(a,low,mid,high,map);
		}
	}

	public static void calculateSurpasser(int[] a)
	{
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();

			//initialize map
			for(int i=0;i<a.length;i++){
				map.put(a[i],0);
			}
			//copy into another array
			int[] temp = new int[a.length];
			System.arraycopy(a,0,temp,0,a.length);

			System.out.println("Given Array: "+Arrays.toString(temp));
			//call mergesort with temp
			mergesort(temp,0,temp.length-1,map);

			//System.out.println(Arrays.toString(temp));

			for(int i=0;i<a.length;i++)
			{
				//System.out.println(a[i]+" map:"+map.get(a[i]));
				System.out.print((a.length-1)-i-map.get(a[i])+" ");
			}
	}
	
	public static void main(String[] args)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number of elements for array");
			int n  = sc.nextInt();
			System.out.println("Enter elements for array");
			int[] a = new int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
			}
			calculateSurpasser(a);
			
			sc.close();
		}		

}