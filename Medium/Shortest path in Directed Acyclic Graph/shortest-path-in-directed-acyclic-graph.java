//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


class Solution {
    public int[] shortestPath(int N, int M, int[][] edges) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Applying Bellman-Ford algorithm
        for (int i = 0; i < N - 1; i++) {
            for (int[] edge : edges) {
                int src = edge[0];
                int dest = edge[1];
                int weight = edge[2];

                if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                    dist[dest] = dist[src] + weight;
                }
            }
        }

        // Detecting negative cycles (Optional)
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];

            if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                // Negative cycle detected.
                // As per the problem, you can return an empty array or -1 to indicate that there is no valid path.
                return new int[0];
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
