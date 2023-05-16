//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends
class Solution {
    static Set<String> st;
    static int max;

    static {
        st = new HashSet<>();
        long p = 1;
        for (int i = 1; i <= 22; i++) {
            st.add(Long.toString(p, 2));
            p *= 5;
        }
        max = (int) 1e9;
    }

    static int helper(String s, int idx, int[] dp) {
        if (idx >= s.length())
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        StringBuilder sb = new StringBuilder();
        int ans = max;
        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (st.contains(sb.toString())) {
                ans = Math.min(ans, 1 + helper(s, i + 1, dp));
            }
        }
        dp[idx] = ans;
        return ans;
    }

    static int cuts(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        int ans = helper(s, 0, dp);
        return ans >= max ? -1 : ans;
    }
}
