import java.io.*;

public class ARRAYsmal
{
	public static void main (String []arg) throws IOException
	{
		int n,i,small;
		int []a = new int[100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("How Many Elements You Wants?");
		n=Integer.parseInt(br.readLine());
		
		System.out.print("Enter Array Elements : ");
		for(i=0; i<n; i++)
       {
           a[i]=Integer.parseInt(br.readLine());
       }  
       small = a[0];
      
       for(i=0; i<n; i++)
       {
           if(small < a[i])
           {
               small = a[i];
           }
           
       }
             System.out.print("Smallest Number = " +small); 
    } 
	
}
