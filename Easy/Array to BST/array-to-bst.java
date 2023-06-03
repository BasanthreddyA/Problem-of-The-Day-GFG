//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Solution
{
    int i=0;
    public void preorder(Node node,int[] arr){
       
        if(node==null)return;
        arr[i++]=node.data;
        preorder(node.left,arr);
        preorder(node.right,arr);
       
    }
    public Node helper(int[] arr,int start,int end){
        if(start>end)return null;
        int mid=start+(end-start)/2;
        Node node=new Node(arr[mid]);
        node.left=helper(arr,start,mid-1);
        node.right=helper(arr,mid+1,end);
        return node;
    }
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
         ArrayList<Integer>list=new ArrayList<>();
         int n=nums.length;
         Node root=helper(nums,0,n-1);
        int[] ans=new int[n];
        preorder(root,ans);
        return ans;
        
    }
}