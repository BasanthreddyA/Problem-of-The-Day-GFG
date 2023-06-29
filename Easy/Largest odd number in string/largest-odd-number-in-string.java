//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.maxOdd(s));
        }
    }
}
// } Driver Code Ends


class Solution {

     String maxOdd(String s) {
         
         for(int i=s.length()-1;i>=0;i--){
             if((s.charAt(i)-'0')%2!=0)
                 return s.substring(0,i+1);
             
         }
         return "";
       /* StringBuilder sb = new StringBuilder();
        int maxOddDigit = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (digit % 2 != 0 && digit > maxOddDigit) {
                    maxOddDigit = digit;
                }
            }
        }
        retrurn Integer.toString(maxoddDigit);*/
     }
}