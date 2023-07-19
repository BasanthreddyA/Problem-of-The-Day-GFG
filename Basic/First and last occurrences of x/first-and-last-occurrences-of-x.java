//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java
class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        int low = 0;
        int high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int l = 0;
        int h = n - 1;
        int second = -1;

        while (l <= h) {
            int m = l + ((h - l) >> 1);

            if (arr[m] == x) {
                second = m;
                l = m + 1;
            } else if (arr[m] < x) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        ArrayList<Long> ll = new ArrayList<>();
        ll.add((long)first);
        ll.add((long)second);

        return ll;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends