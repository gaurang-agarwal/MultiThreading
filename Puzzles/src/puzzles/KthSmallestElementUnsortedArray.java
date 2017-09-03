package puzzles;

//Runnint time complexity of this array is O(n)

public class KthSmallestElementUnsortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]={5,1,9,2,4,8,7,3,6,0};
		System.out.println(kthSmallestElement(arr, 0, arr.length-1, 5));
		
		
	}
	
	
	private static int kthSmallestElement(int []arr,int start,int end,int k)
	{
		int p = partition(arr,start,end);
		if(start<end)
		{
			if(p==k)
				return p;
			
			if(k<p)
			{
				return kthSmallestElement(arr, start, p-1, k);
			}
			else
			{
				return kthSmallestElement(arr, p+1, end, k);
			}
			
			
		}
		
		return p;
	}


	private static int partition(int[] arr, int start, int end) {
		int pIndex=start;
		int pivot =arr[end];
		while(start<=end)
		{
			if(arr[start]<pivot)
			{
				swap(arr,start,pIndex);
				pIndex++;
			}
			start++;
		}
		swap(arr,end,pIndex);
		return pIndex;
	}


	private static void swap(int[] arr, int start, int pIndex) {
		int temp = arr[start];
		arr[start]=arr[pIndex];
		arr[pIndex]=temp;
		
	}
	
	
}
