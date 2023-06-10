//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void Rearrange(int a[], int n)
    {
       /* Arrays.sort(a);
	    int temp;
	    for(int j=0;j<a.length;j++){
	    for(int i=0;i<a.length-1;i++){
	        if(a[i]>=0 && a[i]<a[i+1] ){
	            temp=a[i];
	            a[i]=a[i+1];
	            a[i+1]=temp;
	        }
	    }
	    }*/
	    
	  /*  for(int k : a){
	        System.out.println(k+" ");*/
	        
	        ArrayList<Integer> pos=new ArrayList<>();
	        ArrayList<Integer> neg=new ArrayList<>();
	        
	        for(int i=0;i<n;i++){
	            if(a[i]<0) neg.add(a[i]);
	            else pos.add(a[i]);
	        }
	        
	        int i=0,k=0,j=0;
	        
	        while(i<neg.size()){
	            a[k]=neg.get(i);
	            i++;
	            k++;
	        }
	        
	        while(j<pos.size()){
	            a[k]=pos.get(j);
	            j++;
	            k++;
	            
	        }
	    
    }
}