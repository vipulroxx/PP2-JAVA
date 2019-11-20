import java.util.*;
class RecursiveMergeSort
{
	static void merge(int arr[], int low, int high, int mid)
	{
		int left[] = new int[mid - low + 2];
		int right[] = new int[high - mid + 1];
		int q = 0;
		for (int i = low; i <= mid; i++)
		{
			left[q] = arr[i];
			q++;
		}
		left[q] = 999999;
		q = 0;
		for (int i = mid + 1; i <= high; i++)
		{
			right[q] = arr[i];
			q++;
		}
		right[q] = 999999;
		int i = 0, j = 0, k = low;
		while ((left[i] != 999999) || (right[j] != 999999))
		{
			if (left[i] > right[j])
			{
				arr[k] = right[j];
				j++;
				k++;
			}
			else
			{
				arr[k] = left[i];
				i++;
				k++;
			}
		}
	}

	static void mergeSort(int arr[], int low, int high)
	{
		if (low < high)
		{
			int mid = (low + high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, high, mid);
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
		mergeSort(arr, 0, size - 1);
		System.out.println("Sorted array: ");
		for (int i = 0; i < size; i++)
		{
			System.out.println(arr[i] + " ");
		}
	}
}
