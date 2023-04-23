//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
     public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
       
       int n =arr.length;
       ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
       if(arr ==null && n==0) return ans;
       Arrays.sort(arr);
       for(int i=0;i<n;i++)
       {
           for(int j=i+1;j<n;j++)
           {
               int l=j+1;
               int h=n-1;
               int t=k-(arr[i]+arr[j]);
               while(l<h)
               {
                   int two_sum=arr[l]+arr[h];
                   if(two_sum ==t)
                   {
                       ArrayList<Integer> al = new ArrayList<>();
                       al.add(arr[i]);
                       al.add(arr[j]);
                       al.add(arr[l]);
                       al.add(arr[h]);
                       ans.add(al);
                       while(l<h && arr[l]==arr[l+1]) 
                       {
                           l++;
                       }
                       while(l<h && arr[h]==arr[h-1])
                       {
                           h--;
                       }
                    l++;
                    h--;   
                   }
                   else
                   {
                       if(two_sum<t) l++;
                       else h--;
                   }
               }
                while(j+1<n && arr[j]==arr[j+1]) ++j;
           }
           while(i+1<n && arr[i]==arr[i+1]) ++i;
       }
       return ans;

    }
}
