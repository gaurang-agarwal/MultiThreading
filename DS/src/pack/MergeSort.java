package pack;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] ={4,5,6,7,8,3,21,2,3,4,1,12,12,14,12,12,1,2,45,1,21,5,1};
		//int arr[] ={2,4,1,6,8,5,3,7};
		System.out.println(Arrays.toString(arr));		
			new MergeSort().sort(arr);
			System.out.println(Arrays.toString(arr));
	}



	public void sort(int arr[]){
		
if(arr.length>1){
	int mid=arr.length/2;
	int left[]=new int[mid];
	int []right = new int[arr.length-mid];
	
	for(int i=0;i<left.length;i++){
		left[i]=arr[i];
	}
	for(int i=mid;i<arr.length;i++){
		right[i-mid]=arr[i];
	}
	sort(right);
	sort(left);
	merge(arr, left, right);
	
}


	}


	public void merge(int arr[],int left[],int []right)
	{
		int l=0;
		int r=0;
		int count=0;
		while(l<left.length && r<right.length)
		{
			if(left[l]<right[r])
			{
				arr[count++]=left[l++];	
			}
			else
				arr[count++]=right[r++];
		}
		while(l<left.length)
		{
			arr[count++]=left[l++];
		}
		while(r<right.length)
		{
			arr[count++]=right[r++];	
		}
		System.out.println("End of Array:::"+Arrays.toString(arr));

	}



}
