//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    List<Integer> am(List<Integer> list1,int n,int s){
         list1.add(n);
        if(n==list1.get(0)) return list1;
       
        if(n<=0) s=1;
        if(s==1) return am(list1,n+5,1);
        else return am(list1,n-5,0);
    }
    public List<Integer> pattern(int N){
        List<Integer> lists=new ArrayList<>();
        lists.add(N);
        if(N<=0) return lists;
        return am(lists,N-5,0);
    }
}