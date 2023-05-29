//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String pattern){
        //code here
        ArrayList<String>ans=new ArrayList<>();
        for(int i=0;i<Dictionary.length;i++){
            String str=Dictionary[i];
            int k=0;
            for(int j=0;j<str.length();j++){
                if(Character.isUpperCase(str.charAt(j))){
                    if(k<pattern.length()&&str.charAt(j)==pattern.charAt(k)){
                        k++;
                    }
                    else{
                        break;
                    }
                }
            }
            if(k==pattern.length()){
                ans.add(str);
            }
        }
        if(ans.size()==0){
            ans.add("-1");
            return ans;
        }
        Collections.sort(ans);
        return ans;
    }
}