package puzzles;

import java.util.Scanner;

public class ReverseArrayInGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0)
		{
			int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++)
			arr[i]= sc.nextInt();
		int k = sc.nextInt();
		int pairs=arr.length/k;
		int pairsSwapped =0;
		while(pairsSwapped<pairs)
		{
			swapSubArray(arr, pairsSwapped*k, pairsSwapped*k + k -1);
					
					pairsSwapped++;
		}
		if(pairsSwapped*k != arr.length)
		{
			swapSubArray(arr, pairsSwapped*k, arr.length-1);
		}
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
		}
	}

	private static void swapSubArray(int arr[],int start,int end)
	{
		while(start<end)
		{
			swap(arr, start++, end--);
		}
	}
	
	private static void swap(int []arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;
	}
}
