//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends

class Solution{
    public boolean isWordExist(char[][] board, String word){
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    int index=1;
                    Queue<Pair> q=new LinkedList<>();
                    q.offer(new Pair(i,j));
                    boolean[][] visit=new boolean[board.length][board[0].length];
                    visit[i][j]=true;
                    while(!q.isEmpty()){
                        Pair curr=q.poll();
                        if(index==word.length()) return true;
                        for(int i2=0;i2<4;i2++){
                            int newRow=curr.row+dx[i2];
                            int newCol=curr.col+dy[i2];
                            if(newRow>=0 && newCol>=0 && newRow<board.length && newCol<board[0].length && !visit[newRow][newCol] && board[newRow][newCol]==word.charAt(index)){
                                visit[newRow][newCol]=true;
                                q.offer(new Pair(newRow,newCol));
                            }
                        }
                         index++;
                    }
                }
            }
        }
        return false;
    }
    class Pair{
        int row,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
}