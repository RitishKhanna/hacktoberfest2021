
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    String exp=sc.next();
		    if((exp.length())%2!=0)
		    {
		        System.out.println("not balanced");
		        continue;
		    }
		    Stack<Character> s = new Stack<Character>();
		    int i=0,x=0;
		    while(i<exp.length())
		    {
		        char a=exp.charAt(i);
		        if(exp.charAt(i)=='(' || exp.charAt(i)=='[' || exp.charAt(i)=='{' )
		        {
		            s.push(exp.charAt(i));
		        }
		        else 
		        {
		            if(!s.empty())
		            {
		                char c=s.peek();
		                if((a==')' && c=='(') || (a==']' && c=='[') || (a=='}' && c=='{'))
		                {
		                    s.pop();
		                }
		                else
		                {
		                    x=1;
		                    break;
		                }
		           }//if
		          else
		            {
		                x=1;
		                break;
		            }
		        }//else
            i++;
		    }
		        if(s.empty() && x==0)
		        {
		            System.out.println("balanced");
		        }
		        else
		        {
		            System.out.println("not balanced");
		        }
		}
	}
}

