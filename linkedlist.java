class Node
{
	private int info;
	private Node next;
	
	public Node(int d)
	{
		this.info = d;
		next = null;
	}

	public void setinfo(int d)
	{
		this.info = d;
	}

	public void setNext(Node n)
	{
		this.next = n;
	}

	public int getInfo()
	{
		return info;
	}
	
	public Node getNext()
	{
		return next;
	}
}

class SingularLinkedList
{
	private Node start;
	
	public SingularLinkedList()
	{
		start = null;
	}

	public void setStart(Node start)
	{
		this.start = start;
	}

	public Node getStart()
	{
		return start;
	}

	public void InsertAtFirst(int info)
	{
		Node temp = null;
		Node newnode = new Node(info);
		if(start==null)
		{
			start=newnode;
		}
		else
		{
			temp=start;
			start=newnode;
			newnode.setNext(temp);
		}
	}

	public void InsertAtLast(int info)
	{
		Node newNode = new Node(info);
		if (start == null)
		{
			start = newNode;
		}
		else
		{
			Node temp = start;
			while (temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}

	public void InsertAtPos(int pos , int info)
	{
		Node temp = start;
		int i = 0;
		if (pos == 1)
		{
			InsertAtFirst(info);
		}
		else
		{	
			while (temp != null)
        		{
				i += 1;
        	        	temp = temp.getNext();
        	        }
			if(pos == i + 1)
			{
				InsertAtLast(info);
			}
			else if(pos > 0 && pos <= i)
			{	
				Node newnode = new Node(info);
				int k = 1;
				Node temp1 = start;
				Node temp2 = start;
				while(k < pos)
				{
					temp1 = temp2;
					temp2 = temp1.getNext();
					k += 1;

				}
				newnode.setNext(temp2);
				temp1.setNext(newnode);
			}
			else if(pos > i + 1)
			{
				System.out.println("invalid position");
			}
		}
	}

	public void DeleteAtFirst()
	{
		start = start.getNext();
	}

	public void DeleteAtLast()
	{
		Node temp1 = start;
		Node temp2 = start;
		
		while (temp2.getNext() != null)
		{
			temp1 = temp2;
			temp2 = temp2.getNext();
		}
		temp1.setNext(null);
	}

	public void display()
	{
		Node temp = start;
		while (temp != null)
		{
			System.out.println(temp.getInfo());
			temp = temp.getNext();
		}
	}

}

public class linkedlist
{
	public static void main(String[] args)
	{
		SingularLinkedList l = new SingularLinkedList();
		l.InsertAtLast(50);
		l.InsertAtLast(40);
		l.InsertAtLast(30);
		l.InsertAtLast(20);
		l.InsertAtLast(10);
		System.out.println("Linked List");
		l.display();
		System.out.println("Linked List after inserting 70 at first position");
		l.InsertAtFirst(70);
		l.display();
		System.out.println("Linked List after inserting 60 at position 3");
		l.InsertAtPos(3,60);
		l.display();
		System.out.println("Linked List after deleting the first Node");
		l.DeleteAtFirst();
		l.display();
		System.out.println("Linked List after deleting the last Node");
		l.DeleteAtLast();
		l.display();
	}
}
