//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


class Solution {
    int[][] dp;

    public int maxSumIS(int arr[], int n) {
        // Initialize the dp array with -1 values
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, arr, -1);
    }

    public int helper(int i, int[] arr, int prev) {
        if (i >= arr.length) return 0;

        int take = 0;

        if (prev != -1 && dp[i][prev] != -1) {
            return dp[i][prev];
        }

        if (prev == -1 || arr[i] > arr[prev]) {
            take = helper(i + 1, arr, i) + arr[i];
        }

        int notpick = helper(i + 1, arr, prev);

        if (prev != -1) {
            dp[i][prev] = Math.max(take, notpick);
        }

        return Math.max(take, notpick);
    }
}
