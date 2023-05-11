//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    static boolean ispar(String x)
    {
        Stack<Character> stack = new Stack<Character>();
        
        for(char ch : x.toCharArray())
        {
            if(stack.isEmpty() || ch == '{' || ch == '(' || ch == '[')
            {
                stack.push(ch);
            }
            else
            {
                if((ch == '}' && stack.peek() == '{') || 
                    (ch == ')' && stack.peek() == '(') ||
                    (ch == ']' && stack.peek() == '['))
                    {
                        stack.pop();
                    }
                else return false;
            }
        }
        
        return stack.isEmpty();
    }
}
