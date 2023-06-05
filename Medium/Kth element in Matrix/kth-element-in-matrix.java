//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		}
	}
}

// } Driver Code Ends

class Solution {
    public static int kthSmallest(int[][] mat, int n, int k) {
        int left = mat[0][0];
        int right = mat[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countSmallerOrEqual(mat, n, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int countSmallerOrEqual(int[][] mat, int n, int target) {
        int count = 0;
        int j = n - 1;

        for (int i = 0; i < n; i++) {
            while (j >= 0 && mat[i][j] > target) {
                j--;
            }
            count += j + 1;
        }

        return count;
    }
}
