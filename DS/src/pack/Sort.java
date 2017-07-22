package pack;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr [] = {5,3,1,5,1,2,3,2,3,4,10,6,0};
		new Sort().heapSort(arr);
		//new Sort().QuickSort(arr, 0, arr.length-1); 
		//new Sort().CountSort(arr);
		
	}

	
	
	void CountSort(int arr[])
	{
		int max=10;
		int countArr[] = new int[max+1];
		for(int i=0;i<arr.length;i++)
		{
			countArr[arr[i]]=countArr[arr[i]]+1;
		}
		//System.out.println("Count Arr : "+Arrays.toString(countArr));
		for(int i=1;i<countArr.length;i++)
		{
			countArr[i]=countArr[i]+countArr[i-1];
		}
		//System.out.println("Count Arr : "+Arrays.toString(countArr));
		int output[] = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			output[countArr[arr[i]]-1] = arr[i];
	        --countArr[arr[i]];
		}
		System.out.println(""+Arrays.toString(output));
		
	}
	void InsertionSort(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			int temp = arr[i];
			int j=i-1;
			while(j>=0&&arr[j]>temp)
			{
				arr[j+1]=arr[j--];
				
			}
			arr[j+1]=temp;
		}
		
	}
	
	void QuickSort(int arr[],int start,int end)
	{
		if(start<end)
		{
			int pIndex = parition(arr, start, end);
			QuickSort(arr, start, pIndex-1);
			QuickSort(arr, pIndex+1, end);
		}
		
	}
	
	
	int parition (int []arr,int start,int end)
	{
		int pivot=arr[end];
		
		int pIndex = start;
		
		for(int i=start;i<end;i++)
		{
			if(arr[i]<=pivot)
			{
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		
		swap(arr, pIndex, end);
		
		System.out.println("arr::"+Arrays.toString(arr));
		return pIndex;
		
		
	}
	
	private void swap(int arr[],int source,int destitiotion)
	{
		int temp = arr[destitiotion];
		arr[destitiotion] =arr[source]; 
		arr[source] = temp;
		
	}
	
	
	
	void MergeSort(int arr[])
	{
		if(arr.length>1)
		{
		
			int mid= arr.length/2;
			int left[] = new int [mid]; 
			int right[] = new int [arr.length-mid];
			
			for(int i=0;i<left.length;i++)
			{
				left[i]=arr[i];
			}
			for(int i=0;i<right.length;i++)
			{
				right[i]=arr[mid+i];
			}
			
			System.out.println("Left:"+Arrays.toString(left)+"  Right:"+Arrays.toString(right));
			
			MergeSort(left);
			MergeSort(right);
			merge(arr,left,right);
		}	
	}
	
	void merge(int arr[],int left[],int right[])
	{
		int l=0;
		int r=0;
		int counter=0;
		while(l<left.length && r<right.length)
		{
			if(left[l]<=right[r])
			{
				arr[counter++]=left[l++];
			}else
			{
				arr[counter++]=right[r++];
			}
			
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
	
	
	public void heapSort(int arr[])
	{
		for(int i=arr.length/2;i>=0;i--)
		{
			moveDown(arr, arr.length, i);
		}
		for(int i=arr.length-1;i>=0;i--)
		{
			swap(arr, 0, i);
			moveDown(arr, i, 0);
		}
		System.out.println("final"+Arrays.toString(arr));
	}
	private void moveDown(int arr[],int size,int pos)
	{
		int i = pos;
		if(getLeft(pos) < size &&  arr[getLeft(pos)] > arr[pos] )
		{
			i = getLeft(pos);
		}
		if(getRight(pos) < size &&  arr[getRight(pos)] > arr[i] )
		{
			i = getRight(pos);
		}
		if(i!=pos)
		{
			swap(arr, i, pos);
			moveDown(arr, size, i);
		}
		
	}
	
	private int getLeft(int i)
	{
		return 2*i+1;
	}
	private int getRight(int i)
	{
		return 2*i+2;
	}
	
	
}
