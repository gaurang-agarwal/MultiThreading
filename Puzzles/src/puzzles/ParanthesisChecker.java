package puzzles;

import java.util.Scanner;
import java.util.Stack;

public class ParanthesisChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-->0)
		{
			char[] exp = sc.next().toCharArray();
			Stack<Character> st = new Stack<>();
			for(int i=0;i<exp.length;i++)
			{
				if(exp[i]=='{' || exp[i]=='[' || exp[i]=='(')
				{
					st.push(exp[i]);
				}
				else if(exp[i]=='}' || exp[i]==']' || exp[i]==')')
				{
					if(st.isEmpty())
				    {
				        st.push('*');
				        break;
				    }
					char c = st.pop();
					if((c=='{' &&  exp[i]!='}') || (c=='[' &&  exp[i]!=']') || (c=='(' &&  exp[i]!=')'))
					{
						st.push(exp[i]);
						break;
					}
				}
			}
			if(st.isEmpty())
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
