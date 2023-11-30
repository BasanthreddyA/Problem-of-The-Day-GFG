//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int minStep(int n)
    {
        // code here
        return dp(n) - 1;
    }
    
    public int dp(int i){
        if (i <= 0){
            return 0;
        }
        
        if (i % 3 == 0){
            return 1 + dp(i / 3);
        }
        
        else{
            return 1 + dp(i-1);
        }
    }
}