//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   
    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        
        if (sum % 2 == 1) return 0;
        
        int targetSum = sum / 2;
        boolean[][] dp = new boolean[N + 1][targetSum + 1];

        // Initialize the first column to true because you can always form a sum of 0 with an empty subset.
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        // Populate the dp array using bottom-up approach
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[N][targetSum] ? 1 : 0;
    }
}
