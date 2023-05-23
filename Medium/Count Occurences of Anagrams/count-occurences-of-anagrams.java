//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

  public boolean allZero(List<Integer> count) {
        List<Integer> zeroList = Arrays.asList(new Integer[26]);
        Collections.fill(zeroList, 0);
        return count.equals(zeroList);
    }

    public int search(String pat, String txt) {
        int k = pat.length();
        List<Integer> count = new ArrayList<>(Collections.nCopies(26, 0));
        for (char ch : pat.toCharArray()) {
            count.set(ch - 'a', count.get(ch - 'a') + 1);
        }
        int i = 0, j = 0;
        int n = txt.length();
        int result = 0;
        while (j < n) {
            int idx = txt.charAt(j) - 'a';
            count.set(idx, count.get(idx) - 1);

            if (j - i + 1 == k) {
                if (allZero(count)) {
                    result++;
                }

                count.set(txt.charAt(i) - 'a', count.get(txt.charAt(i) - 'a') + 1);
                i++;
            }
            j++;
        }
        return result;
    }
}