//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long margeSort(long[] a, int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += margeSort(a, low, mid);
            count += margeSort(a, mid + 1, high);
            count += marge(a, low, mid, high);
        }
        return count;
    }

    static long marge(long[] a, int low, int mid, int high) {
        int n = mid - low + 1;
        int m = high - mid;
        long[] left = new long[n];
        long[] right = new long[m];
        for (int i = 0; i < n; i++)
            left[i] = a[low + i];
        for (int j = 0; j < m; j++)
            right[j] = a[mid + 1 + j];
        int i = 0, j = 0, k = low;
        long count = 0;
        while (i < n && j < m) {
            if (left[i] <= right[j])
                a[low++] = left[i++];
            else {
                a[low++] = right[j++];
                count += n - i;
            }
        }
        while (i < n)
            a[low++] = left[i++];
        while (j < m)
            a[low++] = right[j++];
        return count;

    }

    static long inversionCount(long arr[], long N) {
        int low = 0, high = (int) (N - 1);
        return margeSort(arr, low, high);
    }
}