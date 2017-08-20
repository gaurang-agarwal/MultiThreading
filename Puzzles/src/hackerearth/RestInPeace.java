package hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported 
https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/rest-in-peace-21-1/
*/
	
import java.util.*;


public class RestInPeace {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        boolean result [] = new boolean[N];
        for (int i = 0; i < N; i++) {
             long number = s.nextLong();
            result[i]=(number%21 == 0) || String.valueOf(number).contains("21");
        }
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < N; i++) {
        if(result[i])
        {
            System.out.println("The streak lives still in our heart!");
        }
            else
            {
             System.out.println("The streak lives still in our heart!");   
            }
        }
        
    }
}

