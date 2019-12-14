import java.util.Scanner;
class ENode
{
	private ENode next;
	private int Ename;
	public ENode(int Ename)
	{
		this.Ename=Ename;
		next=null;
	}
	public void setNext(ENode next)
    {
		this.next=next;
    }
    public void setEName(char Ename)
    {
    	this.Ename=Ename;
    }
	public ENode getNext()
    {
        return next;
    }
    public int getEName()
    {
        return Ename;
    }
}

class VNode 
{
	private VNode left;
	private ENode right;
	private int Vname;
	public VNode(int Vname)
	{
		this.Vname=Vname;
		left=null;
		right= null;
	}
	public void setLeft(VNode left)
	{
		this.left=left;
	}
	public void setRight(ENode right)
	{
		this.right= right;
	}
	public void setVName(int Vname)
	{
		this.Vname=Vname;
	}
	public VNode getLeft()
	{
		return left;
	}
	public ENode getRight()
    {
        return right;
    }
	public int getVName()
    {
        return Vname;
    }
}
class graph
{
	private VNode start;
	private int pred[];
	private char color[];
	private int n;
	public graph()
	{
		start=null;
	}
	public VNode insertVertexNode(int c)
	{
		VNode newnode = new VNode(c);
		if(start==null)
			start=newnode;
		else
		{
			VNode temp=start;
			while(temp.getLeft()!=null)
			{
				temp=temp.getLeft();
			}
			temp.setLeft(newnode);
		}
		return newnode;
	}
	public void insertEdgeNode(int c , VNode v )
	{
		ENode newnode = new ENode(c);
		ENode temp1 =v.getRight();
		if (temp1==null)
			v.setRight(newnode);
		else
		{
			while(temp1.getNext()!=null)
			{
				temp1=temp1.getNext();
			}
			temp1.setNext(newnode);
		}
	}
	public void dfs(int n)
	{
		this.n=n;
		pred =new int[n];
		color = new char[n];
		for(int i=0; i<n; i++)
		{
			color[i] = 'W';
			pred[i] = -1;
		}
		for(int i=0;i<n;i++)
		{
			if(color[i]=='W')
			{
				DFS_VISIT(i);
			}
		}
	}
	public void DFS_VISIT(int i)
	{
		color[i]='G';
		for(int j=0;j<n;j++)
		{
			if(color[j]=='G')
			{
				pred[j]=i;
				DFS_VISIT(j);
			}
		}
		color[i]='B';
		System.out.println(i);
	}
}
public class DFS
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertex");
		int vsize = sc.nextInt();
		graph g = new graph();
		for(int i=0;i<vsize;i++)
		{
			System.out.println("Enter a name of vertex you want to insert");
			int vname=sc.nextInt();
			VNode v = g.insertVertexNode(vname);
			System.out.println("Enter a number of edge in "+i+"vertex");
			int esize=sc.nextInt();
			for(int j=0;j<esize;j++)
			{
				System.out.println("Enter an edge name linked to "+v);
				int ename=sc.nextInt();
				g.insertEdgeNode(ename, v);
			}
		}
		g.dfs(vsize);
		
	}
}
