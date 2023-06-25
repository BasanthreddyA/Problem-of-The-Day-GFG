//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int f(int n,int r,int[][] dp){
        if(r>n) return dp[n][r]=0;
        if(n==r) return dp[n][r] = 1;
        if(r==0) return dp[n][r] = 1;
        if(r==1) return dp[n][r] = n;
        if(dp[n][r]!=-1) return dp[n][r];
    return dp[n][r] = (f(n-1,r,dp)%1000000007 + f(n-1,r-1,dp)%1000000007)%1000000007;
    }
    static int nCr(int n, int r){
        int[][] dp=new int[n+1][r+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<r+1;j++){
                dp[i][j]=-1;
            }
        }
        return f(n,r,dp);
    }

}