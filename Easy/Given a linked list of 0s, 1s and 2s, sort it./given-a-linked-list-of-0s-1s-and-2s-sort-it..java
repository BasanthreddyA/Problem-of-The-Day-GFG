//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends

class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node zero=new Node(0);
        Node cz=zero;
        Node one=new Node(0);
         Node co=one;
        Node two=new Node(0);
         Node ct=two;
        while(head!=null){
            if(head.data==0){
                Node nn=new Node(head.data);
                cz.next=nn;
                cz=cz.next;
                
            }
            else if(head.data==1){
                 Node nn=new Node(head.data);
                co.next=nn;
                co=co.next;
                
            }
            else{
                 Node nn=new Node(head.data);
                ct.next=nn;
                ct=ct.next;
                
            }
            head=head.next;
        }
        co.next=two.next;
        cz.next=one.next;
        return zero.next;
    }
}