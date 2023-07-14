//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        Stack<Integer> st = new Stack<>(); // creating another stack
        int mid = (sizeOfStack-1)/2; // finding mid as we need 0-based indexing
        for(int i = sizeOfStack-1; i>mid ; i--){
            st.push(s.pop()); // removing element from the main stack and adding it to another stack till we are just above mid
        }
        
        s.pop(); // mid removed
        while(!st.isEmpty()){
            s.push(st.pop()); //pushing all the elements from second stack to main stack.
        }
        // code here
    }
}