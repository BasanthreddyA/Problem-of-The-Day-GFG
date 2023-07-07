//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        return palin(0,S);
    }
    
    int palin(int start,String s){
       // int end=
        if(start>=s.length()/2){
            return 1;
        } 
        
        if(s.charAt(start)!=s.charAt(s.length()-start-1)){
        return 0;
        }
        
        return palin(start+1,s);
        
        
    }
};