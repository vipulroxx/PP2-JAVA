class Stack
{
	private int ele[];
	private int top;
	private int maxSize;

	public Stack(int maxSize)
	{
		this.maxSize = maxSize;
		ele = new int[maxSize];
		top = -1;
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}

	public boolean isFull()
	{
		return (top == maxSize - 1);
	}

	public void push(int element)
	{
		if(isFull())
		{
			System.out.println("Stack is full.");
		}
		else
		{
			top += 1;
			ele[top] = element;
		}
	}

	public int pop()
	{
		int n = 0;
		if(isEmpty())
		{
			System.out.println("Stack is empty.");
		}
		else
		{       
			n = ele[top];
			top -= 1;
		}
		return n;
	}

	public void display()
	{
		int i;
		for (i = top; i >= 0; i--)
		{
			System.out.println(ele[i]);
		}
	}
}

public class stackApp
{
	public static void main(String[] args)
	{
		Stack s  = new Stack(100);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.display();
	}
}
