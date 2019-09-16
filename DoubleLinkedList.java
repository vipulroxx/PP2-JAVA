class Student
{
	private String name;
	private int rNo;
	private int age;

	public Student(String name, int rNo, int age)
	{
		this.name = name;
		this.rNo = rNo;
		this.age = age;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setRNo(int rNo)
	{
		this.rNo = rNo;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public int getRNo()
	{
		return rNo;
	}

	public int getAge()
	{
		return age;
	}
}

class DNode
{
	private Student info;
	private DNode next;
	private DNode prev;

	public DNode(Student info)
	{
		this.info = info;
		next = null;
		prev = null;
	}

	public void setInfo(Student info)
	{
		this.info = info;
	}

	public void setNext(DNode next)
	{
		this.next = next;
	}
	
	public void setPrev(DNode prev)
	{
		this.prev = prev;
	}
	
	public Student getInfo()
	{
		return info;
	}

	public DNode getNext()
	{
		return next;
	}
	
	public DNode getPrev()
	{
		return prev;
	}
}
