package pack;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] ={4,5,6,7,8,3,21,2,3,4,1,12,12,14,12,12,1,2,45,1,21,5,1};
System.out.println(Arrays.toString(arr));		
	new QuickSort().sort(arr, 0, arr.length-1);
	System.out.println(Arrays.toString(arr));		
		
	}

	
	private void sort(int []arr,int start,int end){
		
		if(start<end){
			int pIndex=partition(arr, start, end);
			sort(arr, start, pIndex-1);
			sort(arr, pIndex+1,end);
		}
	}
	
	private int partition(int []arr,int start,int end){
		int pivot=end;
		int pIndex=start;
		for(int i=start;i<end;i++)
		{
			if(arr[i]<arr[pivot])
			{
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		
		swap(arr, pivot, pIndex);
		
		
		return pIndex;
	}
	
	
	public void swap(int arr[],int x,int y)
	{
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
}
