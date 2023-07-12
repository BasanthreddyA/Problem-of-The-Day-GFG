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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.isFrequencyUnique(n, arr);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        //sort Array
        Arrays.sort(arr);
        int count=1;
        if(n==1)return true;
        //make a arraylist show that we add number of type occur element
        ArrayList<Integer> arrl=new ArrayList<>();
        //count the occurence
        for(int i=1;i<n;i++){
            if(arr[i-1]==arr[i])count++;
            else{
                arrl.add(count);
                count=1;
            }
        }
      arrl.add(count);
    Integer[] arr2 = new Integer[arrl.size()];
    //convert arraylist to array
        arr2 = arrl.toArray(arr2);
        //to check all occurance are defferent
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr2.length;i++)set.add(arr2[i]);
     if(set.size()==arr2.length) return true;
        return false;
    }
}