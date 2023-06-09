//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends

class Solution {
    Set<String> set = new HashSet<>();
    
    public List<String> find_permutation(String S) {
        permutation(S, "");
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
    
    public void permutation(String S, String ans) {
        if (S.length() == 0) {
            set.add(ans);
            return;
        }
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            String roq = S.substring(0, i) + S.substring(i + 1);
            
            permutation(roq, ans + ch);
        }
    }
}
