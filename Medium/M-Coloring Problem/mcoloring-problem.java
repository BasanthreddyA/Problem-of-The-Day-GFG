//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color=new int[n];
        Arrays.fill(color,0);
        
        if(fillColorNode(0,graph,m,n,color))
        return true;
        
        return false;
    }
    
    public boolean fillColorNode(int index,boolean[][] graph,int m,int n,int[] color){
        if(index==n){
            return true;
        }
        
        for(int i=1;i<=m;i++){
            if(isSafe(graph[index],i,color)){
                color[index]=i;
                if(fillColorNode(index+1,graph,m,n,color)){
                     return true;
                }
                color[index]=0;
        }
    }
    return false;
}

        public boolean isSafe(boolean graph[],int i,int[] color){
            for(int j=0;j<graph.length;j++){
                if(graph[j]==true && color[j]==i)
                    return false;
            }
                return true;
            
        }
}