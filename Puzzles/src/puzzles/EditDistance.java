package puzzles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//http://practice.geeksforgeeks.org/problems/edit-distance/0
/*
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert 'str1' into 'str2'.

    Insert
    Remove
    Replace

All of the above operations are of cost=1.
Both the strings are of lowercase.

Input:
The First line of the input contains an integer T denoting the number of test cases. Then T test cases follow. Each tese case consists of two lines. The first line of each test case consists of two space separated integers P and Q denoting the length of the strings str1 and str2 respectively. The second line of each test case coantains two space separated strings str1 and str2 in order.


Output:
Coreesponding to each test case, pirnt in a new line, the minimum number of operations required.

Constraints:
1<=T<=50
1<= Length(str1) <= 100
1<= Length(str2) <= 100
 */
public class EditDistance { 
	
	static int min(int x,int y,int z)
{
	if (x < y && x <z) return x;
	if (y < x && y < z) return y;
	else return z;
}

static int editDistDP(String str1, String str2, int m, int n)
{
	// Create a table to store results of subproblems
	int dp[][] = new int[m+1][n+1];

	// Fill d[][] in bottom up manner
	for (int i=0; i<=m; i++)
	{
		for (int j=0; j<=n; j++)
		{
			// If first string is empty, only option is to
			// isnert all characters of second string
			if (i==0)
				dp[i][j] = j;  // Min. operations = j

			// If second string is empty, only option is to
			// remove all characters of second string
			else if (j==0)
				dp[i][j] = i; // Min. operations = i

			// If last characters are same, ignore last char
			// and recur for remaining string
			else if (str1.charAt(i-1) == str2.charAt(j-1))
				dp[i][j] = dp[i-1][j-1];

			// If last character are different, consider all
			// possibilities and find minimum
			else
				dp[i][j] = 1 + min(dp[i][j-1],  // Insert
						dp[i-1][j],  // Remove
						dp[i-1][j-1]); // Replace
		}
	}

	return dp[m][n];
}



public static void main(String args[])
{
	String str1 = "sunday";
	String str2 = "saturday";
	System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) );
}
}
