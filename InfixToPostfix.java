import java.util.Scanner;
class Stack
{
	private char data[];
	private int maxSize;
	private int top;

	public Stack(int maxSize)
	{
		this.maxSize = maxSize;
		data = new char[maxSize];
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

	public void push(char ele)
	{
		if (isFull())
		{
			System.out.println("Stack is full.");
		}
		else
		{
			top += 1;
			data[top] = ele;
		}
	}
	
	public char pop()
	{
		char ele=' ';
		if (isEmpty())
		{
			System.out.println("Stack is empty.");
		}
		else
		{
			ele = data[top];
			top -= 1;
		}
		return ele;
	}

	public void display()
	{
		int i;
		for (i = top; i >= 0; i--)
		{
			System.out.println(data[i]);
		}
	}
}	

public class InfixToPostfix
{
	public static boolean isOperator(char ch)
	{
		if (ch == '+' || ch == '-' || ch == '/' || ch == '%' || ch == '^')
			return true;
		else
			return false;
	}

	public static int precedenceOf(char ch)
	{
		if (ch == '+' || ch =='-')
			return 1;
		else if (ch == '/' || ch ==  '%' || ch == '*')
			return 2;
		else if (ch == '^')
			return 3;
		else
			return -1;
	}

	public static void main(String[] args)
	{
		Stack s = new Stack(100);
		String infix;
		char ch, st;
		int i , k, p, q, j = 0;
		Scanner sca = new Scanner(System.in);
		infix = sca.next();
		char postfix[] = new char[infix.length()];
		for (i = 0; i < infix.length(); i++)
		{
			ch = infix.charAt(i);
			if (ch == '(')
			{
				s.push(ch);
			}	
			else if (isOperator(ch))
			{
				p = precedenceOf(ch);
				if (s.isEmpty())
				{
					s.push(ch);
				}
				else
				{
					st = s.pop();
					q = precedenceOf(st);
					if (q < p)
					{
						s.push(st);
						s.push(ch);
					}
					else
					{
						while  (q >= p)
						{
							postfix[j] = ch;
							j++;
							st = s.pop();
							q = precedenceOf(st);
						}
					}
					s.push(ch);
					s.push(st);
				}
			}
			else if (ch == ')')
			{
				char sc;
				while ((sc = s.pop()) != '(')
				{
					postfix[j] = sc;
					j++;
				}
			}
			else
			{
				postfix[j] = ch;
				j++;
			}
		}

		while (!s.isEmpty())
		{
			postfix[j] = s.pop();
			j++;
		}
		
		for (k  = 0; k < postfix.length; k++)
		{
			System.out.print(postfix[k]);
		}
		System.out.println();
	}
}
