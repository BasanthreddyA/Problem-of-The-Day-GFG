//{ Driver Code Starts
import java.util.*;

class TwoStack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		while(T>0)
		{
			twoStacks g = new twoStacks();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int stack_no = sc.nextInt();
				int QueryType = sc.nextInt();
				
				
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					if(stack_no == 1)
					 g.push1(a);
					else if(stack_no ==2)
					 g.push2(a);
				}else if(QueryType == 2)
				{
					if(stack_no==1)
					System.out.print(g.pop1()+" ");
					else if(stack_no==2)
					System.out.print(g.pop2()+" ");
				}
			
				Q--;
			}
				System.out.println();
		  T--;
		}
	}
}


// } Driver Code Ends


class twoStacks
{
    int stack[] = new int[100];
    int top1 = 0, top2 = 50;
    //Function to push an integer into the stack1.
    void push1(int x)
    {
        stack[top1] = x; top1++;
    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
       stack[top2] = x; top2++;
    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
        if(top1 == 0){
            return -1;
        }
        int ans = stack[top1 - 1]; top1--;
        return ans;
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        if(top2 == 50){
            return -1;
        }
        int ans = stack[top2 - 1]; top2--;
        return ans;
    }
}