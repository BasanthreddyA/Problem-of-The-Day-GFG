//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        int ans=0;
        for(int j=m-1;j>=0;j--){
            int currMaxGold=0;
            for(int i=0;i<n;i++){
                int leftUp=(i>0 && j<m-1)?M[i-1][j+1]:0;
                int left=(j<m-1)?M[i][j+1]:0;
                int leftDown=(i<n-1 && j<m-1)?M[i+1][j+1]:0;
                M[i][j]+=Math.max(leftUp,Math.max(left,leftDown));
                currMaxGold=Math.max(currMaxGold,M[i][j]);
            }
            ans=Math.max(ans,currMaxGold);
        }
        return ans;
    }
}