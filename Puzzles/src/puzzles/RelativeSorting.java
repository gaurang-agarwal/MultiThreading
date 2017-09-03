package puzzles;
/*
 * Given two array A1[] and A2[], 
 * sort A1 in such a way that the relative order among the elements will be same as those  in A2. 
 * For the elements not present in A2. Append them at last in sorted order. 
 * It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] 
 * and A2[] has all distinct elements.

Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
       A2[] = {2, 1, 8, 3}
Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}

Since 2 is present first in A2[], 
all occurrences of 2s should appear first in A[], 
then all occurrences 1s as 1 comes after 2 in A[]. 
Next all occurrences of 8 and then all occurrences of 3.  
Finally we print all those elements of A1[] that are not present in A2[]
 */

import java.util.Arrays;

public class RelativeSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int A2[] = {2, 1, 8, 3};
		int start=0;
		int end = A1.length-1;
		for(int a:A2)
		{
			for(int i=start;i<A1.length;i++)
			{
				if(A1[i]==a)
				{
					swap(A1, i, start);
				start++;
				}
			}
		}
		System.out.println(Arrays.toString(A1));
		
		
	}

	
	private static void swap(int []arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;
	}
}
