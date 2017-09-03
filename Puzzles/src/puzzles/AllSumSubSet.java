package puzzles;

import java.util.HashSet;

public class AllSumSubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = new int[]{1,2,3,4,5};
		allSubsetSum(arr, 0, new HashSet<>(), 0, 9);
	}

	public static void allSubsetSum(int []arr,int index,HashSet<Integer> set,int sum,int target)
	{
		
		if(index >=arr.length)
		{
			if(sum==target)
				{
				System.out.println(set);
				}
		return;
		}
		HashSet<Integer> include = new HashSet<>(set);
		include.add(arr[index]);
		allSubsetSum(arr, index+1, include, sum+arr[index], target);
		allSubsetSum(arr, index+1, new HashSet<>(set), sum, target);
		
		sum = sum+arr[index];
		
	}
	
}
