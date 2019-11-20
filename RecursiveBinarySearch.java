import java.util.Scanner;
class RecursiveBinarySearch
{
	static int binarySearch(int arr[], int size, int low, int high, int ele)
	{
		if (low == high)
		{
			if (arr[low] == ele)
			{
				return low;
			}
			else
			{
				return -1;
			}
		}
		else
		{
			int mid = (low + high)/2;
			if (arr[mid] == ele)
			{
				return mid;
			}
			else
			{
				if (arr[mid] > ele)
				{
					return binarySearch(arr, size, 0, mid - 1, ele);
				}
				else
				{
					return binarySearch(arr, size, mid + 1, high, ele);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the search number : ");
		int k = sc.nextInt();
		int pos = binarySearch(arr, size, 0, size - 1, k);
		System.out.println("Position of the search number " + k + " is " + (pos + 1) + ".");
	}
}
