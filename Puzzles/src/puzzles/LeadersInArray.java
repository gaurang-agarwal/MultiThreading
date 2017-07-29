package puzzles;

public class LeadersInArray {
	/*
	 * An element is leader if it is greater than all the elements to its right side. 
	 * The rightmost element is always a leader. 
	 * http://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
	 */
	public static void main(String[] args) 
	{
		int arr []={16,17,4,3,5,2};
		int currentLeader = arr[arr.length-1];
		System.out.println(currentLeader);
		for(int i=arr.length-2;i>=0;i--)
		{
			if(arr[i]>currentLeader)
			{
				currentLeader=arr[i];
				System.out.println(currentLeader);
			}
			
		}
	}

}
