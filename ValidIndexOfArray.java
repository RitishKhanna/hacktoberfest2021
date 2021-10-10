//a program to check whether the indexes given are valid index are not. Print "Out of Bounds" if any attempt is made to refer to an element whose index is beyond the array size , else print the element present at the index.
//The first line of input contains n , denoting the size of array.
//The second line contains n spaced integers , denoting elements of array 
//The third line contains q, denoting number of queries
//Next q lines contains an integer, index, which is to be tested.


import java.util.Scanner;
class Main{
    public static void main(String[] args)
    {
       int n;
		Scanner ref = new Scanner(System.in);
		n = ref.nextInt();
		int i;
		int a[] = new int[n];
		for(i=0;i<n;i++)
		{
			a[i] = ref.nextInt();
		}
		int r = ref.nextInt();
        int h = ref.nextInt();
		try {
			if(r>=n)
			{
				throw new ArrayOutBound("Out of Bounds");
			}
			else
				System.out.println(a[r]);
		}
		catch(ArrayOutBound ex)
		{
			System.out.println(ex.getMessage());
		}
      try {
			if(h>=n)
			{
				throw new ArrayOutBound("Out of Bounds");
			}
			else
				System.out.println(a[h]);
		}
		catch(ArrayOutBound ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
class ArrayOutBound extends Exception{
	ArrayOutBound (String msg)
	{
		super(msg);
	}


}
