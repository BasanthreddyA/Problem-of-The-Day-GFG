//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
private boolean good(int x, int[] sweetness, int n, int k) {
     int s = 0, cnt = 0;
     for (int i = 0; i < n; i++) {
         s += sweetness[i];
         if (s >= x) {
             s = 0;
             cnt++;
         }
     }
     return cnt >= k + 1;
    }
	int maxSweetness(int [] sweetness, int N, int K) {
	    int low = 0, high = 1000000000, ans = -1;
	    
    while (low <= high) {
        int mid = (low + high) / 2;
        if (good(mid, sweetness,N,K)) {
            low = mid + 1;
            ans = mid;
        } else {
            high = mid - 1;
        }
    }

    return ans;
	}
}