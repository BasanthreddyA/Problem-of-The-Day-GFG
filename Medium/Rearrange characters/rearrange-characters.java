//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends

class Solution
{
	public static String rearrangeCharacters(String str) {
	    HashMap<Character, Integer> mp = new HashMap<>();
	    char max_char = str.charAt(0);
	    int n = str.length();
	    for(int i = 0;i<n;i++){
	        char c = str.charAt(i);
	        mp.put(c,mp.getOrDefault(c,0)+1);
	        if(mp.get(c)>=mp.get(max_char)){
	            max_char = c;
	        }
	    }
	    
	    if(mp.get(max_char)>(n+1)/2) return "-1";
	    int idx = 0;
	    char[] ans = new char[n];
	    while(mp.get(max_char)>0){
	        ans[idx] = max_char;
	        mp.put(max_char,mp.get(max_char)-1);
	        idx+=2;
	    }
	    for(char c:mp.keySet()){
	        int cnt = mp.get(c);
	        while(cnt>0){
	            idx = idx>=n?1:idx;
	            ans[idx] = c;
	            idx+=2;
	            cnt--;
	        }
	    }
	    return String.valueOf(ans);
	}
}