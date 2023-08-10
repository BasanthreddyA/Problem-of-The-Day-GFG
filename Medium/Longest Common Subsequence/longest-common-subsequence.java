//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2){
        int[] dp = new int[y + 1];
        for(int i = 0; i < s1.length(); ++i){
            int[] temp = new int[y + 1];
            for(int j = 0; j < s2.length(); ++j){
                if(s1.charAt(i) == s2.charAt(j)){
                    temp[j + 1] = dp[j] + 1;
                }else{
                    temp[j + 1] = Math.max(temp[j], dp[j + 1]);
                }
            }
            
            dp = temp;
        }
        return dp[y];
    }

}