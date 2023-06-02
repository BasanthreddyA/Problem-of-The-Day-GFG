//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends


class DisjointSet {
    int[] size;
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findUPar(int node) {
        if (parent[node] == node) {
            return node;
        }
        int ultimateParent = findUPar(parent[node]);
        parent[node] = ultimateParent; // Path compression
        return ultimateParent;
    }

    public void UnionByRank(int u, int v) {
        int ultimateParentV = findUPar(v);
        int ultimateParentU = findUPar(u);
        if (ultimateParentV == ultimateParentU) {
            return;
        }
        if (rank[ultimateParentU] > rank[ultimateParentV]) {
            parent[ultimateParentV] = ultimateParentU;
        } else if (rank[ultimateParentU] < rank[ultimateParentV]) {
            parent[ultimateParentU] = ultimateParentV;
        } else {
            parent[ultimateParentV] = ultimateParentU;
            rank[ultimateParentU]++;
        }
    }

    public void UnionBySize(int u, int v) {
        int ultimateParentU = findUPar(u);
        int ultimateParentV = findUPar(v);
        if (ultimateParentV == ultimateParentU) {
            return;
        }
        if (size[ultimateParentV] > size[ultimateParentU]) {
            parent[ultimateParentU] = ultimateParentV;
            size[ultimateParentV] += size[ultimateParentU];
        } else {
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU] += size[ultimateParentV];
        }
    }
}

class Complete {
    static int MAX_SIZE = 1299722;
    // To store all prime numbers
    static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static void precompute() {
        // Sieve of Eratosthenes to find prime numbers
        boolean[] isPrime = new boolean[MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; i++)
            isPrime[i] = true;

        for (int p = 2; p * p < MAX_SIZE; p++) {
            if (isPrime[p] == true) {
                for (int i = p * p; i < MAX_SIZE; i += p)
                    isPrime[i] = false;
            }
        }

        // Store all prime numbers
        for (int p = 2; p < MAX_SIZE; p++)
            if (isPrime[p])
                primes.add(p);
    }

    // Function for finding maximum and value pair
    public static int helpSanta(int n, int m, int[][] g) {
        if (m == 0) {
            return -1;
        }
        DisjointSet dis = new DisjointSet(n);
        for (int i = 0; i < m; i++) {
            dis.UnionBySize(g[i][0], g[i][1]);
        }
        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (dis.findUPar(i) == i) {
                max = Math.max(max, dis.size[i]);
            }
        }
        return primes.get(max - 1);
    }
}
