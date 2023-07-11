//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends

class Solution
{
    /*You are required to complete this method*/
    int findK(int matrix[][], int n, int m, int k)
    {
        ArrayList<Integer> al = new ArrayList<>();
        int t = 0;
        int b = n-1;
        int l = 0;
        int ri = m-1;
        while(l <= ri && t <= b){
            for(int i=l;i<=ri;i++){
                al.add(matrix[t][i]);
            }
            t++;
            
            if(t > b)
            break;
            
            for(int i=t;i<=b;i++){
                al.add(matrix[i][ri]);
            }
            ri--;
            
            if(ri < l)
            break;
            
            for(int i=ri;i>=l;i--){
                al.add(matrix[b][i]);
            }
            b--;
            
            if(b < t)
            break;
            
            for(int i=b;i>=t;i--){
                al.add(matrix[i][l]);
            }
            l++;
        }
        return al.get(k-1);
// Your code here
    }
}