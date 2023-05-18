//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends

class Solution
{
    int row;
    int col;
    boolean locked;
    public int closedIslands(int[][] matrix, int N, int M)
    {
        this.row=N;
        this.col=M;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==1){
                    locked=false;
                    dfs(matrix,i,j);
                    if(!locked) count++;
                }
            }
        }
        return count;
    }
    
    void dfs(int [][]matrix,int i,int j){
        if(i<0 || i==row || j<0 || j==col || matrix[i][j]<=0) return;
        if(i==0 || i==row-1 || j==0 || j==col-1) locked=true;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        matrix[i][j]=-1;
        for(int index=0;index<4;index++)
            dfs(matrix,i+dx[index],j+dy[index]);
    }
}