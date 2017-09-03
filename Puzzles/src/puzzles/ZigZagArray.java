package puzzles;

import java.util.Arrays;

public class ZigZagArray {
//convert the array into this a<b>c<d>e
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4, 3, 7, 8, 6, 2, 1};
		/*
		 * We can convert in O(n) time using an Efficient Approach. 
		 * The idea is to use modified one pass of bubble sort. 
		 * Maintain a flag for representing which order(i.e. < or >) currently we need. 
		 * If the current two elements are not in that order then swap those elements otherwise not.
		 	Let us see the main logic using three consecutive elements A, B, C. 
		 	Suppose we are processing B and C currently and the current relation is ‘<'. 
		 	But we have B > C. Since current relation is ‘<' previous relation must be '>‘ i.e., 
		 	A must be greater than B. So, the relation is A > B and B > C. 
		 	We can deduce A > C. So if we swap B and C then the relation is A > C and C < B. 
		 	Finally we get the desired order A C B
		 */
		for(int i=0;i<arr.length-2;i++)
		{
			if(i%2==0)//for > case
			{
				if(arr[i]>arr[i+1])
					swap(arr, i, i+1);
			}
			else // for < case
			{
				if(arr[i]<arr[i+1])
					swap(arr, i, i+1);
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int []arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;
	}
}
