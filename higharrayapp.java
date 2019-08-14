import java.util.Scanner;
class higharray
{
	private int element[];
	private int maxSize;
	private int noEle;
	
	public higharray(int maxSize)
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

	public int getElement(int pos)
	{
		return(element[pos]);
	}

	public int getNoEle()
	{
		return(noEle);	
	}

	public int getMax()
	{
		int max = element[0];	
		if (noEle == 0)
		{
			return(-1);
		}
		else
		{
			for(int i = 1; i < noEle; i++)
			{
				if (element[i] > max)
				{
					max = element[i];
				}
			}
			return max;
		}	
	}
	
	public int removeMax()
	{
		int max = getMax();
		int pos = 0, i;
		for(i = 0; i < noEle; i++)
		{
			if (element[i] == max)
			{
				pos = i;
				break;
			}			
		}
		for(i = pos; i < noEle; i++)
		{
			element[i] = element[i+1];
		}
		noEle--;
		return max;	
	}
	
}

public class higharrayapp
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		higharray a = new higharray(100);
		System.out.println("Enter the ten numbers of an array : ");
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

		System.out.println("Maximum value in the array: " +a.getMax());
		System.out.println("Maximum value " +a.removeMax()+ " removed from the array.");
		System.out.println("Array elements are : ");
		for (int i = 0; i < a.getNoEle(); i++)
		{
			int ele = a.getElement(i);
			System.out.println(ele);
		}	

	}
}