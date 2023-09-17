//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return list containing first n fibonacci numbers.
    static long fibb(int n,long []dp){
       if(n<=0){
           return 0;
       }
       if(n==1){
           return 1;
       }
       if(dp[n]!=-1){
           return dp[n];
       }
      
       return dp[n]=fibb(n-1,dp)+fibb(n-2,dp);
   }
    //Function to return list containing first n fibonacci numbers.
    static int indx;
    public static long[] printFibb(int n) 
    {      
        long dp[]= new long [n+1];
        Arrays.fill(dp,-1);
            indx=0;
            long arr[]=new long[n];
            for(int i=1;i<=n;i++){
                 arr[indx]=fibb(i,dp);
                 indx++;
            }
        return arr;
    }
}