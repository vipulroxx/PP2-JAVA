class Priorityqueue 
{
	int maxsize;
	int [] arr;
	int f,r,n;

	public Priorityqueue(int s)
	{
		maxsize=s;
		arr=new int[maxsize];
		f=-1;
		r=-1;
		n=0;

	}

	public boolean isempty()
	{
		if(f == -1 || r == -1)
			return (true);
                else
			return (false);
	}
	
	public boolean isfull()
	{
		if ((f == 0 && r == maxsize-1) || (f == r+1))
	
		return (true);
		else
			return (false);
	}
	public void insert(int value)
	{
		int i;
		if (isempty())
		{
			f=0;
			r=0;
			arr[f] = value;
			n++;
		}
		else
		{
			for(i = n-1; i >= 0; i--)
			{
				if(value > arr[i])
					arr[i+1] = arr[i];
				else
				       	break;

			}
			arr[i+1] = value;
			n++;
			r++;
		}

	}

	public int delete()
	{
		int temp=0;
		if (!(isempty()))
		{
		 	temp = arr[f];
			if(f == r)
			{
				f=-1;
				r=-1;
			}

			else
				f=f+1;
		}
		return temp;
	}

	public void display()
	{
		int i;
		for(i = f; i<=r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

class Priorityqueueapp
{
	public static void main(String args[])
	{
		Priorityqueue p = new Priorityqueue(10);
		p.insert(7);
		p.insert(5);
		p.insert(88);
		p.insert(77);
		p.insert(33);
		p.display();
		int val=p.delete();
		System.out.println("Deleted element : " + val);
		p.display();
	}
}
