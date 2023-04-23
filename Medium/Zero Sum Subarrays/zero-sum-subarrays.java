//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
     public static long findSubarray(long[] arr ,int n) 
    {
        HashMap<Long,Integer> map = new HashMap<>();
        long res = 0;
        long preSum = 0;
        map.put(preSum,1);
        
        int i = -1;
        while(i<n-1){
            i++;
            preSum += arr[i];
            
            if(map.containsKey(preSum)){
                res += map.get(preSum);
                map.put(preSum,map.get(preSum)+1);
            }else{
                map.put(preSum,1);
            }
        }
        return res;
    }
}