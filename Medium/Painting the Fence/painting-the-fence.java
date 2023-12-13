//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    long countWays(int n,int k)
    {
        //code here.
        int mod = (int)1e9+7;
        
      
        long dp[][] = new long[n + 1][2];
        
        // Initialize base cases
        dp[1][0] = k;
        dp[1][1] = 0;
        
        for (int i = 2; i <= n; i++) {
            dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1]) * (k - 1)) % mod;
            dp[i][1] = dp[i - 1][0];
        }
        
        return (dp[n][0] + dp[n][1]) % mod;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);

            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.countWays(n,k);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends