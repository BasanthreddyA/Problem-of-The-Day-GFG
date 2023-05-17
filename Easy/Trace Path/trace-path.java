//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
        // code here
        int lr=0,lc=0,hc=0,hr=0,row=0,column=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                column--;
            }else if(s.charAt(i)=='R'){
                column++;
            }else if(s.charAt(i)=='U'){
                row++;
            }else if(s.charAt(i)=='D'){
                row--;
            }
            
            hr=Math.max(hr,row);
            lr=Math.min(lr,row);
            lc=Math.min(lc,column);
            hc=Math.max(hc,column);
        }
        
        return (hr-lr)<n && (hc-lc)<m ? 1 : 0;
    }
}