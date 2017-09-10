package puzzles;

import java.util.Arrays;

/*
 * https://www.youtube.com/watch?v=s6FhG--P7z0
 * http://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 */
public class SubArrayWithGivenSumDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target=11;
		int [] arr = new int[]{2,3,7,8,10};
		boolean resultMatrix[][] = new boolean[arr.length+1][target+1];
		
		for(int i=0;i<=arr.length;i++)
			resultMatrix[i][0]=true;
		
		for(int i=1;i<=target;i++)
			resultMatrix[0][i]=false;
		
		
		for(int i =1;i<=arr.length;i++)
		{
			for(int j =1;j<=target;j++)
			{
				if(arr[i-1] > j)
				{
					resultMatrix[i][j]=resultMatrix[i-1][j];
				}
				else
				{
					resultMatrix[i][j]=resultMatrix[i-1][j-arr[i-1]] ||  resultMatrix[i-1][j];
					//System.out.println("Copying from"+"["+(i-1)+"]["+(j-arr[i-1])+"]"+"--"+j+"--"+arr[i-1]);
				}
			}
			System.out.println(arr[i-1]+"->"+Arrays.toString(resultMatrix[i]));
		}
		
		
	}

}
