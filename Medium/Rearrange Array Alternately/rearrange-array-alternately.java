//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
   public static void rearrange(long arr[], int n){
        ArrayList<Long> start = new ArrayList<>();
        ArrayList<Long> middle = new ArrayList<>();
        ArrayList<Long> finalArr = new ArrayList<>();
        if(n % 2 == 0){
            for(int i = 0; i < n/2; i++ ){
                start.add(arr[i]);
            }
            for(int i = n - 1; i >= n/2; i--){
                middle.add(arr[i]);
            }
            for(int i = 0; i < n/2; i++){
                finalArr.add(middle.get(i));
                finalArr.add(start.get(i));
            }
            for(int i = 0; i < n; i++){
                long temp = arr[i];
                arr[i] = finalArr.get(i);
            }
        }
        
        if(n % 2 != 0){
            for(int i = 0; i < (n/2) ; i++){
                start.add(arr[i]);
            }
            for(int i = n - 1; i >= n/2 ; i--){
                middle.add(arr[i]);
            }
            for(int i = 0; i < n/2; i++){
                finalArr.add(middle.get(i));
                finalArr.add(start.get(i));
            }
            finalArr.add(middle.get(middle.size() - 1));
            for(int i = 0; i < n; i++){
                long temp = arr[i];
                arr[i] = finalArr.get(i);
            }
        }
        
    }
}