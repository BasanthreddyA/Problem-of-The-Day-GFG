//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution 

{

    public static boolean allocationPossible(int mid, int [] Arr, int M){

        int student = 1;

        int sum =0;

        for(int i=0; i< Arr.length ; i++){

            if(Arr[i] > mid) return false;

            if(sum + Arr[i] > mid ){

                student++;

                sum = Arr[i];

            }else {

                sum += Arr[i];

            }

        }

        if(student > M) return false;

        return true;

    }

    //Function to find minimum number of pages.

    public static int findPages(int[]A,int N,int M)

    {

        if(N<M) return -1;

        int low = A[0];

        int high = 0;

        for(int i=0; i< N; i++) high += A[i];

        int mid = 0;

        int res = 0;

        while(low <=high){

            mid = (low+high)/2;

            if(allocationPossible(mid, A, M)){

                res = mid;

                high = mid-1;

            } else {

                low = mid+1;

            }

        }

        return res;

    }

 

};

