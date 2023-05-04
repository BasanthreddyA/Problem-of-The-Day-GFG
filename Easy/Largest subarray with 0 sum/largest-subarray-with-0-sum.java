//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends

class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int i = -1;
        int maxLength = 0;
        map.put(sum, i);
        while (i<n-1){
            i++;
            sum += arr[i];
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }else {
                int length = i - map.get(sum);
                if (length > maxLength){
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }
}