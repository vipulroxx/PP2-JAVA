import java.util.Scanner;

class circularQueue
{
	private int ele[];
	private int maxSize;
	private int front;
	private int rear;

	public circularQueue(int maxSize)
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
		return (((rear+1) % maxSize) == front);
	}
		
	public void insert(int element)
	{
		if (isFull())
		{
			System.out.println("Circular Queue is Full!!");
		}
		else
		{
			if (isEmpty())
			{
				front = 0;
				rear  = 0;
			}
			else
			{
				rear = (rear + 1) % maxSize;
			}
			ele[rear] = element;
			}
	}
		
	public int delete()
	{
		int element = 0;
		if (isEmpty())
			System.out.println("Linear Queue is Empty!!!, can't Delete");
		else
		{	
			if (front == rear)
			{
				element = ele[front];
				front = -1;
				rear = -1;
			}
			else
			{
				element = ele[front];
				front = (front+1) % maxSize;
			}
		}
	return element;
	}
		
	public void Display()
	{
		if (!isEmpty())
		{
			if (front <= rear)
			{
				for (int i = front; i <= rear; i++)
					System.out.print(ele[i] + " ");
			}
			else
			{
				for(int i = front;i < maxSize;i++)
					System.out.print(ele[i] + " ");
				for(int i = 0;i <= rear;i++)
		                        System.out.print(ele[i] + " ");
			}
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

public class CQueueApp
{
	public static void main(String[] args)
	{
		circularQueue s = new circularQueue(3);
		s.insert(10);
		s.insert(20);
		s.insert(30);
		s.insert(40);
		s.Display();
		int element = s.delete();
		s.insert(60);
		System.out.println("Deleted element : " + element);
		s.Display();
	}
}


