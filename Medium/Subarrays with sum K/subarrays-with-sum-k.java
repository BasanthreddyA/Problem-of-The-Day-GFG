//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        // int count=0,res=0;
        // for(int i=0;i<N;i++){
        //     count=0;
        //     for(int j=i;j<N;j++){
        //         count+=Arr[j];
                
        //         res+=(count==k) ? 1 : 0;
        //     }
        // }
        // return res;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,res=0,val=0;
        map.put(0,1);
        for(int i=0;i<N;i++){
            sum+=Arr[i];
            
            int rem=sum-k;
            if(map.containsKey(rem)){
                val+=map.get(rem);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        return val;
    }
}