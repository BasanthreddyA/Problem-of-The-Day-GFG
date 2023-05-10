//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return new Solution().checkLargestBst(root).size;
    }
    
    private Info checkLargestBst(Node node) {
        if (node == null) {
            Info info = new Info();
            info.minValue = Integer.MAX_VALUE;
            info.maxValue = Integer.MIN_VALUE;
            info.size = 0;
            info.isBst = true;
            return info;
        }
        Info left = checkLargestBst(node.left);
        Info right = checkLargestBst(node.right);
        Info result = new Info();
        if (left.isBst && right.isBst && node.data > left.maxValue && node.data < right.minValue) {
            result.size = 1 + left.size + right.size;
            result.isBst = true;
        } else {
            result.size = Math.max(left.size, right.size);
            result.isBst = false;
        }
        result.minValue = Math.min(node.data, Math.min(left.minValue, right.minValue));
        result.maxValue = Math.max(node.data, Math.max(left.maxValue, right.maxValue));
        return result;
    }
    
}

class Info {
    int minValue;
    int maxValue;
    int size;
    boolean isBst;
}