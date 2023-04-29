//{ Driver Code Starts
import java.util.Arrays;
import java.util.Scanner;
class FindFourElements
{
	
    public static void main(String[] args) 
    {
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			FindFourElements findfour = new FindFourElements();
			int n=sc.nextInt();
			int[] A=new int[n];
			for(int i=0;i<n;i++)
				A[i]=sc.nextInt();
			int X =sc.nextInt();
			
			Compute ob = new Compute();
		    System.out.println(ob.find4Numbers(A, n, X)?1:0);
		}
    }
}


// } Driver Code Ends

class Compute
{
    boolean find4Numbers(int A[], int n, int X) 
    {
        int l, r;
        Arrays.sort(A);
		boolean flag=false;
        for (int i = 0; i < n - 3; i++) 
        {
            for (int j = i + 1; j < n - 2; j++) 
            {
                l = j + 1;
                r = n - 1;
                while (l < r) 
                {
                    if (A[i] + A[j] + A[l] + A[r] == X) 
                    {
						flag=true;
                        l++;
                        r--;
                    } 
                    else if (A[i] + A[j] + A[l] + A[r] < X)
                        l++;
                    else
                        r--;
                }
            }
        }
        return flag;
	}
}