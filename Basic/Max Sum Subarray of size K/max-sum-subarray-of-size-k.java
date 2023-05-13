//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
 
        int ws=0;
        long sum=0;
        long max=Long.MIN_VALUE;
        for(int we=0;we<N;we++){
            sum += Arr.get(we);
            max=Math.max(max,sum);
            if(we-ws+1 >= K){
                if(we-ws+1 == K) max=Math.max(max,sum);
                sum -= Arr.get(ws);
                ws++;
            }
        }
        return max;
    }
}