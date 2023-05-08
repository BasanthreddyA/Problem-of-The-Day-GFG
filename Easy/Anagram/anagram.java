//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        char[] c1=a.toCharArray();
        Arrays.sort(c1);
        char[] c2=b.toCharArray();
        Arrays.sort(c2);
        if(Arrays.equals(c1,c2))
        {
            return true;
        }
        
            return false;
        
    }
}