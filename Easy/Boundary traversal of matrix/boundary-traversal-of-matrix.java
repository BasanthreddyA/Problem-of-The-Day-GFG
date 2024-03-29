//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n == 1){            // if single row matrix
            for (int j = 0; j < m; j++)
                res.add(matrix[0][j]);
        } 
        else if(m == 1){        // if single column matrix
            for (int i = 0; i < n; i++) 
                res.add(matrix[i][0]);
        } 
        else{                   
            for (int j = 0; j < m; j++) {     // Traverse top row
                res.add(matrix[0][j]);
            }
            for (int i = 1; i < n; i++) {     // Traverse last column
                res.add(matrix[i][m - 1]);
            }
            // Traverse last row (if there's more than 1 row)
            if (n > 1) {
                for (int j = m - 2; j >= 0; j--) 
                    res.add(matrix[n - 1][j]);
            }
            // Traverse 1st column (if there's more than 1 column)
            if (m > 1) {
                for (int i = n - 2; i >= 1; i--) 
                    res.add(matrix[i][0]);
            }
        }
        return res;
    }
}
