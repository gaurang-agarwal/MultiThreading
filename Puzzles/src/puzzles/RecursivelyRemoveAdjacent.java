package puzzles;

import java.util.Scanner;
//http://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
public class RecursivelyRemoveAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- >0)
		{
			System.out.println(removeAdjacent(sc.next()));	
		}
		
		
	}

	
	
	private static String removeAdjacent(String s)
	{
		if(s.length()==0 || s.length()==1)
			return s;
		int i=0;
		StringBuilder result = new StringBuilder();
		boolean duplicatePresent = false;
		while(i<s.length()-1)
		{
			if(s.charAt(i)==s.charAt(i+1))
			{	
				while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1))
					i++;
				duplicatePresent=true;
			}
			else
			{
				result.append(s.charAt(i));
			}
			i++;
		}
		if(i<s.length() && s.charAt(i)!=s.charAt(i-1))
			result.append(s.charAt(i));
		else
			duplicatePresent=true;
		
		if(duplicatePresent)
			return removeAdjacent(result.toString());
	
		return result.toString();
	}
	
}
