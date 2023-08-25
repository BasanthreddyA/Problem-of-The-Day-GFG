//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends

class Solution {
    public int longestkSubstr(String s, int k) {
        int l = 0;
        int r = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int ans= -1;
        
        while(r<s.length()){
            //adding characters in the window
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            //window size hit when map conatins extacty k unique character
            if(map.size() == k){
                ans= Math.max(ans,r-l+1);
            }
            
            // window size get exceed whem it contains charcter more than k
            if(map.size() >k){
                //removing charcters from left Hand Side to make window size of k
                while(map.size()>k){
                    char charc = s.charAt(l);
                    map.put(charc,map.get(charc)-1);
                    if(map.get(charc)==0) map.remove(charc);
                    l++;
                }
            }
            
             
            
            r++;
        }
        
        return ans;
    }
}


