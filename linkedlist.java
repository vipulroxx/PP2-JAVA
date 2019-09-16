class Node
{
	private int data;
	private Node next;
	
	public Node(int d)
	{
		this.data = d;
		next = null;
	}

	public void setData(int d)
	{
		this.data = d;
	}

	public void setNext(Node n)
	{
		this.next = n;
	}

	public int getData()
	{
		return data;
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

	public void InsertAtLast(int data)
	{
		Node newNode = new Node(data);
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
	
	public void display()
	{
		Node temp = start;
		while (temp != null)
		{
			System.out.println(temp.getData());
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
		l.display();
	}
}
