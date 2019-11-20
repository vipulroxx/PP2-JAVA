import java.util.*;
class anagram
{
	static int count;
	static int size;
	static char[] word = new char[100];

	public static void display()
	{
		System.out.print("[");
		for (int i = 0; i < size; i++)
		{
			System.out.print(word[i]);
		}
		System.out.print("] ");
		if (count % 6 == 0)
		{
			System.out.println(" ");
		}
	}

	public static void rotate(int newSize)
	{
		int j;
		int position = size - newSize;
		char temp = word[position];
		for (j = position + 1; j < size; j++)
		{
			word[j - 1] = word[j];
		}
		word[j - 1] = temp;
	}

	public static void doAnagram(int newSize)
	{
		if (newSize == 1)
		{
			return;
		}
		for (int i = 0; i < size; i++)
		{
			doAnagram(newSize - 1);
			if (newSize == 2)
			{
				display();
			}
			rotate(newSize);
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word : ");
		String input = sc.next();
		size = input.length();
		count = 0;
		for (int i = 0; i < size; i++)
		{
			word[i] = input.charAt(i);
		}
		doAnagram(size);
	}
}
