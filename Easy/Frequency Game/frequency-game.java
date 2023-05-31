//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        // Iterating over testcases
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int arr[] = new int[n];

            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Helper class to find largest number with minimum frequency
class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {

    HashMap<Integer, Integer> frequencyMap = new HashMap<>();

    // Calculate the frequency of each element in the array
    for (int i = 0; i < n; i++) {
        int key = arr[i];
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
    }

    int minFrequency = Integer.MAX_VALUE;
    int result = -1;

    // Find the element with the minimum frequency
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        int key = entry.getKey();
        int frequency = entry.getValue();

        // If the current frequency is lower than the minimum frequency, update the result
        if (frequency < minFrequency) {
            minFrequency = frequency;
            result = key;
        }
        // If the current frequency is equal to the minimum frequency, compare the keys and update if necessary
        else if (frequency == minFrequency && key > result) {
            result = key;
        }
    }

    return result;
}

        
    }