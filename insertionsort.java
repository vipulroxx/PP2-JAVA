import java.util.Scanner;
class insertionsort
{
	public static void insertionSort(int arr[], int n)
	{
		int i , j, key;
		for (i = 1; i < n; i++)
		{
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j = j - 1;
			}
			arr[j+1] = key;
		}
		System.out.println();
		System.out.print("Sorted Array : ");
		for (i = 0; i < 10; i++)
		{
			System.out.print(arr[i] + " ");
		}	
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int i;
		System.out.println("Enter the 10 numbers of an array");
		for (i = 0; i < 10; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.print("Original Array : ");
		for (i = 0; i < 10; i++)
		{
			System.out.print(arr[i] + " ");
		}
		insertionSort(arr, 10);
	}
}
