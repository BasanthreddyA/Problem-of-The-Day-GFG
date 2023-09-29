//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    void dfs(int r, int c, int[][] grid, int[][] vis, int n, int m) {
        vis[r][c] = 1;
        int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
        
        for(int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && vis[nx][ny] == 0 && grid[nx][ny] == 1)
                dfs(nx, ny, grid, vis, n, m);
        }
    }

    int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][] = new int[n][m];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) 
                if(grid[i][j] == 1 && vis[i][j] == 0 && (i == 0 || i == n - 1 || j == 0 || j == m - 1))
                    dfs(i, j, grid, vis, n, m);
        
        int count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) 
                if(grid[i][j] == 1 && vis[i][j] == 0)
                    count++;

        return count;
    }
}