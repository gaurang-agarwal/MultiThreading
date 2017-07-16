package com;

import java.util.Arrays;

public class SortPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr []={1,3,54,23,5,3,4,5,4,3,23,32,4,65,23,21,53,6,21,32,4,6,3,12,4,56};
		//System.out.println(Arrays.toString(arr));
		
		//new SortPrac().QuickSort(arr, 0, arr.length-1);
		//new SortPrac().mergeSort(arr);
		//System.out.println(Arrays.toString(arr));
		new SortPrac().countSort(arr, 65);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	private void countSort(int arr[],int max)
	{
		
		int countArr[]= new int[max+1];
		
		for(int i=0;i<arr.length;i++)
		{
			countArr[arr[i]]=++countArr[arr[i]]; 
		}
		
		for(int i=1;i<countArr.length;i++)
		{
			countArr[i]=countArr[i]+countArr[i-1];
		}
		
		int resultArr[] = new int [arr.length];
		
		//System.out.println(Arrays.toString(countArr));
		
		for(int i=0;i<resultArr.length;i++)
		{
			resultArr[countArr[arr[i]]-1]=arr[i];
			countArr[arr[i]]=--countArr[arr[i]];
			
		}
		
		System.out.println(Arrays.toString(resultArr));
		
		
		
	}
	
	
	private void mergeSort(int arr[])
	{
		if(arr.length>1)
		{
			
			int mid = arr.length/2;
			int []left = new int[mid];
			for(int i=0;i<mid;i++)
			{
				left[i]=arr[i];
			}
			int right[] = new int[arr.length-mid];
			for(int i=mid;i<arr.length;i++){
				right[i-mid]=arr[i];
			}
			
			//System.out.println("Left::"+Arrays.toString(left)+"::Right::"+Arrays.toString(right));
			
			mergeSort(left);
			mergeSort(right);
			merge(arr, left, right);
		}
	}
	
	private void merge(int arr[],int left[],int right[])
	{
		
		int l =0;
		int r = 0;
		int counter=0;
		while(l<left.length && r<right.length)
		{
			if(left[l]<right[r])
				arr[counter++]=left[l++];
			else
				arr[counter++]=right[r++];
		}
		while(l<left.length)
		{
				arr[counter++]=left[l++];
		}
		while(r<right.length)
		{
				arr[counter++]=right[r++];
		}
		
		
		
	}
	
	
	
	private void QuickSort(int []arr,int start,int end)
	{
		if(start<end)
		{
			int pIndex = parition(arr, start, end);
			QuickSort(arr, start, pIndex-1);
			QuickSort(arr, pIndex+1,end);
		}
	}
	
	private int parition(int []arr,int start,int end)
	{
		
		int pivot = arr[end];
		int pIndex=start;
		while(start<end)
		{
			
			if(arr[start]<pivot)
			{
				swap(arr,start,pIndex);
				pIndex++;
			}
			start++;
		}
		
		swap(arr, pIndex, end);
		
		return pIndex;
		
	}


	private void swap(int[] arr, int start, int pIndex) {
		// TODO Auto-generated method stub
		
		int temp = arr[start];
		arr[start]=arr[pIndex];
		arr[pIndex]=temp;
		
	}

}
