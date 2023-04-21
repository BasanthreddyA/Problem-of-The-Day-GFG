//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int prefixSuffixString(String s1[],String s2[])
    {
        //Using brute force 
        int count = 0;
		for (int i = 0; i < s2.length; i++) {
			for (int j = 0; j < s1.length; j++) {

				if (s2[i].length() > s1[j].length()) {
					continue;
				} else {
					// Check prefix
					int k = 0;
					while (k < s2[i].length() && s2[i].charAt(k) == s1[j].charAt(k)) {
						k++;
					}
					if (k == s2[i].length()) {
						count++;
						break;
					}

					// Check suffix
					k = s1[j].length() - s2[i].length();
					int l = 0;
					while (l < s2[i].length() && s2[i].charAt(l) == s1[j].charAt(k)) {
						k++;
						l++;
					}
					if (k == s1[j].length()) {
						count++;
						break;
					}
				}
			}
		}

		return count;
    }
}