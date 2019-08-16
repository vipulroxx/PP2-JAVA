import java.util.Scanner;
import java.util.Collections; 
class orderArray
{
	private int element[];
	private int maxSize;
	private int noEle;
	
	public orderArray(int maxSize)
	{
		this.maxSize = maxSize;
		element = new int[maxSize];
		noEle = 0;
	}
	
	public void Insert(int ele)
	{

		int i, p, l = 0, h = noEle - 1, m = 0;
		while (l <= h)
		{
			m = (l + h)/2;
			if (ele > element[m])
			{
				l = m + 1;
			}
			else if (ele < element[m])
			{
				h = m - 1;
			}
		}

		for (int j = noEle - 1; j >= h + 1; j--)
		{
			element[j + 1] = element[j];
		}

		element[h + 1] = ele;
		noEle++;		
	}
	
	public void Delete(int p)
	{
		
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

public class insertdeletearrayapp
{
	public static void main(String[] args)
	{
		orderArray a = new orderArray(100);

		System.out.println("Enter 10 numbers");
		Scanner sc = new Scanner(System.in);
		
		for (int j = 0; j < 10; j++)
		{
			a.Insert(sc.nextInt());	
		}
		
		System.out.println("Array elements are : ");
		for (int i = 0; i < a.getNoEle(); i++)
		{
			int ele = a.getElement(i);
			System.out.println(ele);
		}	

	}
}