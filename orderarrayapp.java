import java.util.Scanner;
class sortedArray
{
	public static void order(int arr[], int ele, int numEle)
	{
		int i;
		for ( i = numEle - 1; i >= 0 && arr[i] >= ele; i--)
		{
			arr[i+1] = arr[i];
			
		}
		arr[i+1] = ele;
	}
	
	public void Display(int arr[])
	{
		System.out.println("Elements of the array in sorted form : ");
		for (int i = 0; i < 10; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public void search(int arr[], int n)
	{
		int c = 0;
		for (int i = 0; i < 10; i++)
		{
			if (arr[i] == n)
			{
				c = c + 1;
				System.out.println("The number was found in the array!");
			}
		}
		if (c == 0)
			System.out.println("The number was not found in the array!");	
	}

	public int binarySearch(int arr[], int l, int r, int x) 
    	{ 
        	if (r >= l)
		{ 
            		int mid = l + (r - l) / 2; 
  
            	if (arr[mid] == x) 
                	return mid; 
  
           	if (arr[mid] > x) 
                	return binarySearch(arr, l, mid - 1, x); 
  
            	return binarySearch(arr, mid + 1, r, x); 
        	}
		return -1;
	}
}

public class orderarrayapp
{	
	public static void main(String args[])
	{

		sortedArray sa = new sortedArray();
		System.out.println("Enter the elements of an array : ");
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		for (int i = 0; i<10; i++)
		{	
			sa.order(arr, sc.nextInt(), i);
		}
		sa.Display(arr);
		System.out.println("Enter the linear search element : ");
		int n = sc.nextInt();
		sa.search(arr, n);
		System.out.println("Enter the binary search element : ");
		int x = sc.nextInt();
		if (x == arr[sa.binarySearch(arr, 0, 10, x)])
			System.out.println("The number was found in the array!");
		else
			System.out.println("The number was not found in the array!");
	}
}
