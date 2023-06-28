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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends

class Solution{
    static boolean check(int n)
    {
        if(n==1 || n==7 || n==10)
            return true;
        if(n<10)
            return false;
            
        int num=0,temp=0;
        while(n!=0)
        {
            temp = (n%10); 
            num+=temp*temp;
            n/=10;
        }
        return check(num);
    }
    static int nextHappy(int N){
        // code here
        ++N;
        while(true)
            if(check(N))
                return N;
            else 
                ++N;
        
    }
}