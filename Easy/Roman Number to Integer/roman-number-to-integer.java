//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        
         Map<Character,Integer> map=new HashMap<>() {{
             put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int res=0,n=s.length();

        for(int i=0;i<n;i++){
            if(i<n-1 && map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                res-=map.get(s.charAt(i));
            }else{
                 res+=map.get(s.charAt(i));
            }
        }
        return res;
        // code here
    }
}