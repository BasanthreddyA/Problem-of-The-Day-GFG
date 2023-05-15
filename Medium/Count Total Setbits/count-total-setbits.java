//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static long countBits(long N) {
        long count = 0;
        int powerOfTwo = 1;

        while (powerOfTwo <= N) {
            // Count the number of groups of 1s based on the power of two
            count += (N / (powerOfTwo * 2)) * powerOfTwo;

            // Count the remaining 1s in the last group
            count += Math.max(0, (N % (powerOfTwo * 2)) - powerOfTwo + 1);

            // Increase the power of two
            powerOfTwo *= 2;
        }

        return count;
    }
}
