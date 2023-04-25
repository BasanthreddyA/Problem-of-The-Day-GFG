//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends


class Pair{
    int first;
    int second;
    Pair(int _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}
class Solution
{
    
    public static int[] calculateSpan(int price[], int n)
    {
        
    Stack<Pair> stk = new Stack<>();

    int[] ans = new int[n];

    for(int i=0;i<n;i++){

    if(stk.empty()) ans[i] = -1;

    else if(!stk.empty() && stk.peek().first > price[i]) ans[i] = stk.peek().second;

    else if(!stk.empty() && stk.peek().first <= price[i]){
        while(!stk.empty() && stk.peek().first <= price[i]) stk.pop();
        if(stk.empty()) ans[i] = -1;
        else ans[i] = stk.peek().second;
    }

    stk.push(new Pair(price[i],i));
}

    for(int i=0;i<n;i++) {
        ans[i] = (i -ans[i]);
        }
        
return ans;
        
    }
    
}