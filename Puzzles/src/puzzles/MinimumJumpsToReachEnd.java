package puzzles;
//http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
/*
 * Given an array of integers where each element represents the max number of steps that can be made forward
 *  from that element. Write a function to return the minimum number of jumps 
 *  to reach the end of the array (starting from the first element). 
 *  If an element is 0, then cannot move through that element.

	Example:
	Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
	Output: 3 (1-> 3 -> 8 ->9)

	First element is 1, so can only go to 3. Second element is 3, 
	so can make at most 3 steps eg to 5 or 8 or 9.
 */

import java.util.Arrays;
public class MinimumJumpsToReachEnd {
	public static void main(String[] args) {
		int arr[] = {2,3,1,1,2,4,2,0,1,1};
		int jumpCount[] = new int[arr.length];
		int jumpPos[] = new int[arr.length];
		jumpPos[0]=-1;
		for(int i =1;i<arr.length;i++){
			jumpCount[i]= Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(j+arr[j] >=i){//checking if we can reach i from j
					//jumpCount[i]= Math.min(jumpCount[i], (jumpCount[j]+1));
					if(jumpCount[i] > (jumpCount[j]+1))
					{
						jumpCount[i]=(jumpCount[j]+1);
						jumpPos[i]=j;
					}
				}
			}
		}
		System.out.println(Arrays.toString(jumpCount));
		System.out.println(Arrays.toString(jumpPos));
		System.out.println(jumpCount[arr.length-1]);
		int end = jumpPos.length-1;
		while(end>=0){
		System.out.print(arr[end]+"<-");
		end = jumpPos[end];
		}
		}

}
