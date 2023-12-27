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
        // // Your code here
        // int sum=0,maxLen=0;
        // for(int i=0;i<n;i++){
        //     sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=arr[j];
                
        //       if(sum==0){
        //       maxLen=Math.max((j-i+1),maxLen);
        //       }
        //     }
        // }
        // return maxLen;
        
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,count=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            
            if(sum==0){
                count=i+1;
            }else{
                
                if(map.get(sum)!=null){
                    count=Math.max(count,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }
        }
        
        return count;
    }
}