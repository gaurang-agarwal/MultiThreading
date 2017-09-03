package puzzles;

import java.util.Scanner;

public class BrowserRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            String wb = s.next();
            String shortString = wb.substring(4);
            shortString=  shortString.substring(0, shortString.length()-4).replaceAll("a|e|i|o|u", "");
            System.out.println((shortString.length()+4) +"/"+wb.length());
        }
        

        
    
	}

}
