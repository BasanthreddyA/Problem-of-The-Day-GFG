//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
      /*  int dp[]=new int[n+1];
       return DpSolve(0,arr,dp);
    }
    
    public int DpSolve(int ind,int[] arr,int[] dp){
        if(ind>arr.length) return 0;
        
        if(dp[ind]!=-1)  return dp[ind];
        
        int pic=arr[ind]+DpSolve(ind+2,arr,dp);
        int notpic=DpSolve(ind+1,arr,dp);
        
        return Math.max(pic,notpic);
    }*/
    
    if(n==0){
        return 0;
    }
    
    int prev1=0;
    int prev2=0;
    for(int i:arr){
        int temp=prev1;
        prev1=Math.max(prev2+i,prev1);
        prev2=temp;
    }
    return prev1;
    }
}