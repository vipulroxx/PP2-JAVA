import java.util.Scanner;

class LQueue
{
	private int ele[];
	private int maxSize;
	private int front;
	private int rear;

	public LQueue(int maxSize)
	{
		this.maxSize = maxSize;
		ele = new int[maxSize];
		front = -1;
		rear  = -1;
	}

	public boolean isEmpty()
	{
		return (front == -1 && rear == -1);
	}

	public boolean isFull()
	{
		return (rear == (maxSize - 1));
	}
		
	public void insert(int element)
	{
		if (!isFull())
		{
			if (isEmpty())
				front++;
			rear += 1;
			ele[rear] = element;
		}
		else
			System.out.println("Linear Queue is Full!!!");
	}
			
	public int delete()
	{
		int element = 0;
		if (isEmpty())
			System.out.println("Linear Queue is Empty!!!, can't Delete");
		else
		{	
			element = ele[front];
			front += 1;
			if (front > rear)
			{
				front = -1;
				rear  = -1;
			}
		}
		return element;
	}
		
	public void Display()
	{
		if (!isEmpty())
		{
			for (int i = front;i <= rear;i++)
				System.out.print(ele[i] + " ");
			System.out.println();
		}
		else 
			System.out.println("Linear Queue is Empty!!!");
	}

	public int getFront()
	{
		return front;
	}
		
	public int getRear()
	{
		return rear;
	}	
}

public class LQueueApp
{
	public static void main(String args[])
	{
		LQueue s = new LQueue(100);
		s.insert(10);
		s.insert(20);
		s.insert(30);
		s.insert(40);
		s.Display();
		int element = s.delete();
		System.out.println("Deleted element : " + element);
		s.Display();
	}
}


