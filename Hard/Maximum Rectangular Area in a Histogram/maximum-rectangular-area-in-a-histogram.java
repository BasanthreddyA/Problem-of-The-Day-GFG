//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends

class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        
        if(n==1)
        return hist[0];
        
       
        
        //rigthBoundary
        
        int rb[]=new int[hist.length];
        Stack<Integer>st=new Stack<>();
        st.push(hist.length-1);
        rb[hist.length-1]=hist.length;
        
        for(int i=hist.length-2;i>=0;i--)
        {
            while(st.size()>0&&hist[i]<=hist[st.peek()])
            st.pop();
            
            if(st.size()==0)
            rb[i]=hist.length;
            
            else
            rb[i]=st.peek();
            
            st.push(i);
        }
        
        
        //leftBoundary
        
        int lb[]=new int[hist.length];
         st = new Stack<>();
        st.push(0);
        lb[0]=-1;
        
        for(int i=1;i<hist.length;i++)
        {
            while(st.size()>0&&hist[i]<=hist[st.peek()])
            st.pop();
            
            if(st.size()==0)
            lb[i]=-1;
            
            else
            lb[i]=st.peek();
            
            st.push(i);
        }
        
        //calculate Largest Area
        
        long maxArea=0;
        
        for(int i=0;i<hist.length;i++)
        {
            long w=rb[i]-lb[i]-1;
            long area=hist[i]*w;
            
            if(maxArea<area)
            maxArea=area;
        }
        return maxArea;
        
        
        
    }
        
}