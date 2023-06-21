//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<N;i++)
            if(bills[i] == 5)
                l.add(5);
            else if(bills[i] == 10)
                if(l.indexOf(5) != -1){
                    l.remove(l.indexOf(5));
                    l.add(10);
                }
                else
                    return false;
            else if(bills[i] == 20){
                if(l.indexOf(5) != -1){
                    l.remove(l.indexOf(5));
                    if(l.indexOf(10) != -1)
                        l.remove(l.indexOf(10));
                    else if(l.indexOf(5) != -1){
                        l.remove(l.indexOf(5));
                        if(l.indexOf(5) != -1)
                            l.remove(l.indexOf(5));
                        else
                            return false;
                    }
                    else
                        return false;
                }
                else
                    return false;
                l.add(20);
            }
        return true;
    }
}