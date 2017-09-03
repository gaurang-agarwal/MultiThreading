package puzzles;

import java.util.Scanner;

public class CheckIfStringIsRotated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- >0)
		{
			String a = sc.next();
			String b = sc.next();
			if((a.substring(2) + a.substring(0, 2)).equals(b))// rotated anti clockwise
					{ 
						System.out.println(1);
					}
			
			else if((a.substring(a.length()-2) + a.substring(0, a.length()-2)).equals(b))// rotated anti clockwise
			{ 
				System.out.println(1);
			}
			else
				System.out.println(0);		
		}
		
		
	}

}
