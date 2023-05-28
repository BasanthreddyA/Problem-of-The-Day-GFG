//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template fo
class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        
        Arrays.sort(A);
        Arrays.sort(B);
        int i  =0;
        int j  =0;
        long sa =0;
        long sb =0;
        for(long x : A)sa+=x;
        for(long x : B)sb+=x;
        while(i<n && j<m){
            long a = sa-A[i]+B[j];
            long b = sb-B[j]+A[i];
            if(a == b){
                return 1;
            }
            if(a<b){
                j++;
            }else{
                i++;
            }
        }
        return -1;
    }
}




//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a,n,b,m);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends