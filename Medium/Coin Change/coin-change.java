//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends

class Solution {
    public long count(int coins[], int N, int sum) {
        long dp[][]=new long[N+1][sum+1];
        for(int i=N-1;i>=0;i--)
        {
            for(int j=0;j<=sum;j++)
            {
                if(j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                long x=0,y=0;
                if(j-coins[i]>=0)
                x=dp[i][j-coins[i]];
                y=dp[i+1][j];
                dp[i][j]=x+y;
            }
        }
        return dp[0][sum];
        // code here.
    }
}