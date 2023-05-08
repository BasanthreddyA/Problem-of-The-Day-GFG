//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends

class Solution
{
    String UncommonChars(String A, String B)
    {   
        String S = "";
        int a[] = new int [256];
        int b [] = new int [256];
        for(int i = 0;i<A.length();i++){
            a[A.charAt(i)]++;
        }
        for(int i =0;i<B.length();i++){
            b[B.charAt(i)]++;
        }
        for(int i =0;i<256;i++){
            if(a[i]>0&&b[i]==0 ){
                   S+=(char)(i);
            }else if(a[i]==0&&b[i]>0){
                    S+=(char)(i);
            }
        }
        if(S.length()==0){
            S+="-1";
        }
        return S;
    }
}