package pack;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr [] = {5,3,1,2,3,4,10,6,0};
		//new Sort().QuickSort(arr, 0, arr.length-1); 
		new Sort().InsertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
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
}
