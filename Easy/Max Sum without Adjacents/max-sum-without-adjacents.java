//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    int findMaxSum(int arr[], int n) {
        // Create an array to store the results of subproblems
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Call the recursive function
        return findMaxSumRecursive(arr, n - 1, dp);
    }

    // Recursive function with memoization
    int findMaxSumRecursive(int arr[], int i, int[] dp) {
        if (i < 0) {
            return 0;
        }

        // If the result is already computed, return it
        if (dp[i] != -1) {
            return dp[i];
        }

        // Calculate the maximum sum considering or excluding the current element
        int includeCurrent = arr[i] + ((i - 2) >= 0 ? findMaxSumRecursive(arr, i - 2, dp) : 0);
        int excludeCurrent = findMaxSumRecursive(arr, i - 1, dp);

        // Store the result in the memoization array
        dp[i] = Math.max(includeCurrent, excludeCurrent);

        return dp[i];
    }
}
