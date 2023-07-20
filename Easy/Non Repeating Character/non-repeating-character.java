//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S) {
        // LinkedHashMap to maintain insertion order and character counts.
        LinkedHashMap<Character, Integer> charCounts = new LinkedHashMap<>();

        // Count character occurrences using LinkedHashMap.
        for (char ch : S.toCharArray()) {
            charCounts.put(ch, charCounts.getOrDefault(ch, 0) + 1);
        }

        // Find the first non-repeating character.
        for (char ch : charCounts.keySet()) {
            if (charCounts.get(ch) == 1) {
                return ch;
            }
        }

        return '$'; // If no non-repeating character found, return '$'.
    }
}
