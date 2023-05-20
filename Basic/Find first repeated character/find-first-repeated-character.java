//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}
// } Driver Code Ends

class Solution 
{ 
    String firstRepChar(String s) 
    { 
        // code here
        HashSet<Character> hashSet = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            if(hashSet.contains(s.charAt(i))){
                return String.valueOf(s.charAt(i));
            }else{
                hashSet.add(s.charAt(i));
            }
        }
        return "-1";
    }
} 
 