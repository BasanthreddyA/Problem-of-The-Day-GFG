Apporach>>>
Sure! Here's the approach of the `maximumSumSubarray` function in a simplified and easy-to-understand way:

1. Initialize `ws` (window start) to 0, `sum` to 0, and `max` to the minimum value of `Long`.
2. Iterate over the elements of the array from index 0 to `N-1`. The iterator variable is `we` (window end).
3. Add the element at index `we` to the current sum.
4. Update `max` to the larger value between `max` and the current sum.
5. Check if the window size (`we - ws + 1`) is greater than or equal to `K` (the desired subarray length).
   - If the window size is equal to `K`, update `max` to the larger value between `max` and the current sum.
   - If the window size is greater than `K`, it means we need to slide the window.
     - Subtract the element at index `ws` from the sum to remove it from the current window.
     - Increment `ws` to slide the window to the right.
6. Repeat steps 3 to 5 until we reach the end of the array.
7. Return `max`, which represents the maximum sum of a subarray of length `K` within the given array.

By following this approach, we maintain a sliding window of size `K` and keep track of the maximum sum encountered. The window slides through the array, updating the sum and maximum sum as necessary, to find the maximum sum subarray.


*/










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
