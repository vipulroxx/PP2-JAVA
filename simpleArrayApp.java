import java.util.Scanner;
class Array
{
	private int element[];
	private int maxSize;
	private int noEle;
	
	public Array(int maxSize)
	{
		this.maxSize = maxSize;
		element = new int[maxSize];
		noEle = 0;
	}
	
	public void setElement(int ele)
	{
		if (noEle < maxSize)
		{
			element[noEle] = ele;
			noEle++;
		}
	}
	
	public void insertAtPosition(int p, int ele)
	{
		for (int i = noEle - 1; i >= p - 1; i--)
		{
			element[i + 1] = element[i];
			element[i] = ele;
			noEle++;
		}
	}

	public int getElement(int pos)
	{
		return(element[pos]);
	}
	
	public int getMaxSize()
	{
		return(maxSize);
	}

	public int getNoEle()
	{
		return(noEle);
	} 
}

public class simplearrayapp
{
	public static void main(String[] args)
	{
		Array a = new Array(100);

		System.out.println("Enter 10 numbers");
		Scanner sc = new Scanner(System.in);
		
		for (int j = 0; j < 10; j++)
		{
			a.setElement(sc.nextInt());	
		}
		
		System.out.println("Array elements are : ");
		for (int i = 0; i < a.getNoEle(); i++)
		{
			int ele = a.getElement(i);
			System.out.println(ele);
		}	

		System.out.println("Enter the number to insert in the array : ");
		int numIns = sc.nextInt();
		System.out.println("Enter the position of the number to be inserted in the array : ");
		int pos = sc.nextInt();
		
		a.insertAtPosition(pos, numIns);
		System.out.println("Array elements are : ");
		for (int i = 0; i < 11; i++)
		{
			int ele = a.getElement(i);
			System.out.println(ele);
		}

		System.out.println("Enter a number to search : ");
		int n = sc.nextInt();
		int c = 0;
		for (int i = 0; i < a.getNoEle(); i++)
		{
			if (a.getElement(i) == n)
			{
				c = c + 1;
				System.out.println("The number was found in the array!");
			}
		}
		if (c == 0)
			System.out.println("The number was not found in the array!");	
	}
}