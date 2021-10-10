import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends




class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) { 
        int[] A =new int[n];
 int tw=0;int lb=0;int hb=0;int j=0;int i=0;int max;
 for(i=1;i<n;i++)
 {
    if(arr[i]>=arr[lb] && i==lb+1)
    {lb=i;}
    else if(arr[i]>=arr[lb] && i!=lb+1){hb=i;
       if(hb>0)
    {    
        A[j]=lb;
        A[j+1]=hb;
        j=j+2;
        lb=hb;
        hb=0;
    }}
    

 }i=lb;
 j=0;
 while(j<n-1 && A[j+1]>0){
 for(i=A[j]+1;i<A[j+1];i++)    
 {
    tw += arr[A[j]]-arr[i]; 
 }j=j+2;
 }
 max=arr[n-1];
 for(j=n-2;j>i&&lb<n-2;j--)
 { 
     
     if(max-arr[j]>0)
     {tw += max-arr[j];}
     
     if(max<arr[j])
     {max=arr[j];}
     
 }
 return tw;
        
    } 
}


