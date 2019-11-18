class Queue
{
	private final int size = 20;
	private int[] queueArray;
	private int front;
	private int rear;

	public Queue()
	{
		queueArray = new int[size];
		front = 0;
		rear = -1;
	}

	public void insert(int j)
	{
		if (rear == size - 1)
		{
			rear = -1;
		}
		queueArray[++rear] = j;
	}

	public int remove()
	{
		int temp = queueArray[front++];
		if (front == size)
		{
			front = 0;
		}
		return temp;
	}

	public boolean isEmpty()
	{
		return ((rear + 1 == front) || (front + size - 1 == rear));
	}
}

class Vertex
{
	public char label;
	public boolean wasVisited;
	
	public Vertex(char lab)
	{
		label = lab;
		wasVisited = false;
	}
}

class Graph
{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue queue;

	public Graph()
	{
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++)
		{
			for (int k = 0; k < MAX_VERTS; k++)
			{
				adjMat[j][k] = 0;
			}
		}
		queue = new Queue();
	}

	public void addVertex(char lab)
	{
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label + " ");
	}

	public int getAdjUnvisitedVertex(int v)
	{
		for (int j = 0; j < nVerts; j++)
		{
			if ((adjMat[v][j] == 1) && (vertexList[j].wasVisited == false))
			{
				return j;
			}
		}
		return -1;
	}

	public void BFS()
	{
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.insert(0);
		int v2;
		while (!queue.isEmpty())
		{
			int v1 = queue.remove();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1)
			{
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				queue.insert(v2);
			}
		}
		for (int j = 0; j < nVerts; j++)
		{
			vertexList[j].wasVisited = false;
		}
	}
}

public class BFS
{
	public static void main(String[] args)
	{
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);

		System.out.println("Vertex visited in order :");
		graph.BFS();
		System.out.println();
	}
}
