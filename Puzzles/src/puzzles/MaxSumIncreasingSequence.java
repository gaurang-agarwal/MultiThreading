package puzzles;

import java.util.Arrays;
//http://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
public class MaxSumIncreasingSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,101,2,3,100,4,5};
		int temp [] = Arrays.copyOf(arr, arr.length);
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
					temp[i]=temp[i]+arr[j];
			}
		}
		
		System.out.println(Arrays.toString(temp));
	}

}
