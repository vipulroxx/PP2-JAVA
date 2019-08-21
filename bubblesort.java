import java.util.Scanner;
class bubblesort
{
	public static void bubbleSort(int arr[], int n)
	{
		int i , j, temp;
		for (i = 0; i < n-1; i++)
			for (j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
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
		bubbleSort(arr, 10);
	}
}