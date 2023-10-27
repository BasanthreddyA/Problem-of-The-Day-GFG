//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        //your code here
        
        int n=S.length();
        StringBuilder sb=new StringBuilder(S);
        sb.reverse();
        String s1=sb.toString();
        return n-lcs(S,s1,n,n);
    }
        static int lcs(String x,String y,int m,int n){
            int[][] dp=new int[n+1][m+1];
            
            for(int i=0;i<n+1;i++){
                for(int j=0;j<m+1;j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }else if(x.charAt(i-1) == y.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }
            
            return  dp[n][m];
        }
}