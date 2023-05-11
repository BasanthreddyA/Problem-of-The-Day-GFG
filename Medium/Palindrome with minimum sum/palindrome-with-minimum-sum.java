//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int minimumSum(String S) {
        int l = 0;
        int r = S.length() - 1;
        int diff = 0;
        char curr = S.charAt(0);
        char prev = S.charAt(0);

        while (l < r) {
            if (S.charAt(l) == S.charAt(r)) {
                l++;
                r--;
                continue;
            } else if (S.charAt(l) == '?' && S.charAt(r) != '?') {
                S = replaceCharAt(S, l, S.charAt(r));
            } else if (S.charAt(l) != '?' && S.charAt(r) == '?') {
                S = replaceCharAt(S, r, S.charAt(l));
            } else {
                return -1;
            }
            l++;
            r--;
        }

        for (int i = 0; i <= S.length() / 2; i++) {
            if (S.charAt(i) != '?') {
                prev = curr;
                curr = S.charAt(i);
                if (prev != '?') {
                    diff += Math.abs(prev - curr);
                }
            }
        }
        return 2 * diff;
    }

    private static String replaceCharAt(String str, int index, char c) {
        char[] chars = str.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
