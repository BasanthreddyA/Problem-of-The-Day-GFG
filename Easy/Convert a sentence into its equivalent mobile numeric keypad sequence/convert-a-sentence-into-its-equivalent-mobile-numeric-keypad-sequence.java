//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} 
// } Driver Code Ends

class Solution 
{ 
    String printSequence(String S) 
    { 
        // code here
        char []x= S.toCharArray();
        String z="";
        for(int i=0;i<x.length;i++) {
            if(x[i]=='A') {
                z=z+"2";
            }
            else if(x[i]=='B') {
                z=z+"22";
            }
            else if(x[i]=='C') {
                z=z+"222";
            }
            else if(x[i]=='D') {
                z=z+"3";
            }
            else if(x[i]=='E') {
                z=z+"33";
            }
            else if(x[i]=='F') {
                z=z+"333";
            }
            else if(x[i]=='G') {
                z=z+"4";
            }
            else if(x[i]=='H') {
                z=z+"44";
            }
            else if(x[i]=='I') {
                z=z+"444";
            }
            else if(x[i]=='J') {
                z=z+"5";
            }
            else if(x[i]=='K') {
                z=z+"55";
            }
            else if(x[i]=='L') {
                z=z+"555";
            }
            else if(x[i]=='M') {
                z=z+"6";
            }
            else if(x[i]=='N') {
                z=z+"66";
            }
            else if(x[i]=='O') {
                z=z+"666";
            }
            else if(x[i]=='P') {
                z=z+"7";
            }
            else if(x[i]=='Q') {
                z=z+"77";
            }
            else if(x[i]=='R') {
                z=z+"777";
            }
            else if(x[i]=='S') {
                z=z+"7777";
            }
            else if(x[i]=='T') {
                z=z+"8";
            }
            else if(x[i]=='U') {
                z=z+"88";
            }
            else if(x[i]=='V') {
                z=z+"888";
            }
            else if(x[i]=='W') {
                z=z+"9";
            }
            else if(x[i]=='X') {
                z=z+"99";
            }
            else if(x[i]=='Y') {
                z=z+"999";
            }
            else if(x[i]=='Z') {
                z=z+"9999";
            }
            else if(x[i]==' ') {
                z=z+"0";
            }
            
        }
        return z; 
    }
}