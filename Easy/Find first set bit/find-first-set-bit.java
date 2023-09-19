//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        // Your code here
        for(int i=0;i<n;i++){
            if((n & 1<<i)!=0) return i+1;
        }
        return 0;
            
    }
}

//16 8 4 2 1
// 1 0 0 1 0
// 0 1 1 0 0

