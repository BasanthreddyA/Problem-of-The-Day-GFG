//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
                HashMap<String,Integer>map=new HashMap<String,Integer>();

        for(int i=0;i<n;i++)

        {

            if(map.get(arr[i])==null)

            {

                map.put(arr[i],1);

            }

            else{

                map.put(arr[i],map.get(arr[i])+1);

            }

        }

        int max=0;

      String name="";

        for(Map.Entry<String,Integer>s:map.entrySet())

        {

            if(s.getValue()>max)

            {

                max=Math.max(s.getValue(),max);

                name=s.getKey();

            }

            //condition if two names have the same numbers of occuring

            else if(s.getValue()==max)

            {

                if(name.compareTo(s.getKey())>0)

                {

                    name=s.getKey();

                }

                

            }

        }

        String[] ans=new String[2];

        ans[0]=name;

    

        String j=Integer.toString(max);

        ans[1]=j;

        

        return ans;
    }
}

