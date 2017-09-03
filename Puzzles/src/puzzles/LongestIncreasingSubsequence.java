package puzzles;

import java.util.Arrays;
//http://www.geeksforgeeks.org/longest-increasing-subsequence/
//https://www.youtube.com/watch?v=SZByPn0deMY&index=2&list=PLlhDxqlV_-vkak9feCSrnjlrnzzzcopSG
//https://www.youtube.com/watch?v=Ns4LCeeOFS4
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {10, 22, 9, 33, 21, 50, 41, 60 };
		
		int list[] = new int[arr.length];
		
		String lisPath[] = new String[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			list[i] = 1;
			lisPath[i]= arr[i]+" ";
		}
		int maxIndex =0;
		int maxCount=0;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j] && list[i] < list[j]+1)
					{	
						list[i] = list[j]+1;
						lisPath[i] =  lisPath[j]+arr[i]+" ";
					}
			}
			if(maxCount < list[i])
			{
				maxCount=list[i];
				maxIndex=i;
			}
		}
		System.out.println(Arrays.toString(lisPath));
		System.out.println(maxIndex);
	System.out.println(lisPath[maxIndex]);	
		
	}

}
