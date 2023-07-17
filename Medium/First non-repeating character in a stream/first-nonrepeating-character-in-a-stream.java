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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public String FirstNonRepeating(String A) {
        LinkedHashSet<Character> cache = new LinkedHashSet<Character>();

        HashMap<Character, Integer> seen = new HashMap<Character, Integer>();
        char ans[] = new char[A.length()];

        for (int i = 0; i < A.length(); ++i) {
            char curr = A.charAt(i);
            int frequency = seen.getOrDefault(curr, 0);

            if (frequency == 0) {
                seen.put(curr, 1);
                cache.add(curr);
            } else if (frequency == 1) {
                seen.put(curr, 2);
                cache.remove(curr);
            }

            if (cache.isEmpty())
                ans[i] = '#';
            else
                ans[i] = cache.iterator().next();
        }

        return String.valueOf(ans);
    }
}
