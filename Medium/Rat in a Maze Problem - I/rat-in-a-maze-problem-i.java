//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
 public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        helper(m, 0, 0, n, "", list);
        return list;
    }
    
    public static void helper(int[][] m, int r, int c, int n, String path, ArrayList<String> list){
        if(m[r][c] == 0) return;
        if(r==n-1 && c==n-1){
            list.add(path);
            return;
        }
        
        
        m[r][c] = 0;
        
        if(r < n-1) helper(m, r+1, c, n, path+'D', list);
        if(c < n-1) helper(m, r, c+1, n, path+'R', list);
        if(r > 0) helper(m, r-1, c, n, path+'U', list);
        if(c > 0) helper(m, r, c-1, n, path+'L', list);
    
        m[r][c] = 1;
    }
}