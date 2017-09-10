package puzzles;

import java.util.HashMap;
import java.util.Map;
//http://practice.geeksforgeeks.org/problems/roman-number-to-integer/0
public class RomanToInteger {

	static Map<String,Integer> table = new HashMap<>();
	static {
		table.put("I", 1);
		table.put("V", 5);
		table.put("X", 10);
		table.put("L", 50);
		table.put("C", 100);
		table.put("D", 500);
		table.put("M", 1000);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String num=	"MMX";
	int sum=0;
	for(int i=0;i<num.length();i++)
	{
		int s1 = table.get(num.charAt(i)+"");
		if((i+1) < num.length())
		{
			int s2=table.get(num.charAt(i+1)+"");
			if(s1>=s2)
			{
				sum=sum+s1;
			}
			else
			{
				sum=sum+s2-s1;
				i++;
			}
		}
		else
		{
			sum=sum+s1;
		}
	}
	System.out.println(sum);
		
	}

}
