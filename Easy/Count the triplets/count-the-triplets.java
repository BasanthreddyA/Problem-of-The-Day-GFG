//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countTriplet(int a[], int n) {
       Arrays.sort(a);
       int count=0;
        for(int k=n-1;k>0;k--){
            int i=0,j=k-1;
        
        while(j>i){
            
            if(a[i]+a[j]==a[k]){ //Checing the condition is equals or not
                count++;
            }
            
            if(a[i]+a[j]>a[k]){ //decrement when it becomes more than k value
                j--;
            }else{
                i++; //it increase the when the value is less than it
            }
        }
    }
    return count;
    }
}