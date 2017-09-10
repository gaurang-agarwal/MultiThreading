package puzzles;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Given a string, remove duplicates from it. 
 		* Note that original order of characters must be kept same.  
 		* Expected time complexity O(n) where n is length of input string and extra space O(1) under 
 		* the assumption that there are total 256 possible characters in a string.

Input: First line of the input is the number of test cases T. And first line of test case contains a string.
Output:  Modified string without duplicates and same order of characters.
Constraints:  Input String Length <= 1000

 */
public class RemoveDuplicateInString {

	public static void main(String[] args) {

		boolean ar[] = null;
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		 sc.nextLine();
		while(T-->0)
		{
			char input[] = sc.nextLine().toCharArray();
			ar = new boolean[256];
			for(char c:input)
			{
				if(!ar[c])
				{
					ar[c]=true;
					System.out.print(c);
				}
			}
			System.out.println();
			
		}
		
	}

}
