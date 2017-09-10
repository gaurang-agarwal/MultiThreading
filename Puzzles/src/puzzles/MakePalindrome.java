package puzzles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakePalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0)
		{
			String s = sc.next();
			Map<Character, Integer> charCount= new HashMap<>();
			for(char c : s.toCharArray())
			{
				if(charCount.containsKey(c))
				{
					int count = charCount.get(c);
					count++;
					charCount.put(c, count);
				}
				else
				{
					charCount.put(c, 1);
				}
			}
			
			int oddCharCounts =0;
			for(int count : charCount.values())
			{
				if(count%2==1)
					oddCharCounts++;
			}
			if(oddCharCounts==0)
				System.out.println(0);
			else
				System.out.println(oddCharCounts-1);
		}
		
		
	}

}
