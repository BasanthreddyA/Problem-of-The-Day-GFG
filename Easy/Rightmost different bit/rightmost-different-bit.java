//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		
		//input number of testcases
		int t=sc.nextInt();
		int m,n;
		while(t-->0) {
		    
		    
            Solution obj = new Solution();
            //input m and n
		    m = sc.nextInt();
		    n = sc.nextInt();
		    System.out.println(obj.posOfRightMostDiffBit(m, n));
		}
	}
}




// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int posOfRightMostDiffBit(int m, int n) {
        if(m == n) return -1;
        int count =  0;    
        while(m > 0 || n>0){
            count++;
             if(m%2 != n%2){
                 break;
             }
             m /=2;
             n /=2;
        }     
         return count;   
    }
}
 


