//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
	public static void main (String[] args)
	 {
    	 Scanner sc=new Scanner(System.in);
    	 int t=sc.nextInt();
    	 while(t-->0)
    	 {
    	        int n = sc.nextInt();
    		    int arr[] = new int[n];
    		    for(int i=0;i<n;i++)
    		    {
    		        arr[i] = sc.nextInt();
    		    }
    		    int sum = sc.nextInt();
    		    System.out.println(new Solution().subArraySum(arr, n, sum));
    		    
    		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int n, int sum)
    {
        // add your code here
        
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0,csum=0;
        for(int i=0;i<n;i++){
            csum+=arr[i];
            
            
            if(csum==sum){
                count++;
            }
            
            if(map.containsKey(csum-sum)){
                count+=map.get(csum-sum);
            }
            
            if(map.containsKey(csum)){
                map.put(csum,map.get(csum)+1);
              }  else{
                map.put(csum,1);
            }
        }
        return count;
    }
}