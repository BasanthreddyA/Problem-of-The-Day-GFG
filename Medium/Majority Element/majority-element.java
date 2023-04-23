//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)

    {

        if(size == 1) return a[0];

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int x:a){

            int f = hm.getOrDefault(x,0);

            hm.put(x,f+1);

            if(hm.get(x) > size/2) return x;

        }

        return -1;  // your code here
    }
}