//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minDifference(int arr[], int n) { 
        int sum =0;
        for(int i=0;i<n;i++){
            sum +=arr[i];
        }
        boolean prev [] = new boolean[sum+1];
        prev[0] = true;
        for(int i=1;i<n+1;i++){
            boolean cur[] = new boolean[sum+1];
            cur[0] = true;
            for(int j=1;j<sum+1;j++){
                // take
                boolean take = false;
                if(j>=arr[i-1]){
                    take = prev[j-arr[i-1]];
                }
                // not take
                boolean ntake = prev[j];
                cur[j] = take||ntake;
            }
            prev=cur;
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<prev.length;i++){
            if(prev[i]){
                a.add(i);
            }
        }
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<=a.size()/2;i++){
            // (sum-a.get(i))-a.get(i)) = sum - 2*a.get(i)
            diff = Math.min(diff,Math.abs(sum-2*a.get(i)));
        }
        return diff;
    } 
}
