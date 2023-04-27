//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N = sc.nextInt();
            int K = sc.nextInt();
           
            Solution ob = new Solution();
            int ans = ob.setKthBit(N,K);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution{
    static int setKthBit(int N,int K){
        
        String str = Integer.toBinaryString(N);
        char ch[] = str.toCharArray();
        int l = str.length();//4
        if(K<l){
            if(ch[l-K-1]=='0'){
                ch[l-K-1] = '1';
            }
        }
        String s = String.valueOf(ch);
        return Integer.parseInt(s,2);
    }
}