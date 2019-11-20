import java.util.Scanner;
class TNode
{
	private TNode left;
	private TNode right;
	private int info;

	public TNode(int info)
	{
		this.info = info;
		left = null;
		right = null;
	}

	public void setInfo(int info)
	{
		this.info = info;
	}

	public void setLeft(TNode left)
	{
		this.left = left;
	}

	public void setRight(TNode right)
	{
		this.right = right;
	}

	public int getInfo()
	{
		return info;
	}

	public TNode getLeft()
	{
		return left;
	}

	public TNode getRight()
	{
		return right;
	}
}

class BSTree
{
	private TNode root;
	public BSTree()
	{
		root = null;
	}

	public TNode getRoot()
	{
		return root;
	}

	public void insert(int info)
	{
		TNode newNode = new TNode(info);
		if (root == null)
		{
			root = newNode;
		}
		else
		{
			TNode temp = root;
			TNode temp1 = root;
			while(temp != null)
			{
				if (info <= temp.getInfo())
				{
					temp1 = temp;
					temp = temp.getLeft();
				}
				else
				{
					temp1 = temp;
					temp = temp.getRight();
				}
			}
			if (info <= temp1.getInfo())
			{
				temp1.setLeft(newNode);
			}
			else
			{
				temp1.setRight(newNode);
			}
		}
	}

	public void preOrder(TNode temp)
	{
		if (temp != null)
		{
			System.out.print(temp.getInfo() + " ");
			preOrder(temp.getLeft());
			preOrder(temp.getRight());

		}
	}

	public void inOrder(TNode temp)
	{
		if (temp != null)
		{
			inOrder(temp.getLeft());
			System.out.print(temp.getInfo() + " ");
			inOrder(temp.getRight());
		}
	}

	public void postOrder(TNode temp)
	{
		if (temp != null)
		{
			postOrder(temp.getLeft());
			postOrder(temp.getRight());
			System.out.print(temp.getInfo() + " ");
		}
	}

	public void minimum(TNode temp)
	{
		int k = 0;
		while (temp != null)
		{

			k = temp.getInfo();
			temp = temp.getLeft();
		}
		System.out.println("The minimum node having value is " + k);
	}

	public void maximum(TNode temp)
	{
		int k = 0;
		while (temp != null)
		{
			k = temp.getInfo();
			temp = temp.getRight();
		}
		System.out.println("The maximum node having value is " + k);
	}

	public void search(TNode temp[], int info)
	{
		int k = 0;
		while (temp[0] != null)
		{
			if (info == temp[0].getInfo())
			{
				break;
			}
			else if (info < temp[0].getInfo())
			{
				temp[1] = temp[0];
				temp[0] = temp[0].getLeft();
			}
			else
			{
				temp[1] = temp[0];
				temp[0] = temp[0].getRight();
			}
		}
	}

	public void delete(int ele)
	{
		TNode temp[] = new TNode[2];
		temp[0] = root;
		temp[1] = root;
		search(temp, ele);
		if ((temp[0].getLeft() == null) && (temp[0].getRight() == null))
		{
			if (temp[1].getLeft() == temp[0])
			{
				temp[1].setLeft(null);
			}
			else
			{
				temp[1].setRight(null);
			}
		}
		else if ((temp[0].getLeft() == null) || (temp[0].getRight() == null))
		{
			if ((temp[0].getLeft() == null) && (temp[1].getLeft() == temp[0]))
			{
				temp[1].setLeft(temp[0].getRight());
			}
			else if ((temp[0].getRight() == null) && (temp[1].getLeft() == temp[0]))
			{
				temp[1].setRight(temp[0].getLeft());
			}
		}
	}
}

public class BinarySearchTree
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes present in the tree : ");
		int n = sc.nextInt();
		BSTree bst = new BSTree();
		for (int i = 0; i < n; i++)
		{
			System.out.println("Enter element " + (i + 1) + " : ");
			int info = sc.nextInt();
			bst.insert(info);
		}
		System.out.println("Pre Order Traversal : ");
		bst.preOrder(bst.getRoot());
		System.out.println();
		System.out.println("In Order Traversal : ");
		bst.inOrder(bst.getRoot());
		System.out.println();
		System.out.println("Post Order Traversal : ");
		bst.postOrder(bst.getRoot());
		System.out.println();
		System.out.println("Enter the number to delete : ");
		int del = sc.nextInt();
		bst.delete(del);
		System.out.println("Pre Order Traversal after deletion ; ");
		bst.preOrder(bst.getRoot());
		System.out.println();
		System.out.println("In Order Traversal afer deletion : ");
		bst.inOrder(bst.getRoot());
		System.out.println();
		System.out.println("Post Order Traversal after deletion : ");
		bst.postOrder(bst.getRoot());
		System.out.println();
	}
}
