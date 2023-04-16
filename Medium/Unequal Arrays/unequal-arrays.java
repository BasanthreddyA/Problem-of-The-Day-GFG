//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long solve(int N, int[] A, int[] B) {
        List<Integer> odda=new ArrayList<>();
        List<Integer> oddb=new ArrayList<>();
        List<Integer> evena=new ArrayList<>();
        List<Integer> evenb=new ArrayList<>();
        
        long a=0,b=0;
        for(int i=0;i<N;i++){
            a+=A[i];
            b+=B[i];
            
            if(A[i]%2==0) evena.add(A[i]);
            else odda.add(A[i]);
            
            if(B[i]%2==0) evenb.add(B[i]);
            else oddb.add(B[i]);
        }
        long sum=0;
        
        if(a!=b || odda.size()!=oddb.size()) return -1;
        
        Collections.sort(odda);
        Collections.sort(oddb);
        Collections.sort(evena);
        Collections.sort(evenb);
        
        
        for(int i=0;i<odda.size();i++)
        sum+=(Math.abs(odda.get(i)-oddb.get(i)))/2;
        
        for(int i=0;i<evena.size();i++)
            sum+=(Math.abs(evena.get(i)-evenb.get(i)))/2;
            
            
            return sum/2;

    }
}
        
