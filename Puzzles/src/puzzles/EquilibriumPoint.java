package puzzles;

import java.util.Arrays;

public class EquilibriumPoint {
/*
 * Given an array A your task is to tell at which position the equilibrium first occurs in the array. 
 * Equilibrium position in an array is a position such that the sum of elements below it is equal 
 * to the sum of elements after it.
 * http://practice.geeksforgeeks.org/problems/equilibrium-point/0
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr ={ 1, 1,1,1, 5, 2, 2};
		int leftSum [] = Arrays.copyOf(arr, arr.length);
		int rightSum []= Arrays.copyOf(arr, arr.length);
		for(int i=1;i<arr.length;i++)
		{
			leftSum[i]=leftSum[i]+leftSum[i-1];
		}
		for(int i=arr.length-2;i>=0;i--)
		{
			rightSum[i]=rightSum[i]+rightSum[i+1];
		}
	for(int i=0;i<arr.length;i++)
	{
		if(leftSum[i] == rightSum[i])
			System.out.println("Equilibrium exists at "+i);
	}
	}
	
	

}
