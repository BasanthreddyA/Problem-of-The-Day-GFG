//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


class Solution{
    int atoi(String str) {
	    int val=0;
	    int base=1;
	    boolean neg=false;
	    if(str.charAt(0)=='-'){
	        str=str.substring(1);
	        neg=true;
	    }
	    while(str.length()!=0){
	        Character last=str.charAt(str.length()-1);
	        if(last<'0' || last>'9') return -1;
	        val+=base*(last-'0');
	        base*=10;
	        str=str.substring(0,str.length()-1);
	    }
	    return neg==true?-val:val;
    }
}